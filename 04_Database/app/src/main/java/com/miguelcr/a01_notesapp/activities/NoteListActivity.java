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
import com.miguelcr.a01_notesapp.adapters.MyNotesAdapter;
import com.miguelcr.a01_notesapp.models.CategoryNoteDB;
import com.miguelcr.a01_notesapp.models.NoteDB;

import io.realm.Realm;
import io.realm.RealmResults;

public class NoteListActivity extends AppCompatActivity {
    ListView lista;
    Realm realm;
    RealmResults<NoteDB> noteList;
    long idCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        // Get the categoryId where user clicked
        Bundle extras = getIntent().getExtras();
        idCategory = extras.getLong("categoryId");

        lista = findViewById(R.id.listViewNotes);
        realm = Realm.getDefaultInstance();
        // SELECT * FROM NoteDB WHERE idCat = idCategory
        noteList = realm.where(NoteDB.class)
                .equalTo("idCat",idCategory)
                .findAll();

        MyNotesAdapter adapter = new MyNotesAdapter(
                this,
                R.layout.note_item,
                noteList
        );

        lista.setAdapter(adapter);
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
                Intent i = new Intent(this, NewNoteActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
