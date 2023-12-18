package daos;

import models.WordInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordInfoDAOTest {

    WordInfoDAO wid = new WordInfoDAO();

    @After
    public void tearDown(){
        wid.delete(6);
    }

    @Test
    public void findByIdTest(){
        String actual = wid.findById(1).getWord();
        String expected = "Serendipity";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAllTest(){
        List<WordInfo> words = wid.findAll();
        List<String> actual = new ArrayList<>();
        for (WordInfo word: words) {
            actual.add(word.getWord());
        }
        List<String> expected = Arrays.asList("Serendipity", "Amistad", "Gelato", "Sakura", "Gemütlichkeit");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createTest(){
        WordInfo dog = new WordInfo(6, 1, "Dog", "Man's best friend", "I got dat dog in me.", "dawg", "Da dawg house");
        wid.create(dog);

        Assert.assertTrue(wid.findAll().contains(dog));
    }

    @Test
    public void updateTest(){
        WordInfo dog = new WordInfo(6, 1, "Dog", "Man's best friend", "I got dat dog in me.", "dawg", "Da dawg house");
        wid.create(dog);
        WordInfo doggy = new WordInfo(6, 1, "Doggy", "Man's best friend", "I got dat dog in me.", "dawg", "Da dawg house");
        wid.update(doggy);

        Assert.assertEquals("Doggy" ,wid.findById(6).getWord());
    }

    @Test
    public void deleteTest(){
        WordInfo dog = new WordInfo(6, 1, "Dog", "Man's best friend", "I got dat dog in me.", "dawg", "Da dawg house");
        wid.create(dog);
        wid.delete(6);

        Assert.assertEquals(5, wid.findAll().size());
    }
}
