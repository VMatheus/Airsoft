package nof.airsoft;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetActivity extends AppCompatActivity {

    private AutoCompleteTextView email;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

    private void init(){
        email = (AutoCompleteTextView) findViewById(R.id.email);
    }

    public void reset( View view ){
        firebaseAuth
            .sendPasswordResetEmail( email.getText().toString() )
            .addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if( task.isSuccessful() ){
                        email.setText("");
                        Toast.makeText(
                            ResetActivity.this,
                            "Recuperação de acesso iniciada. Email enviado.",
                            Toast.LENGTH_SHORT
                        ).show();
                    }
                    else{
                        Toast.makeText(
                            ResetActivity.this,
                            "Falhou! Tente novamente",
                            Toast.LENGTH_SHORT
                        ).show();
                    }
                }
            });
    }
}
