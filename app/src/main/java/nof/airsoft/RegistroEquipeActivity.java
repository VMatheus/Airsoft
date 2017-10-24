package nof.airsoft;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import model.EquipeInformation;
import model.Usuario;

public class RegistroEquipeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button registarEquipe;
    private EditText editText_nomeEquipe;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private ProgressDialog progressDialog;
    private DatabaseReference mDatabase;
    private Usuario endereco;
    FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_equipe);

        registarEquipe = (Button) findViewById(R.id.registrarEquipe);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() != null){

                    startActivity(new Intent(getApplicationContext(), MinhaEquipeActivity.class));

                }

            }
        };
        databaseReference = FirebaseDatabase.getInstance().getReference();
        progressDialog = new ProgressDialog(this);
        editText_nomeEquipe = (EditText) findViewById(R.id.editText_nomeEquipe);
        registarEquipe.setOnClickListener(this);

    }

    @Override
    public void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        super.onCreateSupportNavigateUpTaskStack(builder);
    }

    private void registerTeam() {
        String nome = editText_nomeEquipe.getText().toString().trim();

        if (TextUtils.isEmpty(nome)) {
            Toast.makeText(this, "Por favor digite o nome", Toast.LENGTH_SHORT).show();
        }else {
            String id = UUID.randomUUID().toString();
            EquipeInformation equipeInformation = new EquipeInformation(nome, id);
            equipeInformation.setId(id);
            databaseReference.child("equipes").push().setValue(equipeInformation);
            startActivity(new Intent(this, MainActivity.class));
        }


    }

    @Override
    public void onClick(View view) {
        if(view == registarEquipe){
            registerTeam();

        }

    }
}