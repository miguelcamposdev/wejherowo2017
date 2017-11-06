package com.miguelcr.a01_notesapp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by miguelcampos on 6/11/17.
 */

class MyCategoriesAdapter extends ArrayAdapter<CategoryNoteDB> {
    Context ctx;
    int layoutTemplate;
    RealmResults<CategoryNoteDB> categoriesList;

    public MyCategoriesAdapter(@NonNull Context context, int resource, @NonNull RealmResults<CategoryNoteDB> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.categoriesList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);

        // Get the current item
        CategoryNoteDB current = categoriesList.get(position);

        // Get all the view components
        TextView textViewTitle = v.findViewById(R.id.textViewCategory);
        ConstraintLayout layout = v.findViewById(R.id.layoutCategoryItem);

        // Set into the View components the current object information
        textViewTitle.setText(current.getTitle());
        layout.setBackgroundColor(Color.parseColor("#ffffff"));

        return v;
    }
}
