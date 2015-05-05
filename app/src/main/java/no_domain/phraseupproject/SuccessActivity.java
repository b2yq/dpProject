package no_domain.phraseupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class SuccessActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);


        //podpiecie sie pod przycisk "Nowe wyzwanie"
        Button backButton = (Button) findViewById(R.id.activity_success_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //przekierowanie do MenuActivity
                startActivityForResult(new Intent(SuccessActivity.this, MenuActivity.class), 0);
            }
        });
    }
}
