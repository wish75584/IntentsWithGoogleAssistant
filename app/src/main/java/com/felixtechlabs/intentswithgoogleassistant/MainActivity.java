package com.felixtechlabs.intentswithgoogleassistant;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        String appLinkAction = intent.getAction();
        Uri appLinkData = intent.getData();


        if (Intent.ACTION_VIEW.equals(appLinkAction) && appLinkData != null) {
            String appFeature = appLinkData.getQueryParameter("featureName");
            if (appFeature != null && appFeature.contains("/open")) {
                //startActivity or do something
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));

            } else if (Intent.ACTION_VIEW.equals(appLinkAction) && appLinkData != null) {
                String appFeature2 = appLinkData.getQueryParameter("featureName");
                if (appFeature2 != null && appFeature.contains("/open")) {
                    //startActivity or do something
                    startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                }
            }
        }
    }
}
