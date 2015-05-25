package no_domain.phraseupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //activity_info_title_textView
        ApplicationPhraseUp app = (ApplicationPhraseUp)getApplication();

        TextView title = (TextView) findViewById(R.id.activity_info_title_textView);
        title.setTypeface(app.getFont(0));

        TextView info = (TextView) findViewById(R.id.activity_info_info_text);
        info.setTypeface(app.getFont(0));


        TextView text2 = (TextView) findViewById(R.id.textView2);
        text2.setTypeface(app.getFont(0));
        TextView text21 = (TextView) findViewById(R.id.textView21);
        text21.setTypeface(app.getFont(0));
        TextView text3 = (TextView) findViewById(R.id.textView3);
        text3.setTypeface(app.getFont(0));
        TextView text31 = (TextView) findViewById(R.id.textView31);
        text31.setTypeface(app.getFont(0));
        TextView text4 = (TextView) findViewById(R.id.textView4);
        text4.setTypeface(app.getFont(0));
        TextView text41 = (TextView) findViewById(R.id.textView41);
        text41.setTypeface(app.getFont(0));


        //podpiecie sie pod przycisk "Got it"
        Button backButton = (Button) findViewById(R.id.activity_info_button_back);
        backButton.setTypeface(app.getFont(0));
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //przekierowanie do MenuActivity
                startActivityForResult(new Intent(InfoActivity.this, MenuActivity.class), 0);
            }
        });

    }
}
