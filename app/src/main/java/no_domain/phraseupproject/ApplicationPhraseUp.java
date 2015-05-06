package no_domain.phraseupproject;

import android.app.Application;

/**
 * Created by OOC-Paweł on 2015-05-05.
 */
public class ApplicationPhraseUp extends Application {


    private long result = 0;
    public long getResult() {
        return result;
    }
    public void IncreaseResult(){
        result++;
    }
    public void DecreaseResult(){
        result--;
    }

}
