package activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import dao.ConfiguracoesFirebase;
import dao.FirebaseDao;


public class MainActivity extends AppCompatActivity  {
    private static FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        auth = ConfiguracoesFirebase.getFirebaseAutenticacao();

        initViews();
        invalidateOptionsMenu();
        getSupportActionBar().show();

    }

    private void initViews() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
           case R.id.desconectar:
                new FirebaseDao().signOut(MainActivity.this);

               break;
                default:
                    break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser =  auth.getCurrentUser();
        updateUI(currentUser);
        invalidateOptionsMenu();
        getSupportActionBar().show();
    }

    private void updateUI(FirebaseUser currentUser) {
        if(currentUser == null){
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));


        }else {

        }
    }




}
