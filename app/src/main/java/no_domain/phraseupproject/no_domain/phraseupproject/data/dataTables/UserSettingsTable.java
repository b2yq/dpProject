package no_domain.phraseupproject.no_domain.phraseupproject.data.dataTables;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;


public final class UserSettingsTable {

    //STALE
    public static final String TABLE_NAME = "user_settings";

    public static class UserSettingsColumns implements BaseColumns {
        public static final String ID = "_id";
        public static final String NAME = "name";
        public static final String VALUE_INT = "value_int";
    }

    //Funkcja do tworzenia tabeli
//    public static void onCreate(SQLiteDatabase db) {
//
//        //Buduje w stringu SQL-a:
//        //CREATE TABLE user_settings
//        //(
//        //      _id INTEGER PRIMARY KEY,
//        //      name INTEGER,
//        //      value_int   INTEGER
//        //);
//
//        //Ktory stworzy tabele z kolumnami: _id, name, value_int. W androidzie kazda tabela,
//        //zeby moc byc podlaczona pod kod, musi miec kolumne o nazwie "_id" ustawiona jako klucz tabeli
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("CREATE TABLE " + UserSettingsTable.TABLE_NAME + " (");
//        sb.append(BaseColumns._ID + " INTEGER PRIMARY KEY, ");
//        sb.append(UserSettingsColumns.NAME + " TEXT UNIQUE NOT NULL, ");
//        sb.append(UserSettingsColumns.VALUE_INT + " INTEGER");
//        sb.append(");");
//
//        //wywoluje stworzonego SQL-a
//        db.execSQL(sb.toString());
//    }

//    //Funkcja do odtworzzenia tabeli po update-ie
//    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//        //Wywoluje SQL-a:
//        //DROP TABLE IF EXISTS user_settings
//        db.execSQL("DROP TABLE IF EXISTS " + UserSettingsTable.TABLE_NAME);
//
//        //Laduje nasza tabele od nowa
//        UserSettingsTable.onCreate(db);
//
//        //brakuje przywrocenia danych
//    }
}