package no_domain.phraseupproject.no_domain.phraseupproject.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import android.util.Log;

import no_domain.phraseupproject.no_domain.phraseupproject.data.dataAccessObjects.UserResultDao;
import no_domain.phraseupproject.no_domain.phraseupproject.data.dataAccessObjects.WordsChallengeGroupDao;
import no_domain.phraseupproject.no_domain.phraseupproject.model.UserResult;
import no_domain.phraseupproject.no_domain.phraseupproject.model.WordsChallengeGroup;


public class DataManager implements IDataManager{

    private Context context;
    private SQLiteDatabase db;

    private UserResultDao resultDao;
    private WordsChallengeGroupDao wordsGroupDao;

    public DataManager(Context context)
    {
        this.context = context;
        SQLiteOpenHelper openHelper = new OpenHelper(this.context);
        openHelper.close();
        db = openHelper.getReadableDatabase();
        Log.i(DataConstants.LOG_TAG, "DataManagerImpl created, db open status: " + db.isOpen());

        resultDao = new UserResultDao(db);
        wordsGroupDao = new WordsChallengeGroupDao(db);
    }

    //public SQLiteDatabase getDb() {
    //    return db;
    //}

    private void openDb() {
        if (!db.isOpen()) {
            db = SQLiteDatabase.openDatabase(DataConstants.DATABASE_PATH, null, SQLiteDatabase.OPEN_READWRITE);
            // since we pass db into DAO, have to recreate DAO if db is re-opened

            resultDao = new UserResultDao(db);
            wordsGroupDao = new WordsChallengeGroupDao(db);
        }
    }

    private void closeDb() {
        if (db.isOpen()) {
            db.close();
        }
    }

    private void resetDb() {
        Log.i(DataConstants.LOG_TAG, "Resetting database connection (close and re-open).");
        closeDb();
        SystemClock.sleep(500);
        openDb();
    }

    //
    // "Manager" data methods that wrap DAOs
    //
    // this lets us encapsulate usage of DAOs
    // we only expose methods app is actually using, and we can combine DAOs, with logic in one place
    //

    public UserResult getResult()
    {
        return resultDao.select();
    }

    public void saveResult(UserResult entity)
    {
        resultDao.update(entity);
    }

    public WordsChallengeGroup getRandomWordsChallengeGroup()
    {
        return wordsGroupDao.selectRandomWordsChallengeGroup();
    }
}
