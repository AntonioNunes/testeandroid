package com.example.andrelewkowiczkatz.testrest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<User> users = new ArrayList<>();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                URL testEndpoint = null;
                try {
                    testEndpoint = new URL("http://179.34.159.158:8081/HelpMeServer/user/list");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    HttpURLConnection myConnection =
                                (HttpURLConnection) testEndpoint.openConnection();
                    if (myConnection.getResponseCode() == 200) {
                        // Success
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader =
                                new InputStreamReader(responseBody, "UTF-8");

                        JsonReader jsonReader = new JsonReader(responseBodyReader);
                        jsonReader.beginObject();

                        //Inicializo as variaveis que receberao os dados de um objeto User
                        int idUser = 0;
                        String email = "";
                        String nameUser = "";
                        String firstName = "";
                        String lastName = "";
                        String anonymName = "";
                        String gender = "";
                        String photo = "";
                        String password = "";
                        String birthDate = "";
                        int idCity = 0;
                        int idState = 0;
                        int idCountry = 0;

                        while (jsonReader.hasNext()) {
                            String key = jsonReader.nextName();
                            if (key.equals("user")) {
                                    jsonReader.beginObject();

                                    while(jsonReader.hasNext()) {
                                        String name = jsonReader.nextName();
                                        if(name.equals("idUser")) {
                                            idUser = jsonReader.nextInt();
                                        }
                                        else if (name.equals("email")) {
                                            email = jsonReader.nextString();
                                        }
                                        else if (name.equals("firstName")) {
                                            firstName = jsonReader.nextString();
                                        }
                                        else if (name.equals("lastName")) {
                                            lastName = jsonReader.nextString();
                                        }
                                        else if (name.equals("anonymName")) {
                                            anonymName = jsonReader.nextString();
                                        }
                                        else if (name.equals("gender")) {
                                            gender = jsonReader.nextString();
                                        }
                                        else if (name.equals("photo")) {
                                            photo = jsonReader.nextString();
                                        }
                                        else if (name.equals("birthDate")) {
                                            birthDate = jsonReader.nextString();
                                        }
                                        else if (name.equals("idCity")) {
                                            idCity = jsonReader.nextInt();
                                        }
                                        else if (name.equals("idState")) {
                                            idState = jsonReader.nextInt();
                                        }
                                        else if (name.equals("idCountry")) {
                                            idCountry = jsonReader.nextInt();
                                        }
                                        else {
                                            jsonReader.skipValue();
                                        }
                                    }

                                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                                    Date date = null;
                                try {
                                    date = formatter.parse(birthDate);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                final User user = new User(idUser, email, firstName, lastName, anonymName, gender, date, photo, password, idCity, idState, idCountry);
                                    users.add(user);
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            TextView idUser = (TextView) findViewById(R.id.idDisplayed);
                                            idUser.setText("idUser: " + Integer.toString(user.getIdUser()));

                                            TextView name = (TextView) findViewById(R.id.nameDisplayed);
                                            name.setText("User name: " + user.getFirstName());

                                            TextView email = (TextView) findViewById(R.id.idStateDisplayed);
                                            email.setText("Email: " + user.getEmail());
                                        }
                                    });
                                    jsonReader.close();
                                    break;
                                } else {
                                    jsonReader.skipValue();
                                }
                                jsonReader.close();
                                myConnection.disconnect();
                            }
                    } else {
                        // Error handling code goes here
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

}

