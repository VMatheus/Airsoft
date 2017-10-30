package nof.airsoft;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.prefs.PreferenceChangeEvent;

import model.Usuario;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private EditText editTextNome;
    private EditText editTextContato;
    private EditText editTextEndereco;
    private Button buttonLogout;
    private Button buttonSalvar;
    private DatabaseReference databaseReference;
    private SharedPreferences sharedPreferencesUser;


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


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("usuario");

        SharedPreferencesUser preferencesUser = new SharedPreferencesUser(ProfileActivity.this);
        preferencesUser.salvarUsuarioPreferences("id","nome");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    Usuario usuario = dataSnapshot.getValue(Usuario.class);
                    editTextNome.setText(usuario.getNome());
                    editTextEndereco.setText(usuario.getEndereco());
                    editTextContato.setText(usuario.getContato());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Falhou: " + databaseError.getCode());
            }
        });


    }

    private void saveUserInformation(){
        String nome = editTextNome.getText().toString().trim();
        String contato = editTextContato.getText().toString().trim();
        String endereco = editTextEndereco.getText().toString().trim();

        Usuario userInformation = new Usuario(nome, contato, endereco);
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
