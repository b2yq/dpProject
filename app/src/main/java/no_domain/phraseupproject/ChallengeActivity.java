package no_domain.phraseupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import no_domain.phraseupproject.no_domain.phraseupproject.model.WordsChallengeGroup;


public class ChallengeActivity extends Activity {

    private ApplicationPhraseUp app;

    //generator liczb losowych uzywany do losowania na ktorej kontrolce bedzie poprawna odpowiedz
    private Random randomGenerator;

    //srodkowa kontrolka wyswietlajaca slowo
    private TextView center;
    //kontrolki do okola wyswietlajace tlumaczenia slowek
    private ArrayList<TextView> answers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);


        app = (ApplicationPhraseUp) getApplication();
        randomGenerator = new Random();

        TextView title = (TextView) findViewById(R.id.activity_challenge_textViewTop);
        title.setTypeface(app.getFont(0));

        center = (TextView) findViewById(R.id.activity_challenge_textViewCenter);
        center.setTypeface(app.getFont(0));

        answers = new ArrayList<>();
        answers.add((TextView) findViewById(R.id.activity_challenge_textView1));
        answers.add((TextView) findViewById(R.id.activity_challenge_textView2));
        answers.add((TextView) findViewById(R.id.activity_challenge_textView3));
        answers.add((TextView) findViewById(R.id.activity_challenge_textView4));

        for(TextView text : answers)
        {
            text.setTypeface(app.getFont(0));
        }
    }



    @Override
    protected void onStart() {
        super.onStart();
        //dlatego Listener-y bedziemy podpinac pod startem, bo tu bedziemy losowac slowa i przydzielac pod kontrolki wiec
        //tez bedziemy odpowiednio podpinac pod kontrolki


        //pobranie losowych slow z bazy
        WordsChallengeGroup group = app.getRandomWordsGroup();

        //usupelnienie textViewCenter
        center.setText(group.getSuccessWord());

        //wylosowanie numeru kontrolki pod ktora bedzie poprawna odpowiedz
        int index = randomGenerator.nextInt(answers.size());

        //uzupelnienie kontrolki o tresc i podpiecie poprawnego eventa, ktory w razie wybrania doda punkt na plus i przekieruje do ResultActivity
        TextView properAnswer = answers.get(index);
        properAnswer.setText(group.getSuccessWordTranslation());
        ChallengeOnClickListener onSuccess = new ChallengeOnClickListener(this, true, group.getSuccessWord());
        properAnswer.setOnClickListener(onSuccess);//SuccessOnClickHandler);

        ChallengeOnClickListener onFail = new ChallengeOnClickListener(this, false, group.getSuccessWord());

        int j =0;
        for(int i=0; i<answers.size(); i++) {
            //zignoruj juz ustawiona kontrolke, w ktorej jest poprawna odpowiedz
            if (i == index) {
                continue;
            }

            //wez slowo z wylosowanch zlych podpowiedzi i ustaw na kontrolce
            TextView wrongAnswer = answers.get(i);
            wrongAnswer.setOnClickListener(onFail);//FailOnClickHandler);
            wrongAnswer.setText(group.getFailWordsTranslations().get(j));
            j++;
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
    }
}
