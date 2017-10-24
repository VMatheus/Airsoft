package nof.airsoft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private EditText editTextNome;
    private EditText editTextContato;
    private EditText editTextEndereco;
    private Button buttonLogout;
    private Button buttonSalvar;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));

        }

        databaseReference = FirebaseDatabase.getInstance().getReference();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        buttonSalvar = (Button) findViewById(R.id.buttonSalvar);
        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextEndereco = (EditText) findViewById(R.id.editTextEndereco);
        editTextContato = (EditText) findViewById(R.id.editTextContato);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);


        buttonLogout.setOnClickListener(this);
        buttonSalvar.setOnClickListener(this);

    }

    private void saveUserInformation(){
        String nome = editTextNome.getText().toString().trim();
        String contato = editTextContato.getText().toString().trim();
        String endereco = editTextEndereco.getText().toString().trim();

        UserInformation userInformation = new UserInformation(nome, contato, endereco);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseReference.child("usuarios").child(user.getUid()).setValue(userInformation);
        Toast.makeText(this, "Informações salvas", Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view){
        if (view == buttonLogout) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
         if (view == buttonSalvar){
             saveUserInformation();
             startActivity(new Intent(this, MainActivity.class));

         }
    }
}
