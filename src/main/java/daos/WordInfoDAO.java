package daos;

import models.WordInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WordInfoDAO implements DAO<WordInfo> {

    private List<WordInfo> words = new ArrayList<>();

    public WordInfoDAO(){
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM word_info");

            while(rs.next())
            {
                WordInfo word = extractWordInfoFromResultSet(rs);
                words.add(word);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private WordInfo extractWordInfoFromResultSet(ResultSet rs) throws SQLException {
        WordInfo word = new WordInfo();

        word.setWordID( rs.getInt("word_id") );
        word.setLanguageID( rs.getInt("language_id") );
        word.setWord( rs.getString("word") );
        word.setDefinition( rs.getString("definition") );
        word.setExampleSentence( rs.getString("example_sentence") );
        word.setPronunciation( rs.getString("pronunciation"));
        word.setEtymology( rs.getString("etymology"));

        return word;
    }


    @Override
    public WordInfo findById(int wordID) {
        for (WordInfo word: words){
            if (word.getWordID().equals(wordID)){
                return word;
            }
        }
        return null;
    }

    @Override
    public List<WordInfo> findAll() {
        return words;
    }

    @Override
    public WordInfo create(WordInfo wordInfo) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO word_info VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, wordInfo.getWordID());
            ps.setInt(2, wordInfo.getLanguageID());
            ps.setString(3, wordInfo.getWord());
            ps.setString(4, wordInfo.getDefinition());
            ps.setString(5, wordInfo.getExampleSentence());
            ps.setString(6, wordInfo.getPronunciation());
            ps.setString(7, wordInfo.getEtymology());
            int i = ps.executeUpdate();

            if(i == 1) {
                words.add(wordInfo);
                return wordInfo;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public WordInfo update(WordInfo wordInfo) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE word_info SET language_id=?, word=?, definition=?, example_sentence=?, pronunciation=?, etymology=? WHERE word_id=?");
            ps.setInt(1, wordInfo.getLanguageID());
            ps.setString(2, wordInfo.getWord());
            ps.setString(3, wordInfo.getDefinition());
            ps.setString(4, wordInfo.getExampleSentence());
            ps.setString(5, wordInfo.getPronunciation());
            ps.setString(6, wordInfo.getEtymology());
            ps.setInt(7, wordInfo.getWordID());
            int i = ps.executeUpdate();

            if(i == 1) {
                for (WordInfo word: words) {
                    if (word.getWordID().equals(wordInfo.getWordID())) {
                        words.remove(word);
                        words.add(wordInfo);
                    }
                }
                return wordInfo;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(int wordID) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM word_info WHERE word_id=" + wordID);
            words.removeIf(word -> word.getWordID().equals(wordID));

//            if(i == 1) {
//                return true;
//            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

//        return false;
    }
}
