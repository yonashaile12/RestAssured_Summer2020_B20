import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class HelloTest {

    @Test
    public void test(){
        Assertions.assertEquals(4, 3+1);
    }

    @Test
    public void test2(){
        // assert 4 time 3 is 12
        assertEquals(12, 3*4);
    }
}
