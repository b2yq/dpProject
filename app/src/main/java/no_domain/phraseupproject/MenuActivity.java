package no_domain.phraseupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ApplicationPhraseUp app = (ApplicationPhraseUp)getApplication();

        //podpiecie pierwszego przzycisku w menu "Ale o co chodzi"
        TextView info = (TextView)findViewById(R.id.activity_menu_buttonMenu1);
        info.setTypeface(app.getFont(0));
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //przekierowanie do InfoActivity
                startActivityForResult(new Intent(MenuActivity.this, InfoActivity.class), 0);
            }
        });


        //podpiecie drugiego przycisku w menu "Nowe wyzwanie"
        TextView choose = (TextView)findViewById(R.id.activity_menu_buttonMenu2);
        choose.setTypeface(app.getFont(0));
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //przekierowanie do ChalengeActivity
                startActivityForResult(new Intent(MenuActivity.this, ChooseActivity.class), 0);
            }
        });


        //podpiecie trzeciego przycisku w menu "Your score"
        TextView score = (TextView)findViewById(R.id.activity_menu_buttonMenu3);
        score.setTypeface(app.getFont(0));
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //przekierowanie do YourScoreActivity
                startActivityForResult(new Intent(MenuActivity.this, YourScoreActivity.class), 0);
            }
        });


        //podpiecie ostatniego przycisku "QUIT"
        TextView quit = (TextView)findViewById(R.id.activity_menu_buttonMenu4);
        quit.setTypeface(app.getFont(0));
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //skopiowane z neta, w androidzie nie wylacza się apki, to system decyduje kiedy ja wyłączyć, my tylko mozemy
                //przekierowac uzytkownika do ekranu domowego androida
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}
