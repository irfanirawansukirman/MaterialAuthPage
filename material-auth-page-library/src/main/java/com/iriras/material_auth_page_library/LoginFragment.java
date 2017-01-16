package com.iriras.material_auth_page_library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by irfan on 13/01/17.
 */

public class LoginFragment extends Fragment {
    public TextView mLoginViewReg, mBtnLogin;
    public EditText mTxtUsername, mTxtPassword;
    public boolean isUsernameValid = false;
    public boolean isPasswordValid = false;
    public LoginListener mLoginListener;
    public ContainerAuthView mContainerAuthView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.login_view, container, false);

        setLoginView(mView);
        mLoginViewReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginListener.onRegisterView();
            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTxtUsername.getText().toString().equals("")) {
                    mTxtUsername.setError("Username tidak boleh kosong");
                    isUsernameValid = false;
                } else {
                    isUsernameValid = true;
                }

                if (mTxtPassword.getText().toString().equals("")) {
                    mTxtPassword.setError("Password tidak boleh kosong");
                    isPasswordValid = false;
                } else {
                    isPasswordValid = true;
                }

                if (isUsernameValid && isPasswordValid) {
                    mLoginListener.onLoginClicked(mTxtUsername.getText().toString(), mTxtPassword.getText().toString());
                }
            }
        });
        return mView;
    }

    public void setLoginView(View mView) {
        mBtnLogin = (TextView) mView.findViewById(R.id.btn_login);
        mTxtUsername = (EditText) mView.findViewById(R.id.edtxt_login_username);
        mTxtPassword = (EditText) mView.findViewById(R.id.edtxt_login_password);
        mLoginViewReg = (TextView) mView.findViewById(R.id.btn_login_view_register);
    }

    public void setListener(ContainerAuthView mContainerAuthView, LoginListener mLoginListener) {
        this.mContainerAuthView = mContainerAuthView;
        this.mLoginListener = mLoginListener;
    }
}
