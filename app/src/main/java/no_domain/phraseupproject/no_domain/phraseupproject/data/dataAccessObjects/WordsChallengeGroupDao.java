package no_domain.phraseupproject.no_domain.phraseupproject.data.dataAccessObjects;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import no_domain.phraseupproject.no_domain.phraseupproject.data.dataTables.CategoryTable;
import no_domain.phraseupproject.no_domain.phraseupproject.data.dataTables.WordsTable;
import no_domain.phraseupproject.no_domain.phraseupproject.model.Language;
import no_domain.phraseupproject.no_domain.phraseupproject.model.Word;
import no_domain.phraseupproject.no_domain.phraseupproject.model.WordsChallengeGroup;

public class WordsChallengeGroupDao {

    //
    // SELECT words._id, words.en, words.pl, category.name
    // FROM words
    // JOIN category
    // ORDER BY RANDOM() LIMIT 1
    //
    private static final String GET_RANDOM_WORD_QUERY_BASE =
                    "SELECT " +
                    WordsTable.TABLE_NAME + "." + WordsTable.WordsTableColumns._ID + ", " +
                    WordsTable.TABLE_NAME + "." + WordsTable.WordsTableColumns.EN + ", " +
                    WordsTable.TABLE_NAME + "." + WordsTable.WordsTableColumns.PL + ", " +
                    CategoryTable.TABLE_NAME + "." + CategoryTable.CategoryTableColumns.NAME + " "+
                    "FROM " + WordsTable.TABLE_NAME + " "+
                    "JOIN " + CategoryTable.TABLE_NAME+ " "+
                    "ORDER BY RANDOM() LIMIT 1";


    //
    // SELECT words._id,  words.en,  words.pl, category.name
    // FROM words
    // JOIN category
    // WHERE words._id != ? AND category.name = '?'
    // ORDER BY RANDOM() LIMIT 3
    //
    private static final String GET_RANDOM_GROUP_WORDS_QUERY_BASE = "SELECT "+
            WordsTable.TABLE_NAME + "." + WordsTable.WordsTableColumns._ID + ", " +
            WordsTable.TABLE_NAME + "." + WordsTable.WordsTableColumns.EN + ", " +
            WordsTable.TABLE_NAME + "." + WordsTable.WordsTableColumns.PL + ", " +
            CategoryTable.TABLE_NAME + "." + CategoryTable.CategoryTableColumns.NAME + " "+
            "FROM " + WordsTable.TABLE_NAME + " "+
            "JOIN " + CategoryTable.TABLE_NAME + " "+
            "WHERE "+ WordsTable.TABLE_NAME + "." + WordsTable.WordsTableColumns._ID + "!=? "+
            "AND "+ CategoryTable.TABLE_NAME + "." + CategoryTable.CategoryTableColumns.NAME + "=? "+
            "ORDER BY RANDOM() LIMIT 3";


    private SQLiteDatabase db;

    //---------Constructor-----------
    public WordsChallengeGroupDao(SQLiteDatabase db)
    {
        this.db = db;
    }


    public WordsChallengeGroup selectRandomWordsChallengeGroup()
    {
        //wczytywanie losowego slowa "success"
        Cursor cursor1 = db.rawQuery(GET_RANDOM_WORD_QUERY_BASE, null);

        Word successWord;
        if (cursor1.moveToFirst())
        {
            successWord = readWord(cursor1);
        }
        else
        {
            //Error
            return null;
        }

        //wczytywanie losowych slow z gropy slowa "success"
        Cursor cursor2 = db.rawQuery(
                GET_RANDOM_GROUP_WORDS_QUERY_BASE,
                new String[]{
                        String.valueOf(successWord.getId()),
                        successWord.getCategory()
                });

        List<Word> list = new ArrayList<Word>();
        while (cursor2.moveToNext())
        {
            list.add(readWord(cursor2));
        }

        return new WordsChallengeGroup(Language.English, successWord, list);
    }

    private Word readWord(Cursor cursor)
    {
        long id = cursor.getLong(cursor.getColumnIndex(WordsTable.WordsTableColumns.ID));
        String en = cursor.getString( cursor.getColumnIndex(WordsTable.WordsTableColumns.EN) );
        String pl = cursor.getString( cursor.getColumnIndex(WordsTable.WordsTableColumns.PL) );
        String cat = cursor.getString( cursor.getColumnIndex(CategoryTable.CategoryTableColumns.NAME) );

        return new Word(id, en, pl, cat);
    }
}
