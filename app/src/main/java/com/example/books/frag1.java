package com.example.books;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class frag1 extends Fragment {

    private ArrayList<BookProperty>ListBook = new ArrayList<>();

    private RecyclerView myrecyclerview;
    private Context context;
    DbHelper db;
    FloatingActionButton float1;
    TextView noData;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View v = inflater.inflate(R.layout.fragment_frag1, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.Recyl);
        db = new DbHelper(getActivity());
        Cursor cursor = db.readAllData();

        noData = v.findViewById(R.id.no_data);
        ListBook = new ArrayList<>();
        if (cursor.moveToFirst()) {
            noData.setVisibility(v.GONE);
do{
    String title = cursor.getString(1);
    String desc = cursor.getString(2);
    String page=cursor.getString(3);

    ListBook.add(new BookProperty(title, desc, page));
}
           while(cursor.moveToNext());
            MYAdapter recyclerAdapter = new MYAdapter(getContext(), ListBook);
            myrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
            myrecyclerview.setVerticalScrollBarEnabled(true);
           recyclerAdapter.notifyDataSetChanged();
            myrecyclerview.setAdapter(recyclerAdapter);
        }

            float1 = v.findViewById(R.id.floatid);
            float1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), Activity2.class);
                    startActivity(intent);
                }
            });
            return v;

        }
}




