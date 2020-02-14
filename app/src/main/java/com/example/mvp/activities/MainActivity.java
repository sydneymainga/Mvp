package com.example.mvp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp.R;
import com.example.mvp.model.PresenterImpl;
import com.example.mvp.presenter.LoginPresenter;
import com.example.mvp.view.LoginView;

public class MainActivity extends Activity implements View.OnClickListener, LoginView
{
    EditText etUserName,etPassword;
    TextView tvLogin;

    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName= findViewById(R.id.etUserName);
        etPassword= findViewById(R.id.etPassword);
        tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener( this);

        mLoginPresenter = new PresenterImpl(MainActivity.this);
    }


    @Override
    public void onClick(View v) {
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();
        mLoginPresenter.performLogin(userName,password);
    }

    @Override
    public void loginValidations()
    {
        Toast.makeText(getApplicationContext(),"Please Enter Username and Password", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess()
    {
        Toast.makeText(getApplicationContext(),"logged in successfull", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginerror()
    {
        Toast.makeText(getApplicationContext(),"failed", Toast.LENGTH_LONG).show();
    }
}
