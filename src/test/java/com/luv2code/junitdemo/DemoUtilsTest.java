package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) Replaces underscores in test method name with spaces
//Simple - Removes trailing parentheses from test method name
//IndicativeSentences- Generate sentence based on test class name and test method name
//@TestMethodOrder(MethodOrderer.DisplayName.class)// When you want tests to appear in alphabetical order for reporting purposes.
// Sharing reports with project management, QA team etc...Group tests based on functionality or requirements
//If no display names for methods then MethodOrderer.MethodName.class
//If you have multiple test classes, you can order the classes Define custom order implementation
//Configure default order in properties file
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
    }


    @Test
    @DisplayName("Equals and Not Equals")
    @Order(1)
//Custom display name with spaces, special characters and emojis.Useful for test reports in IDE or external test runner
    void testEqualsAndNotEquals() {

        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
    @DisplayName("Null and Not Null")
    @Order(0)// lowest number is listed first
    void testNullAndNotNull() {

        String str1 = null;
        String str2 = "luv2code";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");

    }

    @DisplayName("Same and Not Same")
    @Test
    @Order(7)//  Negative numbers are allowed, this  is listed first
    void testSameAndNotSame() {

        String str = "luv2code";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to same object");//Assert that items refer to same object
        assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to same object");//Assert that items do not refer to same object
    }

    @DisplayName("True and False")
    @Test
    @Order(30)
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");//Assert that condition is true
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");//Assert that condition is false

    }

    @DisplayName("Array Equals")
    @Test
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};
        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be equal");
        //  assertArrayEquals Assert that both object arrays are deeply equal,The method compares the contents of the arrays element by element.
        //  If the arrays are not equal, it throws an assertion error, indicating the index at which the arrays first differ.
//    Eg 2        int[] expected = {1, 2, 3};
//            int[] actual = {1, 3, 2};
    }

    @DisplayName("Iterable equals")
    @Test
    void testIterableEquals() {
        List<String> theList = List.of("luv", "2", "code");//assertIterableEquals Assert that both object iterables are deeply equal
        assertIterableEquals(theList, demoUtils.getAcademyInList(), "Expected list should be same as actual list");
//iterable is an instance of a class that implements the java.lang.Iterable interface Examples: ArrayList, LinkedList, HashSet, TreeSet
//    Eg 2        List<Integer> expected = Arrays.asList(1, 2, 3);
//            List<Integer> actual = Arrays.asList(1, 2, 3);
//            assertIterableEquals(expected, actual);
    }

    @DisplayName("Lines Match")
    @Test
    void testLinesMatch() {
        List<String> theList = List.of("luv", "2", "code");//assertLinesMatch is specifically tailored for comparing sequences of strings line by line,
        // with support for pattern matching.
        assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should Match");
        //   It is useful when verifying the output of methods that return multiline strings, such as log files or text documents.
    }


    @DisplayName("Throws and does not Throw")
    @Test
    void testThrowsAndDoesNotThrow() {

        assertThrows(Exception.class, () -> {
            demoUtils.throwException(-1);
        }, "Should throw exception");
//In this case, Exception.class indicates that the assertion expects any type of exception that is a subclass of the Exception class to be thrown.
//If any other type of exception is thrown during the execution of the lambda expression, the assertion will fail.
//The syntax () -> { ... } denotes an anonymous function (lambda expression) with no parameters. The code inside the curly braces { ... }
// represents the body of the lambda expression.

        assertDoesNotThrow(() -> {
            demoUtils.throwException(9);
        }, "Should not throw exception");
        //there's no need to provide Exception.class as a parameter to assertDoesNotThrow because the assertion is focused on ensuring
        // that no exception occurs, rather than expecting a specific type of exception.
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