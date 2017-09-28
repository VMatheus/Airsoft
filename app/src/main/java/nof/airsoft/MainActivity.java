package nof.airsoft;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mTextMessage;
    private Button buttonProfile;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_estatisticas:
                    mTextMessage.setText("Equipes");
                    return true;
                case R.id.navigation_miequipe:
                    mTextMessage.setText("Minha Equipe");
                    return true;
                case R.id.navigation_equipes:
                    mTextMessage.setText("Estatisticas");
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonProfile = (Button) findViewById(R.id.buttonProfile);
        buttonProfile.setOnClickListener(this);

        String[] Equipes = {};
        ListView listaEquipes = (ListView) findViewById(R.id.lista_equipes);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_gallery_item, Equipes);
        listaEquipes.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonProfile){
            startActivity(new Intent(this, ProfileActivity.class));
        }
    }
}
