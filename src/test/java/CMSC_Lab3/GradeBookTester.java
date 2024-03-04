package CMSC_Lab3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GradeBookTester {

    GradeBook gb1;
    GradeBook gb2;

    @BeforeEach
    void setUp() {
        gb1 = new GradeBook(5);
        gb1.addScore(10);
        gb1.addScore(13);
        gb1.addScore(12);
        gb2 = new GradeBook(5);
        gb2.addScore(11);
        gb2.addScore(14);
        gb2.addScore(14);
        gb2.addScore(15);
    }

    @AfterEach
    void tearDown() {
        gb1 = null;
        gb2 = null;
    }

    @Test
    void addScore() {
        assertTrue(gb1.toString().equals("10.0 13.0 12.0 0.0 0.0"));
        assertEquals(gb1.getScoreSize(),3);
    }

    @Test
    void sum() {
        assertEquals(gb1.sum(), 35);
    }

    @Test
    void minimum() {
        assertEquals(gb1.minimum(), 10);
    }

    @Test
    void finalScore() {
        assertEquals(gb1.finalScore(), 25);
    }

    @Test
    void getScoreSize() {
    }

    @Test
    void testToString() {
    }
}