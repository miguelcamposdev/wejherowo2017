package com.miguelcr.a01_simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<String> studendtList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Get a reference for the ListView view component
        lista = findViewById(R.id.listViewStudents);

        // 2. Create the list of elements to show
        studendtList = new ArrayList<>();
        studendtList.add("Heniu");
        studendtList.add("Konrad");
        studendtList.add("Michal");
        studendtList.add("Kasper");
        studendtList.add("Rafal");
        studendtList.add("Pawel");
        studendtList.add("Patryk");
        studendtList.add("Grzegorz I");
        studendtList.add("Grzegorz II");
        studendtList.add("Kuba");
        studendtList.add("Oskar");
        studendtList.add("Adam");
        studendtList.add("Alan");
        studendtList.add("Kamil");
        studendtList.add("Krzys");
        studendtList.add("Dawid");

        // 3. Adapter to connect the "ListView" with the "studentList"
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                studendtList
        );

        lista.setAdapter(adapter);

    }
}
