package no_domain.phraseupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ChooseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        //activity_choose_textView
        ApplicationPhraseUp app = (ApplicationPhraseUp)getApplication();
        TextView title = (TextView) findViewById(R.id.activity_choose_textView);
        title.setTypeface(app.getFont(0));

        Button button1 = (Button) findViewById(R.id.activity_choose_button1);
        button1.setTypeface(app.getFont(0));
        Button button2 = (Button) findViewById(R.id.activity_choose_button2);
        button2.setTypeface(app.getFont(0));
        Button button3 = (Button) findViewById(R.id.activity_choose_button3);
        button3.setTypeface(app.getFont(0));

        //podpiecie sie pod przycisk "Got it"
        Button backButton = (Button) findViewById(R.id.activity_choose_button_back);
        backButton.setTypeface(app.getFont(0));
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //przekierowanie do MenuActivity
                startActivityForResult(new Intent(ChooseActivity.this, MenuActivity.class), 0);
            }
        });

        //podpiecie sie pod przycisk "Nowe wyzwanie"
        Button challengeButton = (Button) findViewById(R.id.activity_choose_button1);
        challengeButton.setTypeface(app.getFont(0));
        challengeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //przekierowanie do MenuActivity
                startActivityForResult(new Intent(ChooseActivity.this, ChallengeActivity.class), 0);
            }
        });
    }
}
