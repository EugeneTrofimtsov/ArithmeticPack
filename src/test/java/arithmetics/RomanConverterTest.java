package arithmetics;

import org.junit.*;

import static arithmetics.RomanConverter.convertRomanToArabicNumber;

public class RomanConverterTest {

    @Test
    public void convertI() {
        Assert.assertEquals(1, convertRomanToArabicNumber("I"));
    }

    @Test
    public void convertII() {
        Assert.assertEquals(2, convertRomanToArabicNumber("II"));
    }

    @Test
    public void convertIII() {
        Assert.assertEquals(3, convertRomanToArabicNumber("III"));
    }

    @Test
    public void convertV() {
        Assert.assertEquals(5, convertRomanToArabicNumber("V"));
    }

    @Test
    public void convertVI() {
        Assert.assertEquals(6, convertRomanToArabicNumber("VI"));
    }

    @Test
    public void convertIV() {
        Assert.assertEquals(4, convertRomanToArabicNumber("IV"));
    }

    @Test
    public void convertX() {
        Assert.assertEquals(10, convertRomanToArabicNumber("X"));
    }

    @Test
    public void convertIX() {
        Assert.assertEquals(9, convertRomanToArabicNumber("IX"));
    }

    @Test
    public void convertXXXVI() {
        Assert.assertEquals(36, convertRomanToArabicNumber("XXXVI"));
    }

    @Test
    public void convertMMXII() {
        Assert.assertEquals(2012, convertRomanToArabicNumber("MMXII"));
    }

    @Test
    public void convertMCMXCVI() {
        Assert.assertEquals(1996, convertRomanToArabicNumber("MCMXCVI"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertInvalidRomanValue() {
        convertRomanToArabicNumber("Z");
    }

    @Test
    public void convertVII() {
        Assert.assertEquals(7, convertRomanToArabicNumber("vii"));
    }
}
