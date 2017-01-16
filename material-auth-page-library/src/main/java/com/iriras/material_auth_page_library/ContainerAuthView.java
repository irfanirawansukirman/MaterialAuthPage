package com.iriras.material_auth_page_library;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by irfan on 13/01/17.
 */

public class ContainerAuthView extends LinearLayout {
    private Context mContext;
    private View mView;
    private FragmentManager mFragmentManager;
    private LoginListener mLoginListener;
    private RegisterListener mRegisterListener;
    private LoginFragment mLoginFragment;
    private RegisterFragment mRegisterFragment;
    private ContainerAuthView mContainerAuthView;

    private Bitmap mBitmap;
    private String mEmail;
    private String mPassword;
    private String mUsername;
    private int img_logo;
    private int register_description_text;
    private int register_description_textcolor;
    private int register_fullname_textcolor;
    private int register_email_textcolor;
    private int register_phone_textcolor;
    private int register_pass_textcolor;
    private int register_retype_textcolor;
    private int register_notif_textcolor;
    private int register_register_view_textcolor;
    private int register_icon_username;
    private int register_icon_email;
    private int register_icon_phone;
    private int register_icon_password;
    private int register_icon_retype;
    //register hint
    private int login_username_textcolor;
    private int login_password_textcolor;
    private int login_icon_username;
    private int login_icon_password;
    private int login_notif_textcolor;
    private int login_login_view_textcolor;

    public ContainerAuthView(Context context) {
        super(context);
        this.mContext = context;
        injectView();
    }

    public ContainerAuthView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        injectView();
    }

    public void injectView() {
        LayoutInflater mLayoutInflater;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = mLayoutInflater.inflate(R.layout.container_auth_view, this);
        mRegisterFragment = new RegisterFragment();
        mLoginFragment = new LoginFragment();
    }

    public void setActivity(AppCompatActivity mActivity){
        mFragmentManager = mActivity.getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.framelayout, mLoginFragment).commit();
    }

    public void onMoveToLoginRegister(AppCompatActivity mActivity){
        mFragmentManager = mActivity.getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.framelayout, mRegisterFragment).commit();
    }

    public void setListener(LoginListener mLoginListener, RegisterListener mRegisterListener){
        this.mLoginListener = mLoginListener;
        this.mRegisterListener = mRegisterListener;
        mLoginFragment.setListener(this, mLoginListener);
        mRegisterFragment.setListener(this, mRegisterListener);
    }
}
