package no_domain.phraseupproject.no_domain.phraseupproject.model;


public class ModelBase {
    protected long id;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ModelBase(long id){
        this.id = id;
    }

}
