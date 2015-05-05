package no_domain.phraseupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ChooseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);


        //podpiecie sie pod przycisk "Got it"
        Button backButton = (Button) findViewById(R.id.activity_choose_button_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //przekierowanie do MenuActivity
                startActivityForResult(new Intent(ChooseActivity.this, MenuActivity.class), 0);
            }
        });
    }
}
