package dao;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import activitys.LoginActivity;
import nof.airsoft.MainActivity;

public class FirebaseDao {

    private static FirebaseAuth auth = ConfiguracoesFirebase.getFirebaseAutenticacao();
    private ProgressDialog progressDoalog;

    public void login(String email, String password, final AppCompatActivity context) {

        progressDoalog = new ProgressDialog(context);
        progressDoalog.setMessage("Aguarde ... ");
        progressDoalog.show();

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    //main principal
                    context.finish();
                    context.startActivity(new Intent(context, MainActivity.class));
                    progressDoalog.dismiss();

                } else {
                    progressDoalog.dismiss();
                    Log.w("ERROR", "signInWithEmail:failure", task.getException());
                    Toast.makeText(context, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void register(String email, String password, final AppCompatActivity context) {

        progressDoalog = new ProgressDialog(context);
        progressDoalog.setMessage("Aguarde ... ");
        progressDoalog.show();

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Log.d("SUCESS", "createUserWithEmail:success");
                            FirebaseUser user = ConfiguracoesFirebase.auth.getCurrentUser();
                            context.finish();
                            context.startActivity(new Intent(context, MainActivity.class));
                            progressDoalog.dismiss();

                        } else {
                            // If sign in fails, display a message to the user.
                            progressDoalog.dismiss();
                            Log.w("ERROR", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(context, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }

    public void signOut(final AppCompatActivity activity) {

        progressDoalog = new ProgressDialog(activity);
        progressDoalog.setMessage("Aguarde ... ");
        progressDoalog.show();
        auth.signOut();
        activity.finish();
        activity.startActivity(new Intent(activity, LoginActivity.class));
        progressDoalog.dismiss();
    }
}
