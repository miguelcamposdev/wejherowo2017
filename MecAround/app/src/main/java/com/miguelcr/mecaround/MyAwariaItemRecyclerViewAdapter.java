package com.miguelcr.mecaround;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class MyAwariaItemRecyclerViewAdapter extends RecyclerView.Adapter<MyAwariaItemRecyclerViewAdapter.ViewHolder> {

    private List<AwariaItem> mValues;
    private Context ctx;

    public MyAwariaItemRecyclerViewAdapter(Context context, List<AwariaItem> items) {
        mValues = items;
        ctx = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_awariaitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // Get the current element (awaria)
        holder.mItem = mValues.get(position);

        holder.titleTextView.setText(holder.mItem.getTitle());
        holder.carModelTextView.setText(holder.mItem.getCarModel());

        Picasso.with(ctx)
                .load(holder.mItem.getPhotoUrl())
                .resize(50,50)
                .centerCrop()
                .into(holder.photoImageView);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView photoImageView;
        public final TextView titleTextView;
        public final TextView carModelTextView;
        public AwariaItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            photoImageView = view.findViewById(R.id.imageViewPhoto);
            titleTextView = view.findViewById(R.id.textViewTitle);
            carModelTextView = view.findViewById(R.id.textViewCarModel);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + titleTextView.getText() + "'";
        }
    }
}
