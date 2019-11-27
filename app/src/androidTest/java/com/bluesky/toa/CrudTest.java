package com.bluesky.toa;

import android.content.Context;
import android.util.Log;

import com.amazonaws.amplify.generated.graphql.CreateAccountMutation;
import com.amazonaws.amplify.generated.graphql.CreateCommentMutation;
import com.amazonaws.amplify.generated.graphql.CreatePostMutation;
import com.amazonaws.amplify.generated.graphql.CreateProfileMutation;
import com.amazonaws.amplify.generated.graphql.DeleteAccountMutation;
import com.amazonaws.amplify.generated.graphql.DeleteCommentMutation;
import com.amazonaws.amplify.generated.graphql.DeletePostMutation;
import com.amazonaws.amplify.generated.graphql.DeleteProfileMutation;
import com.amazonaws.amplify.generated.graphql.GetAccountQuery;
import com.amazonaws.amplify.generated.graphql.GetCommentQuery;
import com.amazonaws.amplify.generated.graphql.GetPostQuery;
import com.amazonaws.amplify.generated.graphql.GetProfileQuery;
import com.amazonaws.amplify.generated.graphql.ListAccountsQuery;
import com.amazonaws.amplify.generated.graphql.ListCommentsQuery;
import com.amazonaws.amplify.generated.graphql.ListPostsQuery;
import com.amazonaws.amplify.generated.graphql.ListProfilesQuery;
import com.amazonaws.amplify.generated.graphql.UpdateAccountMutation;
import com.amazonaws.amplify.generated.graphql.UpdateCommentMutation;
import com.amazonaws.amplify.generated.graphql.UpdatePostMutation;
import com.amazonaws.amplify.generated.graphql.UpdateProfileMutation;
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
import type.CreateAccountInput;
import type.CreateCommentInput;
import type.CreatePostInput;
import type.CreateProfileInput;
import type.DeleteAccountInput;
import type.DeleteCommentInput;
import type.DeletePostInput;
import type.DeleteProfileInput;
import type.UpdateAccountInput;
import type.UpdateCommentInput;
import type.UpdatePostInput;
import type.UpdateProfileInput;

public class CrudTest extends TestCase {

    private AWSAppSyncClient mAWSAppSyncClient = null;
    private AppSyncSubscriptionCall subscriptionWatcher;

    protected void setUp() {
        Context context = InstrumentationRegistry.getTargetContext();
        AWSClientFactory.init(context);
        mAWSAppSyncClient = AWSClientFactory.appSyncClient();
    }

    @Test
    public void testGetProfileFail() {
        mAWSAppSyncClient.query(
                GetProfileQuery.builder()
                    .id(UUID.randomUUID().toString())
                    .build()
        ).enqueue(getProfileFailCallback);
    }

    private GraphQLCall.Callback<GetProfileQuery.Data> getProfileFailCallback = new GraphQLCall.Callback<GetProfileQuery.Data>() {
        @Override
        public void onResponse(@Nonnull Response<GetProfileQuery.Data> response) {
            fail();
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("ERROR", e.toString());
        }
    };

    @Test
    public void testCreateProfile() {
        CreateProfileInput createProfileInput = CreateProfileInput.builder()
                .id("1")
                .firstName("John")
                .lastName("Wayne")
                .build();

        mAWSAppSyncClient.mutate(CreateProfileMutation.builder().input(createProfileInput).build())
                .enqueue(createProfileCallback);
    }

    private GraphQLCall.Callback<CreateProfileMutation.Data> createProfileCallback = new GraphQLCall.Callback<CreateProfileMutation.Data>() {
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
    public void testUpdateProfile() {
        UpdateProfileInput updateProfileInput = UpdateProfileInput.builder()
                .id("1")
                .city("Ottawa")
                .build();

        mAWSAppSyncClient.mutate(UpdateProfileMutation.builder().input(updateProfileInput).build())
            .enqueue(updateProfileCallback);
    }

    private GraphQLCall.Callback<UpdateProfileMutation.Data> updateProfileCallback = new GraphQLCall.Callback<UpdateProfileMutation.Data>() {
        @Override
        public void onResponse(@Nonnull Response<UpdateProfileMutation.Data> response) {
            Log.i("Results", "Updated Profile");
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("Error", e.toString());
        }
    };

    @Test
    public void testGetProfile(){
        mAWSAppSyncClient.query(
                GetProfileQuery.builder()
                        .id("1")
                        .build()
        ).enqueue(getProfileFailCallback);
    }

    private GraphQLCall.Callback<GetProfileQuery.Data> getProfileCallback = new GraphQLCall.Callback<GetProfileQuery.Data>() {
        @Override
        public void onResponse(@Nonnull Response<GetProfileQuery.Data> response) {
            Log.i("Result", response.toString());
            assertNotNull(response);
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("ERROR", e.toString());
        }
    };

    @Test
    public void testDeleteProfile() {
        DeleteProfileInput deleteProfileInput = DeleteProfileInput.builder().id("1").build();

        mAWSAppSyncClient.mutate(DeleteProfileMutation.builder().input(deleteProfileInput).build()).enqueue(deleteProfileCallback);
    }

    private GraphQLCall.Callback<DeleteProfileMutation.Data> deleteProfileCallback = new GraphQLCall.Callback<DeleteProfileMutation.Data>() {
        @Override
        public void onResponse(@Nonnull Response<DeleteProfileMutation.Data> response) {
            Log.i("Results", "Deleted Profile");
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("Error", e.toString());
        }
    };

    @Test
    public void testListProfile() {
        mAWSAppSyncClient.query(ListProfilesQuery.builder().build())
                .responseFetcher(AppSyncResponseFetchers.CACHE_AND_NETWORK)
                .enqueue(listProfilesCallback);
    }

    private GraphQLCall.Callback<ListProfilesQuery.Data> listProfilesCallback = new GraphQLCall.Callback<ListProfilesQuery.Data>() {
        @Override
        public void onResponse(@Nonnull Response<ListProfilesQuery.Data> response) {
            Log.i("Results", response.data().listProfiles().items().toString());
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("ERROR", e.toString());
        }
    };

    @Test
    public void testGetPostFail() {
        mAWSAppSyncClient.query(
                GetPostQuery.builder()
                        .id(UUID.randomUUID().toString())
                        .build()
        ).enqueue(getPostFailCallback);
    }

    private GraphQLCall.Callback<GetPostQuery.Data> getPostFailCallback = new GraphQLCall.Callback<GetPostQuery.Data>() {
        @Override
        public void onResponse(@Nonnull Response<GetPostQuery.Data> response) {
            fail();
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("ERROR", e.toString());
        }
    };

    @Test
    public void testCreatePost() {
        CreatePostInput createPostInput = CreatePostInput.builder()
                .id("1")
                .content("XYZ")
                .build();

        mAWSAppSyncClient.mutate(CreatePostMutation.builder().input(createPostInput).build())
                .enqueue(createPostCallback);
    }

    private GraphQLCall.Callback<CreatePostMutation.Data> createPostCallback = new GraphQLCall.Callback<CreatePostMutation.Data>() {
        @Override
        public void onResponse(@Nonnull Response<CreatePostMutation.Data> response) {
            Log.i("Results", "Added Post");
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("Error", e.toString());
        }
    };

    @Test
    public void testUpdatePost() {
        UpdatePostInput updatePostInput = UpdatePostInput.builder()
                .id("1")
                .content("ABC")
                .build();

        mAWSAppSyncClient.mutate(UpdatePostMutation.builder().input(updatePostInput).build())
                .enqueue(updatePostCallback);
    }

    private GraphQLCall.Callback<UpdatePostMutation.Data> updatePostCallback = new GraphQLCall.Callback<UpdatePostMutation.Data>() {
        @Override
        public void onResponse(@Nonnull Response<UpdatePostMutation.Data> response) {
            Log.i("Results", "Updated Post");
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("Error", e.toString());
        }
    };

    @Test
    public void testGetPost(){
        mAWSAppSyncClient.query(
                GetPostQuery.builder()
                        .id("1")
                        .build()
        ).enqueue(getPostFailCallback);
    }

    private GraphQLCall.Callback<GetPostQuery.Data> getPostCallback = new GraphQLCall.Callback<GetPostQuery.Data>() {
        @Override
        public void onResponse(@Nonnull Response<GetPostQuery.Data> response) {
            Log.i("Result", response.toString());
            assertNotNull(response);
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("ERROR", e.toString());
        }
    };

    @Test
    public void testDeletePost() {
        DeletePostInput deletePostInput = DeletePostInput.builder().id("1").build();

        mAWSAppSyncClient.mutate(DeletePostMutation.builder().input(deletePostInput).build()).enqueue(deletePostCallback);
    }

    private GraphQLCall.Callback<DeletePostMutation.Data> deletePostCallback = new GraphQLCall.Callback<DeletePostMutation.Data>() {
        @Override
        public void onResponse(@Nonnull Response<DeletePostMutation.Data> response) {
            Log.i("Results", "Deleted Post");
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("Error", e.toString());
        }
    };

    @Test
    public void testListPost() {
        mAWSAppSyncClient.query(ListPostsQuery.builder().build())
                .responseFetcher(AppSyncResponseFetchers.CACHE_AND_NETWORK)
                .enqueue(listPostsCallback);
    }

    private GraphQLCall.Callback<ListPostsQuery.Data> listPostsCallback = new GraphQLCall.Callback<ListPostsQuery.Data>() {
        @Override
        public void onResponse(@Nonnull Response<ListPostsQuery.Data> response) {
            Log.i("Results", response.data().listPosts().items().toString());
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("ERROR", e.toString());
        }
    };

    @Test
    public void testGetAccountFail() {
        mAWSAppSyncClient.query(
                GetAccountQuery.builder()
                        .id(UUID.randomUUID().toString())
                        .build()
        ).enqueue(getAccountFailCallback);
    }

    private GraphQLCall.Callback<GetAccountQuery.Data> getAccountFailCallback = new GraphQLCall.Callback<GetAccountQuery.Data>() {
        @Override
        public void onResponse(@Nonnull Response<GetAccountQuery.Data> response) {
            fail();
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("ERROR", e.toString());
        }
    };

    @Test
    public void testCreateAccount() {
        CreateAccountInput createAccountInput = CreateAccountInput.builder()
                .id("1")
                .username("ABC_GURU")
                .password("Password123")
                .email("abc@algonquinlive.com")
                .build();

        mAWSAppSyncClient.mutate(CreateAccountMutation.builder().input(createAccountInput).build())
                .enqueue(createAccountCallback);
    }

    private GraphQLCall.Callback<CreateAccountMutation.Data> createAccountCallback = new GraphQLCall.Callback<CreateAccountMutation.Data>() {
        @Override
        public void onResponse(@Nonnull Response<CreateAccountMutation.Data> response) {
            Log.i("Results", "Added Account");
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("Error", e.toString());
        }
    };

    @Test
    public void testUpdateAccount() {
        UpdateAccountInput updateAccountInput = UpdateAccountInput.builder()
                .id("1")
                .email("ABC")
                .build();

        mAWSAppSyncClient.mutate(UpdateAccountMutation.builder().input(updateAccountInput).build())
                .enqueue(updateAccountCallback);
    }

    private GraphQLCall.Callback<UpdateAccountMutation.Data> updateAccountCallback = new GraphQLCall.Callback<UpdateAccountMutation.Data>() {
        @Override
        public void onResponse(@Nonnull Response<UpdateAccountMutation.Data> response) {
            Log.i("Results", "Updated Account");
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("Error", e.toString());
        }
    };

    @Test
    public void testGetAccount(){
        mAWSAppSyncClient.query(
                GetAccountQuery.builder()
                        .id("1")
                        .build()
        ).enqueue(getAccountFailCallback);
    }

    private GraphQLCall.Callback<GetAccountQuery.Data> getAccountCallback = new GraphQLCall.Callback<GetAccountQuery.Data>() {
        @Override
        public void onResponse(@Nonnull Response<GetAccountQuery.Data> response) {
            Log.i("Result", response.toString());
            assertNotNull(response);
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("ERROR", e.toString());
        }
    };

    @Test
    public void testDeleteAccount() {
        DeleteAccountInput deleteAccountInput = DeleteAccountInput.builder().id("1").build();

        mAWSAppSyncClient.mutate(DeleteAccountMutation.builder().input(deleteAccountInput).build()).enqueue(deleteAccountCallback);
    }

    private GraphQLCall.Callback<DeleteAccountMutation.Data> deleteAccountCallback = new GraphQLCall.Callback<DeleteAccountMutation.Data>() {
        @Override
        public void onResponse(@Nonnull Response<DeleteAccountMutation.Data> response) {
            Log.i("Results", "Deleted Account");
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("Error", e.toString());
        }
    };

    @Test
    public void testListAccount() {
        mAWSAppSyncClient.query(ListAccountsQuery.builder().build())
                .responseFetcher(AppSyncResponseFetchers.CACHE_AND_NETWORK)
                .enqueue(listAccountsCallback);
    }

    private GraphQLCall.Callback<ListAccountsQuery.Data> listAccountsCallback = new GraphQLCall.Callback<ListAccountsQuery.Data>() {
        @Override
        public void onResponse(@Nonnull Response<ListAccountsQuery.Data> response) {
            Log.i("Results", response.data().listAccounts().items().toString());
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("ERROR", e.toString());
        }
    };

    @Test
    public void testGetCommentFail() {
        mAWSAppSyncClient.query(
                GetCommentQuery.builder()
                        .id(UUID.randomUUID().toString())
                        .build()
        ).enqueue(getCommentFailCallback);
    }

    private GraphQLCall.Callback<GetCommentQuery.Data> getCommentFailCallback = new GraphQLCall.Callback<GetCommentQuery.Data>() {
        @Override
        public void onResponse(@Nonnull Response<GetCommentQuery.Data> response) {
            fail();
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("ERROR", e.toString());
        }
    };

    @Test
    public void testCreateComment() {
        CreateCommentInput createCommentInput = CreateCommentInput.builder()
                .id("1")
                .content("XYZ")
                .build();

        mAWSAppSyncClient.mutate(CreateCommentMutation.builder().input(createCommentInput).build())
                .enqueue(createCommentCallback);
    }

    private GraphQLCall.Callback<CreateCommentMutation.Data> createCommentCallback = new GraphQLCall.Callback<CreateCommentMutation.Data>() {
        @Override
        public void onResponse(@Nonnull Response<CreateCommentMutation.Data> response) {
            Log.i("Results", "Added Comment");
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("Error", e.toString());
        }
    };

    @Test
    public void testUpdateComment() {
        UpdateCommentInput updateCommentInput = UpdateCommentInput.builder()
                .id("1")
                .content("ABC")
                .build();

        mAWSAppSyncClient.mutate(UpdateCommentMutation.builder().input(updateCommentInput).build())
                .enqueue(updateCommentCallback);
    }

    private GraphQLCall.Callback<UpdateCommentMutation.Data> updateCommentCallback = new GraphQLCall.Callback<UpdateCommentMutation.Data>() {
        @Override
        public void onResponse(@Nonnull Response<UpdateCommentMutation.Data> response) {
            Log.i("Results", "Updated Comment");
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("Error", e.toString());
        }
    };

    @Test
    public void testGetComment(){
        mAWSAppSyncClient.query(
                GetCommentQuery.builder()
                        .id("1")
                        .build()
        ).enqueue(getCommentFailCallback);
    }

    private GraphQLCall.Callback<GetCommentQuery.Data> getCommentCallback = new GraphQLCall.Callback<GetCommentQuery.Data>() {
        @Override
        public void onResponse(@Nonnull Response<GetCommentQuery.Data> response) {
            Log.i("Result", response.toString());
            assertNotNull(response);
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("ERROR", e.toString());
        }
    };

    @Test
    public void testDeleteComment() {
        DeleteCommentInput deleteCommentInput = DeleteCommentInput.builder().id("1").build();

        mAWSAppSyncClient.mutate(DeleteCommentMutation.builder().input(deleteCommentInput).build()).enqueue(deleteCommentCallback);
    }

    private GraphQLCall.Callback<DeleteCommentMutation.Data> deleteCommentCallback = new GraphQLCall.Callback<DeleteCommentMutation.Data>() {
        @Override
        public void onResponse(@Nonnull Response<DeleteCommentMutation.Data> response) {
            Log.i("Results", "Deleted Comment");
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("Error", e.toString());
        }
    };

    @Test
    public void testListComment() {
        mAWSAppSyncClient.query(ListCommentsQuery.builder().build())
                .responseFetcher(AppSyncResponseFetchers.CACHE_AND_NETWORK)
                .enqueue(listCommentsCallback);
    }

    private GraphQLCall.Callback<ListCommentsQuery.Data> listCommentsCallback = new GraphQLCall.Callback<ListCommentsQuery.Data>() {
        @Override
        public void onResponse(@Nonnull Response<ListCommentsQuery.Data> response) {
            Log.i("Results", response.data().listComments().items().toString());
        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("ERROR", e.toString());
        }
    };
}
