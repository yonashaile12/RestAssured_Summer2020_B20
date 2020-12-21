import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class HelloTest {
        /*
            static method @BeforeAll is running
            @BeforeEach is running
            Test1 is running
            @AfterEach is running
            @BeforeEach is running
            Test2 is running
            @AfterEach is running
            static method AfterAll is running
         */

    @BeforeAll
    public static void setUp(){
        System.out.println("@BeforeAll is running");
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("AfterAll is running");
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("@BeforeEach is running");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("@AfterEach is running");
    }
    @Test
    public void test(){
        Assertions.assertEquals(4, 3+1);
        System.out.println("Test1 is running");
    }

    @Test
    public void test2(){
        // assert 4 time 3 is 12
        assertEquals(12, 3*4);
        System.out.println("Test2 is running");
    }
}
