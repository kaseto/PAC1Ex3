package edu.uoc.pac1;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PAC1Ex3Test {

    private ByteArrayOutputStream outContent;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    private final int [][] classification = new int[][] {
            {14, 16, 44, 52},
            {11, 13, 46, 50},
            {15, 9,	48,	35},
            {10, 17, 32, 51},
            {15, 7,	51,	35},
            {8,	22,	41,	70},
            {17, 13, 62, 47},
            {14, 13, 48, 50},
            {11, 16, 59, 66},
            {7,	19,	43,	65},
            {21, 12, 63, 46},
            {13, 11, 41, 45},
            {13, 14, 45, 46},
            {13, 14, 39, 50},
            {11, 15, 37, 43},
            {26, 3,	90,	36},
            {10, 14, 49, 52},
            {10, 17, 53, 62},
            {9,	19,	37,	53},
            {22, 6,	55,	29}
    };


    @Test
    @Order(1)
    void testCompleteClasification() {


        int [][] classificationResult = new int[][] {
                {14, 8, 16, 44, 52, 50},
                {11, 14, 13, 46, 50, 47},
                {15, 14, 9,	48,	35, 59},
                {10, 11, 17, 32, 51, 41},
                {15, 16, 7,	51,	35, 61},
                {8,	8, 22,	41,	70, 32},
                {17, 8, 13, 62, 47, 59},
                {14, 11, 13, 48, 50, 53},
                {11, 11, 16, 59, 66, 44},
                {7,	12, 19,	43,	65, 33},
                {21, 5, 12, 63, 46, 68},
                {13, 14, 11, 41, 45, 53},
                {13, 11, 14, 45, 46, 50},
                {13, 11, 14, 39, 50, 50},
                {11, 12, 15, 37, 43, 45},
                {26, 9, 3,	90,	36, 87},
                {10, 14, 14, 49, 52, 44},
                {10, 11, 17, 53, 62, 41},
                {9,	10, 19,	37,	53, 37},
                {22, 10, 6,	55,	29, 76}
        };

        assertArrayEquals(classificationResult, PAC1Ex3.getCompleteClassification(classification));

    }

    @Test
    @Order(2)
    void testPrintError() {
        PAC1Ex3.print(classification);
        assertEquals("[ERROR] Classification table does not have the correct columns", outContent.toString().trim());
    }

    @Test
    @Order(3)
    void testPrint() {

        int [][] classificationComplete = new int[][] {
                {14, 8, 16, 44, 52, 50},
                {11, 14, 13, 46, 50, 47},
                {15, 14, 9,	48,	35, 59},
                {10, 11, 17, 32, 51, 41},
                {15, 16, 7,	51,	35, 61},
                {8,	8, 22,	41,	70, 32},
                {17, 8, 13, 62, 47, 59},
                {14, 11, 13, 48, 50, 53},
                {11, 11, 16, 59, 66, 44},
                {7,	12, 19,	43,	65, 33},
                {21, 5, 12, 63, 46, 68},
                {13, 14, 11, 41, 45, 53},
                {13, 11, 14, 45, 46, 50},
                {13, 11, 14, 39, 50, 50},
                {11, 12, 15, 37, 43, 45},
                {26, 9, 3,	90,	36, 87},
                {10, 14, 14, 49, 52, 44},
                {10, 11, 17, 53, 62, 41},
                {9,	10, 19,	37,	53, 37},
                {22, 10, 6,	55,	29, 76}
        };

        PAC1Ex3.print(classificationComplete);

        assertEquals(  "#   |  W  |  D  |  L  |  GF |  GA |  PTS|" +System.lineSeparator()+
                "1.  |  14 |  8  |  16 |  44 |  52 |  50 |" +System.lineSeparator()+
                "2.  |  11 |  14 |  13 |  46 |  50 |  47 |" +System.lineSeparator()+
                "3.  |  15 |  14 |  9  |  48 |  35 |  59 |" +System.lineSeparator()+
                "4.  |  10 |  11 |  17 |  32 |  51 |  41 |" +System.lineSeparator()+
                "5.  |  15 |  16 |  7  |  51 |  35 |  61 |" +System.lineSeparator()+
                "6.  |  8  |  8  |  22 |  41 |  70 |  32 |" +System.lineSeparator()+
                "7.  |  17 |  8  |  13 |  62 |  47 |  59 |" +System.lineSeparator()+
                "8.  |  14 |  11 |  13 |  48 |  50 |  53 |" +System.lineSeparator()+
                "9.  |  11 |  11 |  16 |  59 |  66 |  44 |" +System.lineSeparator()+
                "10. |  7  |  12 |  19 |  43 |  65 |  33 |" +System.lineSeparator()+
                "11. |  21 |  5  |  12 |  63 |  46 |  68 |" +System.lineSeparator()+
                "12. |  13 |  14 |  11 |  41 |  45 |  53 |" +System.lineSeparator()+
                "13. |  13 |  11 |  14 |  45 |  46 |  50 |" +System.lineSeparator()+
                "14. |  13 |  11 |  14 |  39 |  50 |  50 |" +System.lineSeparator()+
                "15. |  11 |  12 |  15 |  37 |  43 |  45 |" +System.lineSeparator()+
                "16. |  26 |  9  |  3  |  90 |  36 |  87 |" +System.lineSeparator()+
                "17. |  10 |  14 |  14 |  49 |  52 |  44 |" +System.lineSeparator()+
                "18. |  10 |  11 |  17 |  53 |  62 |  41 |" +System.lineSeparator()+
                "19. |  9  |  10 |  19 |  37 |  53 |  37 |" +System.lineSeparator()+
                "20. |  22 |  10 |  6  |  55 |  29 |  76 |", outContent.toString().trim());


    }


    @Test
    @Order(4)
    void testDifferenceGoalsError() {
        assertEquals(-1, PAC1Ex3.getNumTeamsByGoalDifference(classification, true));
        assertEquals("[ERROR] Classification table does not have the correct columns", outContent.toString().trim());
    }

    @Test
    @Order(5)
    void testDifferenceGoals() {

        int[][] classificationComplete = new int[][]{
                {14, 8, 16, 44, 52, 50},
                {11, 14, 13, 46, 50, 47},
                {15, 14, 9, 48, 35, 59},
                {10, 11, 17, 32, 51, 41},
                {15, 16, 7, 51, 35, 61},
                {8, 8, 22, 41, 70, 32},
                {17, 8, 13, 62, 47, 59},
                {14, 11, 13, 48, 50, 53},
                {11, 11, 16, 59, 66, 44},
                {7, 12, 19, 43, 65, 33},
                {21, 5, 12, 63, 46, 68},
                {13, 14, 11, 41, 45, 53},
                {13, 11, 14, 45, 46, 50},
                {13, 11, 14, 39, 50, 50},
                {11, 12, 15, 37, 43, 45},
                {26, 9, 3, 90, 36, 87},
                {10, 14, 14, 49, 52, 44},
                {10, 11, 17, 53, 62, 41},
                {9, 10, 19, 37, 53, 37},
                {22, 10, 6, 55, 29, 76}
        };

        assertEquals(6, PAC1Ex3.getNumTeamsByGoalDifference(classificationComplete, true));
        assertEquals(14, PAC1Ex3.getNumTeamsByGoalDifference(classificationComplete, false));
    }

    @Test
    @Order(6)
    void testSortError() {
        PAC1Ex3.sort(classification);
        assertEquals("[ERROR] Classification table does not have the correct columns", outContent.toString().trim());
    }

    @Test
    @Order(7)
    void testSort() {

        int[][] classificationComplete = new int[][]{
                {14, 8, 16, 44, 52, 50},
                {11, 14, 13, 46, 50, 47},
                {15, 14, 9, 48, 35, 59},
                {10, 11, 17, 32, 51, 41},
                {15, 16, 7, 51, 35, 61},
                {8, 8, 22, 41, 70, 32},
                {17, 8, 13, 62, 47, 59},
                {14, 11, 13, 48, 50, 53},
                {11, 11, 16, 59, 66, 44},
                {7, 12, 19, 43, 65, 33},
                {21, 5, 12, 63, 46, 68},
                {13, 14, 11, 41, 45, 53},
                {13, 11, 14, 45, 46, 50},
                {13, 11, 14, 39, 50, 50},
                {11, 12, 15, 37, 43, 45},
                {26, 9, 3, 90, 36, 87},
                {10, 14, 14, 49, 52, 44},
                {10, 11, 17, 53, 62, 41},
                {9, 10, 19, 37, 53, 37},
                {22, 10, 6, 55, 29, 76}
        };

        int [][] classificationResult = new int[][] {
                {26, 9, 3,	90,	36, 87},
                {22, 10, 6,	55,	29, 76},
                {21, 5, 12, 63, 46, 68},
                {15, 16, 7,	51,	35, 61},
                {17, 8, 13, 62, 47, 59},
                {15, 14, 9,	48,	35, 59},
                {14, 11, 13, 48, 50, 53},
                {13, 14, 11, 41, 45, 53},
                {13, 11, 14, 45, 46, 50},
                {14, 8, 16, 44, 52, 50},
                {13, 11, 14, 39, 50, 50},
                {11, 14, 13, 46, 50, 47},
                {11, 12, 15, 37, 43, 45},
                {11, 11, 16, 59, 66, 44},
                {10, 14, 14, 49, 52, 44},
                {10, 11, 17, 53, 62, 41},
                {10, 11, 17, 32, 51, 41},
                {9,	10, 19,	37,	53, 37},
                {7,	12, 19,	43,	65, 33},
                {8,	8, 22,	41,	70, 32},
        };

        PAC1Ex3.sort(classificationComplete);
        assertArrayEquals(classificationResult, classificationComplete);

    }
}