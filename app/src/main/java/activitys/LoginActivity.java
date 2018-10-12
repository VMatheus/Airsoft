package activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dao.FirebaseDao;
import nof.airsoft.R;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextEmail, editTextPassword;
    private TextView textForgotPassword, textRegister;
    private Button buttonSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        editTextEmail = (EditText) findViewById(R.id.editEmail);
        editTextPassword = (EditText) findViewById(R.id.editPassword);
        buttonSign = (Button) findViewById(R.id.buttonSignin);
        textForgotPassword = (TextView) findViewById(R.id.textForgotPassword);
        textRegister = (TextView) findViewById(R.id.textRegister);

        buttonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valid()){
                    new FirebaseDao().login(editTextEmail.getText().toString(), editTextPassword.getText().toString(), LoginActivity.this);
                }
            }
        });

        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));

            }
        });

        textForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(), ForgotPasswordActivity.class));
            }
        });
    }

    private  boolean valid(){
        EditText focusInput = null;
        boolean isValid = true;
        if(editTextEmail.getText().toString().length()== 0 ){
            focusInput = editTextEmail;
            editTextEmail.requestFocus();
            editTextEmail.setError(getResources().getString(R.string.campo_obrigatorio));
            isValid = false;
        }
        if(!editTextEmail.getText().toString().contains("@") ){
            focusInput = editTextEmail;
            editTextEmail.requestFocus();
            editTextEmail.setError(getResources().getString(R.string.email_invalido));
            isValid = false;
        }

        if (editTextPassword.getText().toString().length() == 0) {
            focusInput = editTextPassword;

            editTextPassword.requestFocus();
            editTextPassword.setError(getResources().getString(R.string.campo_obrigatorio));
            isValid = false;
        }


        if (focusInput != null) {
            focusInput.requestFocus();
        }
        return isValid;
    }





}
