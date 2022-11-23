package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    EditText edt1,edt2;
    Button btn1;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView) findViewById(R.id.actbtn1);
        edt1=(EditText) findViewById(R.id.Username);
        edt2=(EditText) findViewById(R.id.password);
        btn1=(Button) findViewById(R.id.actbtn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt1.getText().toString().trim().equals("Habineza") && edt2.getText().toString().equals("2000")){
                    Intent intent=new Intent(MainActivity.this,Activity1.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Incorrect Username and password ",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}