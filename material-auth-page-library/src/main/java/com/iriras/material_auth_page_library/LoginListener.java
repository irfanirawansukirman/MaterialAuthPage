package com.iriras.material_auth_page_library;

/**
 * Created by irfan on 13/01/17.
 */

public interface LoginListener {
    void onLoginClicked(String email,
                        String password);

    void onRegisterView();
}
