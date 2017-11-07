package com.miguelcr.a01_notesapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.miguelcr.a01_notesapp.R;
import com.miguelcr.a01_notesapp.adapters.MyCategoriesAdapter;
import com.miguelcr.a01_notesapp.models.CategoryNoteDB;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
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
        // OnItemClick to show the list of notes for 1 category
        lista.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu_categories, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_new_category:
                Intent i = new Intent(this, NewCategoryActivity.class);
                startActivity(i);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        CategoryNoteDB categoryNoteDB = categoryNoteDBList.get(position);

        Intent i = new Intent(this, NoteListActivity.class);
        i.putExtra("categoryId", categoryNoteDB.getId());
        startActivity(i);
    }
}
