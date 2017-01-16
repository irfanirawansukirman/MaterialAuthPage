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

public class RegisterFragment extends Fragment {
    public TextView mRegisterViewLog, mBtnRegister;
    public EditText mEdtxtFullname, mEdtxtEmail, mEdtxtPhone, mEdtxtPassword, mEdtxtRetype;

    public boolean isFullname = false;
    public boolean isEmail = false;
    public boolean isPhone = false;
    public boolean isPassword = false;
    public boolean isRetype = false;

    public RegisterListener mRegisterListener;
    public ContainerAuthView mContainerAuthView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.register_view, container, false);

        setRegView(mView);

        mRegisterViewLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRegisterListener.onLoginView();
            }
        });

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEdtxtFullname.getText().toString().equals("")) {
                    mEdtxtFullname.setError("Fullname tidak boleh kosong");
                    isFullname = false;
                } else {
                    isFullname = true;
                }

                if (mEdtxtEmail.getText().toString().equals("")) {
                    mEdtxtEmail.setError("Email tidak boleh kosong");
                    isEmail = false;
                } else {
                    isEmail = true;
                }

                if (mEdtxtPhone.getText().toString().equals("")) {
                    mEdtxtPhone.setError("Phone tidak boleh kosong");
                    isPhone = false;
                } else {
                    isPhone = true;
                }

                if (mEdtxtPassword.getText().toString().equals("")) {
                    mEdtxtPassword.setError("Password tidak boleh kosong");
                    isPassword = false;
                } else {
                    isPassword = true;
                }

                if (mEdtxtRetype.getText().toString().equals("")) {
                    mEdtxtRetype.setError("Password Re-type tidak boleh kosong");
                    isRetype = false;
                } else {
                    isRetype = true;
                }

                if (isFullname && isEmail && isPhone && isPassword && isRetype) {
                    mRegisterListener.onRegisterClicked(mEdtxtFullname.getText().toString(),
                            mEdtxtEmail.getText().toString(),
                            mEdtxtPhone.getText().toString(),
                            mEdtxtPassword.getText().toString());
                }
            }
        });
        return mView;
    }

    public void setRegView(View mView) {
        mRegisterViewLog = (TextView) mView.findViewById(R.id.btn_register_viewlogin);
        mBtnRegister = (TextView) mView.findViewById(R.id.btn_register);
        mEdtxtFullname = (EditText) mView.findViewById(R.id.edtxt_register_fullname);
        mEdtxtEmail = (EditText) mView.findViewById(R.id.edtxt_register_email);
        mEdtxtPhone = (EditText) mView.findViewById(R.id.edtxt_register_phone);
        mEdtxtPassword = (EditText) mView.findViewById(R.id.edtxt_register_password);
        mEdtxtRetype = (EditText) mView.findViewById(R.id.edtxt_register_retype);
    }

    public void setListener(ContainerAuthView mContainerAuthView, RegisterListener mRegisterListener) {
        this.mContainerAuthView = mContainerAuthView;
        this.mRegisterListener = mRegisterListener;
    }
}
