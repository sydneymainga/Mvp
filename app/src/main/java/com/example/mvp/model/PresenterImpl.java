package com.example.mvp.model;

import android.text.TextUtils;

import com.example.mvp.presenter.LoginPresenter;
import com.example.mvp.view.LoginView;

public class PresenterImpl implements LoginPresenter {

    LoginView mLoginView;
    public PresenterImpl(LoginView loginView){
        this.mLoginView=loginView;

    }
    @Override
    public void performLogin(String userName, String password)
    {
        if(TextUtils.isEmpty(userName)|| TextUtils.isEmpty(password))
        {
            mLoginView.loginValidations();
        }
        else
        {
            if(userName.equals("Mani") && password.equals("Mani"))
            {
                mLoginView.loginSuccess();
            }
            else
                {
                    mLoginView.loginerror();
                }
        }
    }
}
