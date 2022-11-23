package com.example.books;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Objects;

public class frag2 extends Fragment {
    private ArrayList<BookProperty>ListBook = new ArrayList<>();
    private RecyclerView myrecyclerview;
    private Context context;
    private FirebaseFirestore Database2;
    FloatingActionButton float1;
    TextView noData;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_frag2, container, false);
        float1 = v.findViewById(R.id.floatid);
        ListBook = new ArrayList<>();
        myrecyclerview = (RecyclerView) v.findViewById(R.id.Recyl);
        noData = v.findViewById(R.id.no_data);
        Database2 = FirebaseFirestore.getInstance();
        Database2.collection("BookListe")
                .get().addOnCompleteListener(task -> {

                    if (task.isSuccessful()) {

                        noData.setVisibility(v.GONE);

                        for (QueryDocumentSnapshot document : task.getResult()) {

                            ListBook.add(new BookProperty(Objects.requireNonNull(document.getData().get("book_name")).toString(), Objects.requireNonNull(document.getData().get("author")).toString(), Objects.requireNonNull(document.getData().get("pages")).toString()));
                            MYAdapter recyclerAdapter = new MYAdapter(getContext(),ListBook);
                            myrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
                            myrecyclerview.setVerticalScrollBarEnabled(true);
                            recyclerAdapter.notifyDataSetChanged();
                            myrecyclerview.setAdapter(recyclerAdapter);
                        }
                    } else {
                        System.out.println("Error getting documents: " + task.getException());
                    }
                });
        float1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Activity3.class);
                startActivity(intent);
            }
        });
        return v;
    }
}

