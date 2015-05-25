package no_domain.phraseupproject.no_domain.phraseupproject.model;

import java.util.ArrayList;
import java.util.List;

//
// Klasa zawiera grope slow, z jednej kategorii
//
public class WordsChallengeGroup {

    //success word
    private Word successWord;

    // failWords
    private List<Word> failWords;

    // jezyk w jakim bedzie przedstawiane slowo kluczowe - success
    private Language langSuccess;


    public WordsChallengeGroup(Language lang, Word success, List<Word> fail)
    {
        successWord = success;
        failWords = new ArrayList<Word>();
        failWords.addAll(fail);
        langSuccess = lang;
    }


    public String getSuccessWord()
    {
        return successWord.getValue(langSuccess);
    }


    public String getSuccessWordTranslation()
    {
        return successWord.getValue(langSuccess.getOtherLanguage());
    }


    public List<String> getFailWordsTranslations()
    {
        List<String> values = new ArrayList<String>();

        for(Word w : failWords){
            values.add(w.getValue(langSuccess.getOtherLanguage()));
        }

        return values;
    }

}
