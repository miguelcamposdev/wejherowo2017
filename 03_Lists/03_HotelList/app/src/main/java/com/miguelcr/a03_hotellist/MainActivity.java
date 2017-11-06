package com.miguelcr.a03_hotellist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<Hotel> hotelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listViewHotels);
        hotelList = new ArrayList<>();

        hotelList.add(new Hotel("Langham Place, NYC",5,189, "Wi-fi connection",200,"Great location",0.3f,"https://t-ec.bstatic.com/images/hotel/square200/194/19456705.jpg"));
        hotelList.add(new Hotel("Hotel Olimp Business & Spa",4,150, "Wi-fi and SPA",200,"The best city in Poland",0.3f,"https://s-ec.bstatic.com/images/hotel/square200/850/85085412.jpg"));

        MyHotelAdapter adapter = new MyHotelAdapter(
                this,
                R.layout.hotel_item,
                hotelList
        );

        lista.setAdapter(adapter);

    }
}
