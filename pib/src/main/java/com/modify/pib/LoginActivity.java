package com.modify.pib;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import com.modify.pib.network.SessionsManager;


public class LoginActivity extends AppCompatActivity {

    AppCompatButton loginButton;
    SessionsManager sessionsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        sessionsManager = new SessionsManager(getApplicationContext());
        if(sessionsManager.isLoggedIn()) {
            loginSuccess();
        }

        loginButton = (AppCompatButton) findViewById(R.id.btn_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void loginSuccess() {
        sessionsManager.setLoggedIn(true);

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

        finish();
    }

    private void loginFailed() {
        //TODO: Display toast
    }

    private void login() {
        // TODO: Validate input fields
        loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        // TODO: Authenticate user

        progressDialog.dismiss();
        loginSuccess();
    }

}



