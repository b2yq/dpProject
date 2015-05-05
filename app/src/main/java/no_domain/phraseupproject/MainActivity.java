package no_domain.phraseupproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ustawienie czcionki na polu tesktowym
        Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "Daniel_BOLD.ttf");
        TextView myTextView = (TextView) findViewById(R.id.activity_main_mainTextView);
        myTextView.setTypeface(myTypeFace);

        //podpiecie onClick-a na calym layoucie
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.activity_main_mainLayout);
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView myTextView = (TextView) findViewById(R.id.activity_main_mainTextView);
                myTextView.setTextColor(getResources().getColor(R.color.darkBlue));
                //przekierowanie do drugiego activity
                startActivityForResult(new Intent(MainActivity.this, MenuActivity.class), 0);
            }
        });
    }
}
