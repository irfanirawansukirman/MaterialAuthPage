package com.iriras.material_auth_page_library;

/**
 * Created by irfan on 13/01/17.
 */

public interface RegisterListener {
    void onRegisterClicked(String fullname,
                           String email,
                           String phone,
                           String password);

    void onLoginView();
}
