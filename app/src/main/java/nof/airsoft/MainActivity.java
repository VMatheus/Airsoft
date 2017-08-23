package nof.airsoft;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_estatisticas:
                    mTextMessage.setText(R.string.title_estatisticas);
                    return true;
                case R.id.navigation_miequipe:
                    mTextMessage.setText(R.string.title_miequipe);
                    return true;
                case R.id.navigation_equipes:
                    mTextMessage.setText(R.string.title_equipes);
                    return true;
                case R.id.navigation_jogos:
                    mTextMessage.setText(R.string.title_jogos);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
