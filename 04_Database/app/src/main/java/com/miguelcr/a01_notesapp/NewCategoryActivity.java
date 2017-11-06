package com.miguelcr.a01_notesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import io.realm.Realm;

public class NewCategoryActivity extends AppCompatActivity {
    EditText title, colorCode;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_category);

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
                CategoryNoteDB newCategory = new CategoryNoteDB();
                newCategory.setTitle(title.getText().toString());
                newCategory.setColor(colorCode.getText().toString());

                // 2 method
                //CategoryNoteDB newCategory = new CategoryNoteDB(title.getText().toString(),colorCode.getText().toString());

                // Insert the new object into the local database
                realm.copyToRealm(newCategory);

                // Destroy this screen, to return to the CategoryList screen
                finish();
            }
        });

    }
}
