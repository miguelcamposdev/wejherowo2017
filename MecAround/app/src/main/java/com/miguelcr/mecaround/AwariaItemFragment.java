package com.miguelcr.mecaround;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class AwariaItemFragment extends Fragment {
    List<AwariaItem> awariaItemList;

    private int mColumnCount = 1;

    public AwariaItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        awariaItemList = new ArrayList<>();
        awariaItemList.add(new AwariaItem("zepsute lewe lustro","ktoś go kopnął","Ferrari","https://www.endado.com/blog/wp-content/uploads/2014/02/chapuzas_espejo.jpg"));
        awariaItemList.add(new AwariaItem("porysowana maska","mój sąsiad oszalał","Lamborghini diablo","https://www.minicar.es/large/Lamborghini-Gallardo-Superleggera-%282007%29-Autoart-118-i20880.jpg"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_awariaitem_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyAwariaItemRecyclerViewAdapter(getActivity(),awariaItemList));
        }
        return view;
    }


}
