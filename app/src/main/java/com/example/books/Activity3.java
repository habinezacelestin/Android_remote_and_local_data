package com.example.books;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.IgnoreExtraProperties;

import java.util.Objects;

public class Activity3 extends AppCompatActivity {
    private FirebaseFirestore db1;
    TextView Texv;
    EditText textpage;
    EditText textName;
    EditText textAuthor;
    RadioGroup rd;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db1= FirebaseFirestore.getInstance();
        setContentView(R.layout.activity_3);
        Texv = (TextView) findViewById(R.id.textV);
        textpage = (EditText) findViewById(R.id.Bookpage);
        textName = (EditText) findViewById(R.id.BookName);
        textAuthor = (EditText) findViewById(R.id.Bookauthor);


        button = (Button) findViewById(R.id.button12);


        button.setOnClickListener(view -> processInsert(textName.getText().toString(), textAuthor.getText().toString(), textpage.getText().toString()));
    }
    private void processInsert(String book, String author, String pages) {

        CollectionReference book1 = db1.collection("BookListe");

        BookProperty ListBook = new BookProperty(book, author, pages);

        book1.add(ListBook).addOnSuccessListener(documentReference -> {
            Toast.makeText(this,"Data inserted remotely",Toast.LENGTH_SHORT).show();
        }).addOnFailureListener(e -> {
            Toast.makeText(this,"Data not inserted remotely",Toast.LENGTH_SHORT).show();
        });
    }
}