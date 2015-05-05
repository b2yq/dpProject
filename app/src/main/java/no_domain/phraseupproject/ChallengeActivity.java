package no_domain.phraseupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ChallengeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);


        //podpiecie sie pod przycisk TextView z poprawna odpowiedzia
        TextView backButton = (TextView) findViewById(R.id.activity_challenge_textView3);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //przekierowanie do SuccessActivity
                startActivityForResult(new Intent(ChallengeActivity.this, SuccessActivity.class), 0);
            }
        });
    }
}
