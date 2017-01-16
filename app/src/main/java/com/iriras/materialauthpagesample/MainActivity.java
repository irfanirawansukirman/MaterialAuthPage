package com.iriras.materialauthpagesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.iriras.material_auth_page_library.ContainerAuthListener;
import com.iriras.material_auth_page_library.ContainerAuthView;
import com.iriras.material_auth_page_library.LoginListener;
import com.iriras.material_auth_page_library.RegisterListener;

public class MainActivity extends AppCompatActivity implements LoginListener, RegisterListener {

    public ContainerAuthView mContainerAuthView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContainerAuthView = (ContainerAuthView) findViewById(R.id.container_auth);
        mContainerAuthView.setActivity(this);
        mContainerAuthView.setListener(this, this);
    }

    @Override
    public void onLoginClicked(String email, String password) {
        Toast.makeText(this, email + " " + password, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterView() {
        mContainerAuthView.onMoveToLoginRegister(this);
    }

    @Override
    public void onRegisterClicked(String fullname, String email, String phone, String password) {
        Toast.makeText(this, fullname + " " + email + " " + phone + " " + password, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginView() {
        mContainerAuthView.setActivity(this);
    }
}
