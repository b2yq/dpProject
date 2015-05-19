package no_domain.phraseupproject.no_domain.phraseupproject.model;


public class UserResult {

    private long value;

    //-------Constructors----------
    public UserResult(long v)
    {
        value = v;
    }


    //----- Setters and Getters
    public long getValue() {
        return value;
    }
    public void increaseValue(){
        value++;
    }
    public void decreaseValue(){
        value--;
    }

}
