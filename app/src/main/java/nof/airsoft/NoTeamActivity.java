package nof.airsoft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoTeamActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonCriar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_team);

        buttonCriar = (Button) findViewById(R.id.criarEquipe);
        buttonCriar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == buttonCriar){
            startActivity(new Intent(this, RegistroEquipeActivity.class));
            finish();
        }
    }
}
