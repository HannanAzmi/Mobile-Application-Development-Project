package com.example.goldendreamsbowling;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.goldendreamsbowling.LoggedInUser.Drawer_base;
import com.example.goldendreamsbowling.databinding.ActivityHomePageBinding;

import java.text.DateFormat;
import java.util.Calendar;

public class HomePage extends Drawer_base {


    TextView time, date;

    ActivityHomePageBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind =bind.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

       // allocateActivityTitle("Home");


        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(android.icu.text.DateFormat.FULL).format(calendar.getTime());
        TextView textViewD = findViewById(R.id.textViewCurrentDate);
        textViewD.setText(currentDate);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);

    }
}