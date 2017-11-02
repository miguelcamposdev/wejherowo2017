package com.miguelcr.a01_simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    List<String> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Get a reference for the ListView view component
        lista = findViewById(R.id.listViewStudents);

        // 2. Create the list of elements to show
        studentList = new ArrayList<>();
        studentList.add("Heniu");
        studentList.add("Konrad");
        studentList.add("Michal");
        studentList.add("Kasper");
        studentList.add("Rafal");
        studentList.add("Pawel");
        studentList.add("Patryk");
        studentList.add("Grzegorz I");
        studentList.add("Grzegorz II");
        studentList.add("Kuba");
        studentList.add("Oskar");
        studentList.add("Adam");
        studentList.add("Alan");
        studentList.add("Kamil");
        studentList.add("Krzys");
        studentList.add("Dawid");

        // 3. Adapter to connect the "ListView" with the "studentList"
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                studentList
        );

        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String name = studentList.get(position);
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        view.animate().rotationX(360).setDuration(2000).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
}
