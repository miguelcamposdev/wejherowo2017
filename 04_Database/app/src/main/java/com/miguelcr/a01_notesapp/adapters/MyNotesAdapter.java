package com.miguelcr.a01_notesapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.miguelcr.a01_notesapp.R;
import com.miguelcr.a01_notesapp.models.NoteDB;

import io.realm.RealmResults;

/**
 * Created by miguelcampos on 6/11/17.
 */

public class MyNotesAdapter extends ArrayAdapter<NoteDB> {
    Context ctx;
    int layoutTemplate;
    RealmResults<NoteDB> notesList;

    public MyNotesAdapter(@NonNull Context context, int resource, @NonNull RealmResults<NoteDB> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.notesList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);

        NoteDB current = notesList.get(position);

        TextView title = v.findViewById(R.id.textViewTitle);
        TextView description = v.findViewById(R.id.textViewDescription);

        title.setText(current.getTitle());
        description.setText(current.getDescription());

        return v;
    }
}
