package no_domain.phraseupproject.no_domain.phraseupproject.model;


public class Word extends ModelBase {

    protected String english;
    protected String polish;
    protected String category;

    public Word(long id, String en, String pl, String cat){
        super(id);
        english = en;
        polish = pl;
        category = cat;
    }

    public String getValue(Language lang) {
        if(lang == Language.English) {
            return english;
        }else{
            return polish;
        }
    }

    public String getCategory() {
        return category;
    }
}
