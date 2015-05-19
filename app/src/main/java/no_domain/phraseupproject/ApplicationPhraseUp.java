package no_domain.phraseupproject;

import android.app.Application;

import no_domain.phraseupproject.no_domain.phraseupproject.data.DataManager;
import no_domain.phraseupproject.no_domain.phraseupproject.data.IDataManager;
import no_domain.phraseupproject.no_domain.phraseupproject.model.UserResult;

public class ApplicationPhraseUp extends Application {

    private IDataManager dataManager;

    private UserResult result;

    public long getResult() {
        return dataManager.getResult().getValue();
    }
    public void IncreaseResult(){
        result.increaseValue();
        dataManager.saveResult(result);
    }
    public void DecreaseResult(){
        result.decreaseValue();
        dataManager.saveResult(result);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        dataManager = new DataManager(this);
        result = dataManager.getResult();
    }

    @Override
    public void onTerminate() {
        // not guaranteed to be called
        super.onTerminate();
    }
}
