package com.example.andrelewkowiczkatz.testrest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class userloginok extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final TextView tvname = (TextView) findViewById(R.id.nameresponse);
        final TextView tvemail = (TextView) findViewById(R.id.emailresponse);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");

        setContentView(R.layout.activity_userloginok);
    }
}
