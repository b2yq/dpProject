package no_domain.phraseupproject.no_domain.phraseupproject.data;


import no_domain.phraseupproject.no_domain.phraseupproject.model.UserResult;

public interface IDataManager {

    //
    //zwraca Result z bazy danych
    //
    UserResult getResult();


    //
    //zapisuje result do bazy danycch
    //
    void saveResult(UserResult entity);

}
