package no_domain.phraseupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class YourScoreActivity extends Activity {

    private ApplicationPhraseUp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_score);


        app = (ApplicationPhraseUp) getApplication();
        TextView title = (TextView) findViewById(R.id.activity_your_score_textView);
        title.setTypeface(app.getFont(0));

        TextView score = (TextView) findViewById(R.id.activity_your_score_textView_score);
        score.setTypeface(app.getFont(0));


        //podpiecie sie pod przycisk "Back"
        Button backButton = (Button) findViewById(R.id.activity_choose_button_back);
        backButton.setTypeface(app.getFont(0));
        backButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                //przekierowanie do MenuActivity
                startActivityForResult(new Intent(YourScoreActivity.this, MenuActivity.class), 0);
            }
        });
    }

    //Ta metoda wykonuje sie za kazdym razem kiedy YourScoreActivity bedzie wystartowana
    @Override
    protected void onStart() {
        super.onStart();

        //powinnismy wtedy pobrac biezacy wynik i ustawic go na widoku
        TextView resultValue = (TextView)findViewById(R.id.activity_your_score_textView_score);
        resultValue.setText((String.valueOf(app.getResult())));
    }
}
