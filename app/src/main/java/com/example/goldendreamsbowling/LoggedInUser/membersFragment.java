package com.example.goldendreamsbowling.LoggedInUser;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.goldendreamsbowling.Guest.MainInterface;
import com.example.goldendreamsbowling.HomePage;
import com.example.goldendreamsbowling.Login;
import com.example.goldendreamsbowling.MainActivity;
import com.example.goldendreamsbowling.R;
import com.example.goldendreamsbowling.SubsMember;
import com.example.goldendreamsbowling.databinding.ActivityMembersFragmentBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class membersFragment extends Drawer_base {

    ActivityMembersFragmentBinding activityMembersFragmentBinding;
    FirebaseAuth ID;
    String UID;
    Button Subs;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://workshop2-d8198-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMembersFragmentBinding = activityMembersFragmentBinding.inflate(getLayoutInflater());
        setContentView(activityMembersFragmentBinding.getRoot());

        Subs = findViewById(R.id.subs);
        ID = FirebaseAuth.getInstance();
        UID = ID.getCurrentUser().getUid();
        databaseReference.child("membership").child(UID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final String txtEmail = snapshot.child("Email").getValue().toString();
                final String txtName = snapshot.child("FullName").getValue().toString();
                final String txtStatus = snapshot.child("Status").getValue().toString();

                activityMembersFragmentBinding.welcomeText.setText("Welcome " + txtName + " !!");
                activityMembersFragmentBinding.txtName.setText("Name : " + txtName);
                activityMembersFragmentBinding.txtEmail.setText("Email : " + txtEmail);
                activityMembersFragmentBinding.txtStatus.setText("Status : " + txtStatus);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Subs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Subscription();

            }
        });

    }

    public void Subscription() {
        UID = ID.getCurrentUser().getUid();
        databaseReference.child("membership").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.child("membership").child(UID).child("Status").setValue("Active");
                Toast.makeText(membersFragment.this, "Subscription successful", Toast.LENGTH_LONG).show();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, HomePage.class));
        overridePendingTransition(0, 0);
        finish();
    }
}