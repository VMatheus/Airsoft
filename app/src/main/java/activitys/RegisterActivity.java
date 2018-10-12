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

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextNick, editTextEmail, editTextPassword;
    private TextView textLogin;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
    }

    private void initViews() {
        editTextNick = (EditText) findViewById(R.id.editNick);
        editTextEmail = (EditText) findViewById(R.id.editEmail);
        editTextPassword = (EditText) findViewById(R.id.editPassword);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        textLogin = (TextView) findViewById(R.id.textLogin);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valid()){
                    new FirebaseDao().register(editTextEmail.getText().toString(), editTextPassword.getText().toString(), RegisterActivity.this);

                }
            }
        });

        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });


    }




    private  boolean valid(){
        EditText focusInput = null;
        boolean isValid = true;

        if(editTextNick.getText().toString().length()== 0 ){
            focusInput = editTextNick;
            editTextNick.requestFocus();
            editTextNick.setError(getResources().getString(R.string.campo_obrigatorio));
            isValid = false;
        }

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
