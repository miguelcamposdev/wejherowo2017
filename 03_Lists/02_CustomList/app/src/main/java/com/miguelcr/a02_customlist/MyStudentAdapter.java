package com.miguelcr.a02_customlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by miguelcampos on 3/11/17.
 */

class MyStudentAdapter extends ArrayAdapter<Student> {
    Context ctx;
    int layoutTemplate;
    List<Student> studentList;

    public MyStudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.studentList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);

        ImageView photo = v.findViewById(R.id.imageViewPhoto);
        TextView name = v.findViewById(R.id.textViewName);
        TextView training = v.findViewById(R.id.textViewTraining);
        TextView school = v.findViewById(R.id.textViewSchool);
        TextView age = v.findViewById(R.id.textViewAge);

        Student current = studentList.get(position);

        // Set the current student info into the view components
        name.setText(current.getName());
        training.setText(current.getTraining());
        school.setText(current.getSchool());
        age.setText(current.getAge()+" years old");

        Picasso.with(ctx)
                .load(current.getUrlPhoto()).into(photo);


        return v;
    }
}
