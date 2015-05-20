package no_domain.phraseupproject.no_domain.phraseupproject.data.dataTables;


import android.provider.BaseColumns;

public class WordsTable {

    //STALE
    public static final String TABLE_NAME = "words";

    public static class WordsTableColumns implements BaseColumns {
        public static final String ID = "_id";
        public static final String EN = "en";
        public static final String PL = "pl";
    }
}
