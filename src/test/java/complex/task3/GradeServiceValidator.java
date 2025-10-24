package complex.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GradeServiceValidator {
    private GradeService gradeService;

    @BeforeEach
    void setUp(){
        gradeService = new GradeService();
    }

    @Test
    public void checkAddValidGrades(){
        StudentGrade st1 = new StudentGrade<>("Frodo", "math", Byte.MAX_VALUE);
        StudentGrade st2 = new StudentGrade<>("Holly", "math", Short.MAX_VALUE);
        StudentGrade st3 = new StudentGrade<>("Molly", "math", Integer.MAX_VALUE);
        StudentGrade st4 = new StudentGrade<>("Frodo", "biology", Long.MAX_VALUE);
        StudentGrade st5 = new StudentGrade<>("Holly", "biology", Float.MAX_VALUE);
        StudentGrade st6 = new StudentGrade<>("Molly", "biology", Double.MAX_VALUE);
        StudentGrade st7 = new StudentGrade<>("Kevin", "biology", 0);

        assertDoesNotThrow(() -> gradeService.addGrade(st1));
        assertDoesNotThrow(() -> gradeService.addGrade(st2));
        assertDoesNotThrow(() -> gradeService.addGrade(st3));
        assertDoesNotThrow(() -> gradeService.addGrade(st4));
        assertDoesNotThrow(() -> gradeService.addGrade(st5));
        assertDoesNotThrow(() -> gradeService.addGrade(st6));
        assertDoesNotThrow(() -> gradeService.addGrade(st7));

    }

    @Test
    public void checkNegativeGradeValidation(){
        StudentGrade st1 = new StudentGrade<>("Frodo", "math", -1);
        StudentGrade st2 = new StudentGrade<>("Frodo", "biology", null);

        InvalidGradeException ex1 = assertThrows(InvalidGradeException.class, () ->gradeService.addGrade(st1));
        assertEquals("Оценка не может быть отрицательной и null", ex1.getMessage());
        InvalidGradeException ex2 = assertThrows(InvalidGradeException.class, () ->gradeService.addGrade(st2));
        assertEquals("Оценка не может быть отрицательной и null", ex2.getMessage());
    }

    @Test
    public void councurrentAdditionWithNoException() throws InterruptedException{
        Thread t1 = new Thread(() ->{
            for(int i=0; i<500; i++){
                gradeService.addGrade(new StudentGrade<>("NameT1+"+i, "math", (double)i));
            }
        });
        Thread t2 = new Thread(() ->{
            for(int i=0; i<500; i++){
                gradeService.addGrade(new StudentGrade<>("NameT2+"+i, "math", (double)i));
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        assertEquals(1000, gradeService.getAll().size());
    }

    @Test
    public void calculateAverageCheck(){
        StudentGrade st1 = new StudentGrade<>("Frodo", "math", 1L);
        StudentGrade st2 = new StudentGrade<>("Holly", "math",0.1f);

        StudentGrade st4 = new StudentGrade<>("Frodo", "biology", 128);
        StudentGrade st5 = new StudentGrade<>("Frodo", "biology", 2);

        gradeService.addGrade(st1);
        gradeService.addGrade(st2);

        gradeService.addGrade(st4);
        gradeService.addGrade(st5);

        assertEquals(65.0, gradeService.calculateAverage("biology"));
        assertEquals(0.55, gradeService.calculateAverage("math"), 0.0001);

    }
}
