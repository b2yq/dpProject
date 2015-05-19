package no_domain.phraseupproject.no_domain.phraseupproject.data;

import android.os.Environment;


public class DataConstants {

    private static final String APP_PACKAGE_NAME = "no_domain.phraseupproject";

    public static final String LOG_TAG = "PhraseUp";

    public static final String DATABASE_NAME = "PhraseUpDataBase.db";
    public static final String DATABASE_PATH =
            Environment.getDataDirectory() + "/data/" + DataConstants.APP_PACKAGE_NAME + "/databases/" + DataConstants.DATABASE_NAME;

    private DataConstants() {
    }
}
