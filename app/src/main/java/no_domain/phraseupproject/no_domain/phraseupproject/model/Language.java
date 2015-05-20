package no_domain.phraseupproject.no_domain.phraseupproject.model;

public enum Language {
    English,
    Polish;

    Language getOtherLanguage() {

        if(this == Language.English) {
            return Language.Polish;
        }else{
            return Language.English;
        }

    }
}
