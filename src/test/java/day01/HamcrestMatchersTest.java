package day01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @DisplayName("Test 1 + 3 = 4")
    @Test
    public void test1(){
        assertThat(1+3,equalTo(4));
    }
}
