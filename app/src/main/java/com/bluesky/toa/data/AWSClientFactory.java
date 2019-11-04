package com.bluesky.toa.data;

import android.content.Context;

import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.amazonaws.mobileconnectors.appsync.sigv4.APIKeyAuthProvider;
import com.amazonaws.mobileconnectors.appsync.sigv4.BasicAPIKeyAuthProvider;
import com.amazonaws.regions.Regions;

public class AWSClientFactory {

    private static volatile AWSAppSyncClient client;

    public static synchronized void init(final Context context) {

        if (client == null) {
            final AWSConfiguration awsConfiguration = new AWSConfiguration(context);
            final APIKeyAuthProvider apiKey = new BasicAPIKeyAuthProvider(awsConfiguration);

            client = AWSAppSyncClient.builder()
                    .context(context)
                    .region(Regions.US_EAST_2)
                    .awsConfiguration(awsConfiguration)
                    .apiKey(apiKey)
                    .build();
        }
    }

    public static synchronized AWSAppSyncClient appSyncClient() {
        return client;
    }
}
