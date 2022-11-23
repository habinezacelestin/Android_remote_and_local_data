package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Activity2 extends AppCompatActivity {
    DbHelper dbHelper;
    TextView Texv;
    EditText textpage;
    EditText textName;
    RadioGroup rg;
    EditText textAuthor;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        dbHelper = new DbHelper(this);
        Texv = (TextView) findViewById(R.id.textV);
        textpage = (EditText) findViewById(R.id.Bookpage);
        textName = (EditText) findViewById(R.id.BookName);
        textAuthor = (EditText) findViewById(R.id.Bookauthor);

        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processInsert(textName.getText().toString(),
                        textAuthor.getText().toString(),
                        textpage.getText().toString());
            }

        });

    }


    private void processInsert(String n, String a, String p) {
        String res = new DbHelper(this).addBook(n,a,p);
        textName.setText("");
        textAuthor.setText("");
        textpage.setText("");

    }

}
