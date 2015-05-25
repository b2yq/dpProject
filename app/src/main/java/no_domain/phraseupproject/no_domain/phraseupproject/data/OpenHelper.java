package no_domain.phraseupproject.no_domain.phraseupproject.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class OpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private final Context context;


    OpenHelper(final Context context) {
        super(context, DataConstants.DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    @Override
    public void onOpen(final SQLiteDatabase db) {
        super.onOpen(db);

        boolean dbExist = checkDataBase();

        if (dbExist) {
            //do nothing - database already exist
            //this.getReadableDatabase();
        } else {

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();
        }
        try {

            copyDataBase();

        } catch (IOException e) {

            throw new Error("Error copying database");

        }


//        if (!db.isReadOnly()) {
//            // versions of SQLite older than 3.6.19 don't support foreign keys
//            // and neither do any version compiled with SQLITE_OMIT_FOREIGN_KEY
//            // http://www.sqlite.org/foreignkeys.html#fk_enable
//            //
//            // make sure foreign key support is turned on if it's there (should be already, just a double-checker)
//            db.execSQL("PRAGMA foreign_keys=ON;");
//
//            // then we check to make sure they're on
//            // (if this returns no data they aren't even available, so we shouldn't even TRY to use them)
//            Cursor c = db.rawQuery("PRAGMA foreign_keys", null);
//            if (c.moveToFirst()) {
//                int result = c.getInt(0);
//                Log.i(DataConstants.LOG_TAG, "SQLite foreign key support (1 is on, 0 is off): " + result);
//            } else {
//                // could use this approach in onCreate, and not rely on foreign keys it not available, etc.
//                Log.i(DataConstants.LOG_TAG, "SQLite foreign key support NOT AVAILABLE");
//                // if you had to here you could fall back to triggers
//            }
//            if (!c.isClosed()) {
//                c.close();
//            }
//        }
    }

    @Override
    public void onCreate(final SQLiteDatabase db) {

        Log.i(DataConstants.LOG_TAG, "DataHelper.OpenHelper onCreate creating database " + DataConstants.DATABASE_NAME);

        //UserSettingsTable.onCreate(db);
    }

    @Override
    public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {

        Log.i(DataConstants.LOG_TAG, "SQLiteOpenHelper onUpgrade - oldVersion:" + oldVersion + " newVersion:" + newVersion);

        //UserSettingsTable.onUpgrade(db, oldVersion, newVersion);
    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = DataConstants.DATABASE_PATH;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){

            //database does't exist yet.

        }

        if(checkDB != null){
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException{

        //Open your local db as the input stream
        InputStream myInput = context.getAssets().open(DataConstants.DATABASE_NAME);

        // Path to the just created empty db
        String outFileName = DataConstants.DATABASE_PATH;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }
}

