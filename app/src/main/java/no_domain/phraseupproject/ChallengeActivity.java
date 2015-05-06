package no_domain.phraseupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ChallengeActivity extends Activity {

    private ApplicationPhraseUp app;
    //Handler do obslugi sukcesu
    private View.OnClickListener SuccessOnClickHandler;
    //Handler do obslugi porazki
    private View.OnClickListener FailOnClickHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        app = (ApplicationPhraseUp) getApplication();

        //inicjalizacja handlera, czyli zapisanie funkcji pod zmienna, to sie wykona dopiero po kliku
        SuccessOnClickHandler = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //zapisujemy informacje o tym ze uzytkpownik wybrał dobrze
                app.IncreaseResult();
                //przekierowanie do SuccessActivity
                startActivityForResult(new Intent(ChallengeActivity.this, ResultActivity.class), 0);
            }
        };
        FailOnClickHandler = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //zapisujemy informacje o tym ze uzytkpownik wybrał zle
                app.DecreaseResult();
                //przekierowanie do FailActivity
                startActivityForResult(new Intent(ChallengeActivity.this, ResultActivity.class), 0);
            }
        };
    }



    @Override
    protected void onStart() {
        super.onStart();
        //dlatego Listener-y bedziemy podpinac pod startem, bo tu bedziemy losowac slowa i przydzielac pod kontrolki wiec
        //tez bedziemy odpowiednio podpinac pod kontrolki


        //podpiecie handlera pod przycisk TextView z poprawna odpowiedzia
        TextView properAnswer = (TextView) findViewById(R.id.activity_challenge_textView3);
        properAnswer.setOnClickListener(SuccessOnClickHandler);

        //podpiecie handlera pod pozostałem TextViews z błednymi odpowiedziami
        TextView wrongAnswer1 = (TextView) findViewById(R.id.activity_challenge_textView1);
        wrongAnswer1.setOnClickListener(FailOnClickHandler);
        TextView wrongAnswer2 = (TextView) findViewById(R.id.activity_challenge_textView2);
        wrongAnswer2.setOnClickListener(FailOnClickHandler);
        TextView wrongAnswer3 = (TextView) findViewById(R.id.activity_challenge_textView4);
        wrongAnswer3.setOnClickListener(FailOnClickHandler);
    }


    @Override
    protected void onStop() {
        super.onStop();
    }
}
