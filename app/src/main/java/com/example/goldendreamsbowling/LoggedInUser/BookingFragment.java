package com.example.goldendreamsbowling.LoggedInUser;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.goldendreamsbowling.Aboutus;
import com.example.goldendreamsbowling.Booking.Cancel;
import com.example.goldendreamsbowling.Booking.CancelUpdateBooking;
import com.example.goldendreamsbowling.Booking.StartBook;
import com.example.goldendreamsbowling.Booking.ViewBooking;
import com.example.goldendreamsbowling.HomePage;
import com.example.goldendreamsbowling.MapsActivity;
import com.example.goldendreamsbowling.R;

public class BookingFragment extends Fragment {

    Button addBook,ViewBook,CancelUpdate;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_booking, container, false);

        addBook = view.findViewById(R.id.addBook);
        ViewBook = view.findViewById(R.id.viewBooking);
        CancelUpdate = view.findViewById(R.id.cancelUpdate);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), StartBook.class);
                startActivity(intent);
            }
        });

        ViewBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ViewBooking.class);
                startActivity(intent);
            }
        });

        CancelUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Cancel.class);
                startActivity(intent);
            }
        });


    }


    public void onBackPressed() {
        Intent intent = new Intent(getActivity(), HomePage.class);
        startActivity(intent);
        getActivity().overridePendingTransition(0,0);
        getActivity().finish();
    }
}