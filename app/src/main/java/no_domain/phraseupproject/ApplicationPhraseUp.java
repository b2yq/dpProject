package no_domain.phraseupproject;

import android.app.Application;
import android.graphics.Typeface;

import java.util.ArrayList;

import no_domain.phraseupproject.no_domain.phraseupproject.data.DataManager;
import no_domain.phraseupproject.no_domain.phraseupproject.data.IDataManager;
import no_domain.phraseupproject.no_domain.phraseupproject.model.UserResult;
import no_domain.phraseupproject.no_domain.phraseupproject.model.WordsChallengeGroup;

public class ApplicationPhraseUp extends Application {

    private IDataManager dataManager;

    private UserResult result;

    ArrayList<Typeface> fonts;

    public long getResult()
    {
        return dataManager.getResult().getValue();
    }

    public void increaseResult()
    {
        result.increaseValue();
        dataManager.saveResult(result);
    }
    
    public void decreaseResult()
    {
        result.decreaseValue();
        dataManager.saveResult(result);
    }

    public WordsChallengeGroup getRandomWordsGroup(){
        return dataManager.getRandomWordsChallengeGroup();
    }

    public Typeface getFont(int index)
    {
        return fonts.get(index);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dataManager = new DataManager(this);
        result = dataManager.getResult();

        fonts = new ArrayList<>();
        //fonts.add(Typeface.createFromAsset(getAssets(), "Daniel_BOLD.ttf"));
        //fonts.add(Typeface.createFromAsset(getAssets(), "SpriteGraffiti.otf"));
        fonts.add(Typeface.createFromAsset(getAssets(), "chinese_rocks.ttf"));
    }

    @Override
    public void onTerminate() {
        // not guaranteed to be called
        super.onTerminate();
    }
}
