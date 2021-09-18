package arithmetics;

import org.junit.*;

public class StringParserTest {

    @Test
    public void parse1() {
        Assert.assertEquals(-5, new StringParser("5  - (8 + 12) / 2").eval());
    }

    @Test
    public void parse2() {
        Assert.assertEquals(-18, new StringParser("(1 + 3) / 2  - (3 + 7) * 2").eval());
    }

    @Test
    public void parse3() {
        Assert.assertEquals(2, new StringParser("((5 + 1) - 2) / 2").eval());
    }

}
