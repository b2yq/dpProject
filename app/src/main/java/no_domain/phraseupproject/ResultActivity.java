package no_domain.phraseupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ResultActivity extends Activity {

    private ApplicationPhraseUp app;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        app = (ApplicationPhraseUp)getApplication();

        //podpiecie sie pod przycisk "Powrot"
        Button backButton = (Button) findViewById(R.id.activity_result_button_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //przekierowanie do MenuActivity
                startActivityForResult(new Intent(ResultActivity.this, MenuActivity.class), 0);
            }
        });

        //podpiecie sie pod przycisk "Sprobuj jeszcze raz"
        Button onceAgainButton = (Button) findViewById(R.id.activity_result_button_once_again);
        onceAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //przekierowanie do ChallengeActivity
                startActivityForResult(new Intent(ResultActivity.this, ChallengeActivity.class), 0);
            }
        });
    }


    //Ta metoda wykonuje sie za kazdym razem kiedy Success activity bedzie wystartowana
    @Override
    protected void onStart() {
        super.onStart();

        // povbiera intent przekazany z ChallengeActivity
        Intent intent = getIntent();

        RelativeLayout layout =(RelativeLayout)findViewById(R.id.activity_result_layout);

        // get the extra value
        String status = intent.getStringExtra("STATUS");
        String successWord = intent.getStringExtra("SUCCESSWORD");

        TextView title = (TextView)findViewById(R.id.activity_result_TitleTextView1);

        // "Gratulacje, wybrałeś poprawną odpowiedź!"

        if(status.contentEquals("SUCCESS"))
        {
            title.setText("Gratulacje! Wybrałeś poprawną odpowiedź.");
            layout.setBackgroundColor(getResources().getColor(R.color.successBackground));
        }
        else
        {
            title.setText(String.format("Niestety wybrałeś złą odpowiedź. Poprawna odpowiedź to:\n'%s'",successWord));
            layout.setBackgroundColor(getResources().getColor(R.color.failBackground));
        }

        //powinnismy pobrac biezacy wynik i ustawic go na widoku
        TextView resultValue = (TextView)findViewById(R.id.activity_result_ResultValueTextView);
        resultValue.setText((String.valueOf(app.getResult())));

    }
}
