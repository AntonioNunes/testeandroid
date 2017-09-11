package com.example.andrelewkowiczkatz.testrest;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class login extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText mUsername = (EditText) findViewById(R.id.email);
        final EditText mPassword = (EditText) findViewById(R.id.password);
        final Button blogin = (Button) findViewById(R.id.blogin);
        final TextView registerLink = (TextView) findViewById(R.id.registerLink);

        Log.d("teste","inicio");
        /*link para register page - início */
        registerLink.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(login.this,register.class);
                login.this.startActivity(registerIntent);
                Log.d("teste","registertes");
            }
        });
        /*link para register page - fim


        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View views) {

                final String username = mUsername.getText().toString();
                final String password = mPassword.getText().toString();

                Toast t = Toast.makeText(views.getContext(),"dshdjsh",Toast.LENGTH_SHORT);

                Response.Listener<String> responnseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean succes = jsonResponse.getBoolean("succes");

                            String name = jsonResponse.getString("firstName");
                            String email = jsonResponse.getString("email");

                            if(name != null){

                                Intent intent = new Intent(login.this, userloginok.class);
                                intent.putExtra("name",name);
                                intent.putExtra("email",email);

                                login.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };


                LoginRequest loginRequest = new LoginRequest(username,password,responnseListener);
                RequestQueue queue = Volley.newRequestQueue(login.this);
                queue.add(loginRequest);
            }
        });
*/

    }   public void loginsend(View view){

        final EditText mEmail = (EditText) findViewById(R.id.email);
        final EditText mPassword = (EditText) findViewById(R.id.password);

        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();

        Log.d("teste","tertes");

        Response.Listener<String> responnseListener = new Response.Listener<String>(){


            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                   //boolean succes = jsonResponse.getBoolean("succes");

                    Log.d("teste","responseteste");

                    if(response != null){


                        String name = jsonResponse.getString("firstName");
                        String email = jsonResponse.getString("email");

                        Intent intent = new Intent(login.this, userloginok.class);
                        intent.putExtra("name",name);
                        intent.putExtra("email",email);

                        login.this.startActivity(intent);

                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                        builder.setMessage("Login Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        };


        LoginRequest loginRequest = new LoginRequest(email,password,responnseListener);
        RequestQueue queue = Volley.newRequestQueue(login.this);
        queue.add(loginRequest);

    }
}
