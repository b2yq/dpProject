package no_domain.phraseupproject.no_domain.phraseupproject.data;


import no_domain.phraseupproject.no_domain.phraseupproject.model.UserResult;
import no_domain.phraseupproject.no_domain.phraseupproject.model.WordsChallengeGroup;

public interface IDataManager {

    //
    //zwraca Result z bazy danych
    //
    UserResult getResult();


    //
    //zapisuje result do bazy danycch
    //
    void saveResult(UserResult entity);


    //
    // Zwraca wylosowana grope slow do nowego zadania
    //
    WordsChallengeGroup getRandomWordsChallengeGroup();
}
