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

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRegister;
    private EditText editText_email;
    private EditText editText_senha;
    private TextView textView_signin;
    FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() !=null){
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }
        progressDialog = new ProgressDialog(this);

        editText_email = (EditText) findViewById(R.id.editText_email);
        editText_senha = (EditText) findViewById(R.id.editText_senha);

        textView_signin = (TextView) findViewById(R.id.textView_signin);

        buttonRegister.setOnClickListener(this);
        textView_signin.setOnClickListener(this);

    }

    private void registerUser(){
        String email = editText_email.getText().toString().trim();
        String senha = editText_senha.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Por favor digite seu email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(senha)){
            Toast.makeText(this, "Por favor digite sua senha", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registrando Usuario...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                                finish();
                                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        }else{
                            Toast.makeText(RegistroActivity.this, "Não foi possivel realizar o cadastro, tente novamente.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }



    @Override
    public void onClick(View view) {
        if(view == buttonRegister){
            registerUser();

        }
        if(view == textView_signin){
            startActivity(new Intent(this, LoginActivity.class));
        }

    }
}
