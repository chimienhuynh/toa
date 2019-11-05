package com.bluesky.toa;

import android.content.Context;
import android.util.Log;

import com.amazonaws.amplify.generated.graphql.CreateProfileMutation;
import com.amazonaws.amplify.generated.graphql.ListProfilesQuery;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.amazonaws.mobileconnectors.appsync.AppSyncSubscriptionCall;
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers;
import com.apollographql.apollo.GraphQLCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.bluesky.toa.data.utils.AWSClientFactory;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.UUID;

import javax.annotation.Nonnull;

import androidx.test.InstrumentationRegistry;
import type.CreateProfileInput;

public class CrudTest extends TestCase {

    private AWSAppSyncClient mAWSAppSyncClient = null;
    private AppSyncSubscriptionCall subscriptionWatcher;

    protected void setUp() {
        Context context = InstrumentationRegistry.getTargetContext();
        AWSClientFactory.init(context);
        mAWSAppSyncClient = AWSClientFactory.appSyncClient();
    }

    @Test
    public void testMutation() {
        CreateProfileInput createProfileInput = CreateProfileInput.builder()
                .id(UUID.randomUUID().toString())
                .firstName("John")
                .lastName("Wayne")
                .build();

        mAWSAppSyncClient.mutate(CreateProfileMutation.builder().input(createProfileInput).build())
                .enqueue(profileMutationCallback);
    }

    private GraphQLCall.Callback<CreateProfileMutation.Data> profileMutationCallback = new GraphQLCall.Callback<CreateProfileMutation.Data>() {
        @Override
        public void onResponse(@Nonnull Response<CreateProfileMutation.Data> response) {
            Log.i("Results", "Added Profile");
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("Error", e.toString());
        }
    };

    @Test
    public void testQuery(){
        mAWSAppSyncClient.query(ListProfilesQuery.builder().build())
                .responseFetcher(AppSyncResponseFetchers.CACHE_AND_NETWORK)
                .enqueue(profilesQueryCallback);
    }

    private GraphQLCall.Callback<ListProfilesQuery.Data> profilesQueryCallback = new GraphQLCall.Callback<ListProfilesQuery.Data>() {
        @Override
        public void onResponse(@Nonnull Response<ListProfilesQuery.Data> response) {
            Log.i("Results", response.data().listProfiles().items().toString());
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("ERROR", e.toString());
        }
    };
}
