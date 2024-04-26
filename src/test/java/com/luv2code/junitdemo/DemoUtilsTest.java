package com.luv2code.junitdemo;

import com.luv2code.junitdemo.DemoUtils;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) Replaces underscores in test method name with spaces
//Simple //Removes trailing parentheses from test method name
//IndicativeSentences Generate sentence based on test class name and test method name
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
    }

    @Test
    @DisplayName("Equals and Not Equals")//Custom display name with spaces, special characters and emojis.Useful for test reports in IDE or external test runner
    void testEqualsAndNotEquals() {

        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
    @DisplayName("Null and Not Null")
    void testNullAndNotNull() {

        String str1 = null;
        String str2 = "luv2code";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");

    }

    @DisplayName("Same and Not Same")
    @Test
    void testSameAndNotSame() {

        String str = "luv2code";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to same object");//Assert that items refer to same object
        assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to same object");//Assert that items do not refer to same object
    }

    @DisplayName("True and False")
    @Test
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");//Assert that condition is true
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");//Assert that condition is false

    }
        @DisplayName("Array Equals")
                @Test
        void testArrayEquals(){
            String[] stringArray = {"A","B","C"};
            assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be equal");
          //  assertArrayEquals Assert that both object arrays are deeply equal
        }

        @DisplayName("Iterable equals")
    @Test
    void testIterableEquals(){
            List<String> theList = List.of("luv","2","code");//assertIterableEquals Assert that both object iterables are deeply equal
assertIterableEquals(theList, demoUtils.getAcademyInList(),"Expected list should be same as actual list");
//iterable is an instance of a class that implements the java.lang.Iterable interface Examples: ArrayList, LinkedList, HashSet, TreeSet
        }
    @DisplayName("Lines Match")
    @Test
    void testLinesMatch(){
        List<String> theList = List.of("luv","2","code");//assertIterableEquals Assert that both object iterables are deeply equal
        assertLinesMatch(theList, demoUtils.getAcademyInList(),"Lines should Match");
//iterable is an instance of a class that implements the java.lang.Iterable interface Examples: ArrayList, LinkedList, HashSet, TreeSe

    }

    /*
    @AfterEach
    void tearDownAfterEach() {
        System.out.println("Running @AfterEach");
        System.out.println();
    }

    @BeforeAll
    static void setupBeforeEachClass() {
        System.out.println("@BeforeAll executes only once before all test methods execution in the class");
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("@AfterAll executes only once after all test methods execution in the class");
    }
    */
}