package com.example.user.firstapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.firstapp.model.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText userName;
    private EditText password;
    private Button login;
    private TextView signup;
    public static PrefConfig prefConfig;
    public static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        userName = (EditText) findViewById(R.id.idUserName);
        password = findViewById(R.id.idPassword);
        login = findViewById(R.id.idButton);
        signup = findViewById(R.id.idSignup);
        prefConfig = new PrefConfig(this);
        apiInterface = ApiRetrofit.getApiClient().create(ApiInterface.class);

        if( prefConfig.readLoginStatus() ){
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(userName.getText().toString(), password.getText().toString());
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }

    public void validate(String userName, String password){
        Call<DefaultResponse> call = apiInterface.userLogin(userName, password);
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if(response.body().getStatus().equals("success")){
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
                else if(response.body().getStatus().equals("failure")){
                    Toast.makeText(LoginActivity.this, (String)response.body().getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Server issue...", Toast.LENGTH_LONG).show();
            }
        });

    }
}
