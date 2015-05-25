package no_domain.phraseupproject.no_domain.phraseupproject.data.dataAccessObjects;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;


import no_domain.phraseupproject.no_domain.phraseupproject.data.dataTables.UserSettingsTable;
import no_domain.phraseupproject.no_domain.phraseupproject.model.UserResult;

public class UserResultDao {

    public static final String RESULT = "result";

    // Wzor naszego SQL-a (moze byc wykorzystany wiele razy):
    //
    //  UPDATE user_settings
    //  SET value_int = {arg}
    //  WHERE name = 'result';
    //

    private static final String UPDATE_VALUE_INT_QUERY_BASE =
            "UPDATE " + UserSettingsTable.TABLE_NAME +" "+
            "SET "+ UserSettingsTable.UserSettingsColumns.VALUE_INT + "=? "+
            "WHERE "+UserSettingsTable.UserSettingsColumns.NAME+"='"+RESULT+"';";

    //
    // SELECT value_int
    // FROM user_settings
    // WHERE name='result'
    //
    private static final String SELECT_VALUE_INT_QUERY_BASE =
            "SELECT "+ UserSettingsTable.UserSettingsColumns.VALUE_INT+ " FROM "+ UserSettingsTable.TABLE_NAME+" WHERE "+UserSettingsTable.UserSettingsColumns.NAME+"= '"+ RESULT +"';";

    private SQLiteDatabase db;
    private SQLiteStatement updateValueIntStatement;
    private SQLiteStatement selectValueIntStatement;



    //---------Constructor-----------
    public UserResultDao(SQLiteDatabase db) {
        this.db = db;
        updateValueIntStatement = db.compileStatement(UserResultDao.UPDATE_VALUE_INT_QUERY_BASE);
        selectValueIntStatement = db.compileStatement(UserResultDao.SELECT_VALUE_INT_QUERY_BASE);
    }




    public int update(UserResult entity) {
        updateValueIntStatement.clearBindings();
        updateValueIntStatement.bindLong(1, entity.getValue());
        return updateValueIntStatement.executeUpdateDelete();
    }

    public UserResult select()
    {
        long result = selectValueIntStatement.simpleQueryForLong();
        return new UserResult(result);
    }
}
