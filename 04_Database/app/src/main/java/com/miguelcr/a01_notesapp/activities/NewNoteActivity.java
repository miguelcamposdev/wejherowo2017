package com.miguelcr.a01_notesapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.miguelcr.a01_notesapp.R;
import com.miguelcr.a01_notesapp.models.CategoryNoteDB;
import com.miguelcr.a01_notesapp.models.NoteDB;

import io.realm.Realm;

public class NewNoteActivity extends AppCompatActivity {
    EditText title, colorCode;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        title = findViewById(R.id.editTextTitle);
        colorCode = findViewById(R.id.editTextColor);

        setTitle("New Category");
        // Get the connection to the Database.
        realm = Realm.getDefaultInstance();
    }

    public void saveCategory(View view) {

        // INSERT INTO...
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                // 1 method
                NoteDB newNote = new NoteDB();
                newNote.setTitle(title.getText().toString());
                newNote.setDescription();

                realm.copyToRealm(newNote);

                // Destroy this screen, to return to the CategoryList screen
                finish();
            }
        });

    }
}
