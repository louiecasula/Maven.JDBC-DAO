package daos;

import models.WordInfo;

import java.util.Set;

public interface WordInfoDAO {
    WordInfo getWordInfo();
    Set<WordInfo> getAllWordInfo();
    WordInfo getWordInfoByWordID();
    boolean insertWordInfo();
    boolean updateWordInfo();
    boolean deleteWordInfo();
}
