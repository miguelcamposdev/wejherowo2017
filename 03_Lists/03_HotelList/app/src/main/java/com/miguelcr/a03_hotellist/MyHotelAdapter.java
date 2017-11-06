package com.miguelcr.a03_hotellist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by miguelcampos on 3/11/17.
 */

class MyHotelAdapter extends ArrayAdapter<Hotel> {
    Context ctx;
    int layoutTemplate;
    List<Hotel> hotelList;

    public MyHotelAdapter(@NonNull Context context, int resource, @NonNull List<Hotel> objects) {
        super(context, resource, objects);
        this.ctx = context;
        layoutTemplate = resource;
        hotelList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);

        ImageView photo = v.findViewById(R.id.imageViewPhoto);
        TextView name = v.findViewById(R.id.textViewName);
        TextView price = v.findViewById(R.id.textViewPrice);
        RatingBar rate = v.findViewById(R.id.ratingBarRate);

        Hotel current = hotelList.get(position);

        name.setText(current.getName());
        price.setText(current.getPrice()+"€");
        rate.setRating(current.getRate());

        Picasso.with(ctx).load(current.getUrlPhoto()).into(photo);


        return v;
    }
}
