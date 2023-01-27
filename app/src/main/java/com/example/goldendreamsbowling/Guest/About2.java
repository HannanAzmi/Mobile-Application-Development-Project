package com.example.goldendreamsbowling.Guest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.goldendreamsbowling.MapsActivity;
import com.example.goldendreamsbowling.R;
import com.example.goldendreamsbowling.databinding.ActivityAbout2Binding;

public class About2 extends DrawerGuest {

    ActivityAbout2Binding activityAboutusFragmentBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAboutusFragmentBinding = activityAboutusFragmentBinding.inflate(getLayoutInflater());
        setContentView(activityAboutusFragmentBinding.getRoot());
        allocateActivityTitle("About Us");


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(About2.this, MapsActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainInterface.class));
        overridePendingTransition(0,0);
        finish();
    }
}