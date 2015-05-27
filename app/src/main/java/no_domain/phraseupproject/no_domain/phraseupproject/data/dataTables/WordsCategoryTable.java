package no_domain.phraseupproject.no_domain.phraseupproject.data.dataTables;


import android.provider.BaseColumns;

public class WordsCategoryTable {
    //STALE
    public static final String TABLE_NAME = "words_category";

    public static class WordsCategoryTableColumns implements BaseColumns {
        public static final String WORD_ID = "word_id";
        public static final String CATEGORY_ID = "category_id";
    }
}
