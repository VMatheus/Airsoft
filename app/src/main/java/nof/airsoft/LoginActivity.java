package nof.airsoft;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonSignin;
    private EditText editText_email;
    private EditText editText_senha;
    private TextView textView_register;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() !=null){
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }
        buttonSignin = (Button) findViewById(R.id.buttonSignin);
        editText_email = (EditText) findViewById(R.id.editText_email);
        editText_senha = (EditText) findViewById(R.id.editText_senha);
        progressDialog = new ProgressDialog(this);
        textView_register = (TextView) findViewById(R.id.textView_register);


        buttonSignin.setOnClickListener(this);
        textView_register.setOnClickListener(this);

    }

    private void userlogin() {
        String email = editText_email.getText().toString().trim();
        String senha = editText_senha.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Por favor digite seu email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(senha)) {
            Toast.makeText(this, "Por favor digite sua senha", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registrando Usuario...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }

                    }
                });

    }



    @Override
    public void onClick(View v) {
        if (v == buttonSignin){
            userlogin();
            startActivity(new Intent(this, MainActivity.class));
        }
        if (v == textView_register){
            finish();
            startActivity(new Intent(this, RegistroActivity.class));
        }

    }
}
