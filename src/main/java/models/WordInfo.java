package models;

public class WordInfo {
    private Integer wordID;
    private Integer languageID;
    private String word;
    private String definition;
    private String exampleSentence;
    private String pronunciation;
    private String etymology;

    public WordInfo(){
    }

    public WordInfo(Integer wordID, Integer languageID, String word, String definition, String exampleSentence, String pronunciation, String etymology) {
        this.wordID = wordID;
        this.languageID = languageID;
        this.word = word;
        this.definition = definition;
        this.exampleSentence = exampleSentence;
        this.pronunciation = pronunciation;
        this.etymology = etymology;
    }

    public WordInfo(Integer languageID, String word, String definition, String exampleSentence, String pronunciation, String etymology) {
        this.languageID = languageID;
        this.word = word;
        this.definition = definition;
        this.exampleSentence = exampleSentence;
        this.pronunciation = pronunciation;
        this.etymology = etymology;
    }

    public Integer getWordID() {
        return wordID;
    }

    public void setWordID(Integer wordID) {
        this.wordID = wordID;
    }

    public Integer getLanguageID() {
        return languageID;
    }

    public void setLanguageID(Integer languageID) {
        this.languageID = languageID;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExampleSentence() {
        return exampleSentence;
    }

    public void setExampleSentence(String exampleSentence) {
        this.exampleSentence = exampleSentence;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getEtymology() {
        return etymology;
    }

    public void setEtymology(String etymology) {
        this.etymology = etymology;
    }

    @Override
    public String toString() {
        return "word: " + word;
    }
}
