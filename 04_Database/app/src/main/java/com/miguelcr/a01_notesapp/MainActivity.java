package com.miguelcr.a01_notesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    RealmResults<CategoryNoteDB> categoryNoteDBList;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. ListView component (get a reference)
        lista = findViewById(R.id.listViewCategories);

        // 2. Get the elements to show in the list

        // 2.1. Connection to the Database
        realm = Realm.getDefaultInstance();

        // 2.2. Get the list of categories
        // SELECT * FROM Categories
        categoryNoteDBList = realm.where(CategoryNoteDB.class).findAll();

        // 3. Adapter
        MyCategoriesAdapter adapter = new MyCategoriesAdapter(
                this,
                R.layout.category_item, // the template to draw one item
                categoryNoteDBList
        );

        lista.setAdapter(adapter);
    }
}
