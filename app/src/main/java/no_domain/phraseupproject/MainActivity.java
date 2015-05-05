package no_domain.phraseupproject;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ustawienie czcionki na polu tesktowym
        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"Daniel_BOLD.ttf");
        TextView myTextView = (TextView)findViewById(R.id.mainTextView);
        myTextView.setTypeface(myTypeFace);

        //podpiecie onClick-a na calym layoucie
        RelativeLayout mainLayout =(RelativeLayout)findViewById(R.id.mainLayout);
        mainLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView myTextView = (TextView)findViewById(R.id.mainTextView);
                myTextView.setTextColor(getResources().getColor(R.color.darkBlue));
                //startActivityForResult(new Intent(A_My_Galaxy.this,C_Student_Book_Planet.class), 0);
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
