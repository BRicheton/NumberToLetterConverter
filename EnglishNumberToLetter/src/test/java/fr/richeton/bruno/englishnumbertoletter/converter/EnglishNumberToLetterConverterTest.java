/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fr.richeton.bruno.englishnumbertoletter.converter;

import java.util.Map;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bruno RICHETON <bruno.richeton@free.fr>
 */
public class EnglishNumberToLetterConverterTest {

    private static final Map<Long, String> TWENTY_NUMBER = new TreeMap<>();

    public EnglishNumberToLetterConverterTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
        TWENTY_NUMBER.put(0L, "zero");
        TWENTY_NUMBER.put(1L, "one");
        TWENTY_NUMBER.put(2L, "two");
        TWENTY_NUMBER.put(3L, "three");
        TWENTY_NUMBER.put(4L, "four");
        TWENTY_NUMBER.put(5L, "five");
        TWENTY_NUMBER.put(6L, "six");
        TWENTY_NUMBER.put(7L, "seven");
        TWENTY_NUMBER.put(8L, "eight");
        TWENTY_NUMBER.put(9L, "nine");

        TWENTY_NUMBER.put(10L, "ten");
        TWENTY_NUMBER.put(11L, "eleven");
        TWENTY_NUMBER.put(12L, "twelve");
        TWENTY_NUMBER.put(13L, "thirteen");
        TWENTY_NUMBER.put(14L, "fourteen");
        TWENTY_NUMBER.put(15L, "fifteen");
        TWENTY_NUMBER.put(16L, "sixteen");
        TWENTY_NUMBER.put(17L, "seventeen");
        TWENTY_NUMBER.put(18L, "eighteen");
        TWENTY_NUMBER.put(19L, "nineteen");

    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test des nombres < 20
     */
    @org.junit.jupiter.api.Test
    public void testUnderTwenty() {
        EnglishNumberToLetterConverter instance = new EnglishNumberToLetterConverter();
        for (Map.Entry<Long, String> entry : TWENTY_NUMBER.entrySet()) {
            String result = instance.convertToLetters(entry.getKey());
            assertEquals(entry.getValue(), result);
        }

    }

    @org.junit.jupiter.api.Test
    public void testTwentyThousand() {
        EnglishNumberToLetterConverter instance = new EnglishNumberToLetterConverter();
        
        String result = instance.convertToLetters(20000L);
        assertEquals("twenty thousand", result);

    }
    
    @org.junit.jupiter.api.Test
    public void minusTestTwentyThousand() {
        EnglishNumberToLetterConverter instance = new EnglishNumberToLetterConverter();
        
        String result = instance.convertToLetters(-20000L);
        assertEquals("minus twenty thousand", result);

    }
    
    @org.junit.jupiter.api.Test
    public void testBig() {
        EnglishNumberToLetterConverter instance = new EnglishNumberToLetterConverter();
        
        String result = instance.convertToLetters(789789787545646L);
        assertEquals("seven hundred eighty-nine trillion seven hundred eighty-nine billion seven hundred eighty-seven million five hundred forty-five thousand six hundred forty-six", result);

    }
}
