package com.example.andrelewkowiczkatz.testrest;

/**
 * Created by User on 10/09/2017.
 */
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    //URL DO LOGIN, PRECISA ALTERAR PARA A DE REGISTRO
    private static final String REGISTER_REQUEST_URL = "179.34.159.158:8081/HelpMeServer/user/login";
    private Map<String,String> params;


    public RegisterRequest (String name,String username, int age,String password,Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);

        params = new HashMap<>();
        params.put("name",name);
        params.put("username",username);
        params.put("age",age+"");
        params.put("password",password);


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
