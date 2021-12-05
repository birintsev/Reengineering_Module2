package birintsev;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class ShoppingCartTest {

    private static final String EVEN_LENGTH_STRING = "TestString";

    private static final String ODD_LENGTH_STRING = "Test_String";

    @Test
    public void appendFormatted_evenString_widthEquals_beginFormatting() {
        assertAppendFormattedEqualsExpected(
            EVEN_LENGTH_STRING,
            -1,
            10,
            "TestString "
        );
    }

    @Test
    public void appendFormatted_evenString_widthGreaterThan_beginFormatting() {
        assertAppendFormattedEqualsExpected(
            EVEN_LENGTH_STRING,
            -1,
            12,
            "TestString   "
        );
    }

    @Test
    public void appendFormatted_evenString_widthLessThan_beginFormatting() {
        assertAppendFormattedEqualsExpected(
            EVEN_LENGTH_STRING,
            -1,
            9,
            "TestStrin "
        );
    }

    @Test
    public void appendFormatted_evenString_widthEquals_midFormatting() {
        assertAppendFormattedEqualsExpected(
            EVEN_LENGTH_STRING,
            0,
            10,
            "TestString "
        );
    }

    @Test
    public void appendFormatted_evenString_widthGreaterThan_midFormatting() {
        assertAppendFormattedEqualsExpected(
            EVEN_LENGTH_STRING,
            0,
            12,
            " TestString  "
        );
    }

    @Test
    public void appendFormatted_evenString_widthLessThan_midFormatting() {
        assertAppendFormattedEqualsExpected(
            EVEN_LENGTH_STRING,
            0,
            1,
            "T "
        );
    }

    @Test
    public void appendFormatted_evenString_widthEquals_endFormatting() {
        assertAppendFormattedEqualsExpected(
            EVEN_LENGTH_STRING,
            1,
            10,
            "TestString "
        );
    }

    @Test
    public void appendFormatted_evenString_widthGreaterThan_endFormatting() {
        assertAppendFormattedEqualsExpected(
            EVEN_LENGTH_STRING,
            1,
            12,
            "  TestString "
        );
    }

    @Test
    public void appendFormatted_evenString_widthLessThan_endFormatting() {
        assertAppendFormattedEqualsExpected(
            EVEN_LENGTH_STRING,
            -1,
            1,
            "T "
        );
    }

    @Test
    public void appendFormatted_oddString_widthEquals_beginFormatting() {
        assertAppendFormattedEqualsExpected(
            ODD_LENGTH_STRING,
            -1,
            11,
            "Test_String "
        );
    }

    @Test
    public void appendFormatted_oddString_widthGreaterThan_beginFormatting() {
        assertAppendFormattedEqualsExpected(
            ODD_LENGTH_STRING,
            -1,
            12,
            "Test_String  "
        );
    }

    @Test
    public void appendFormatted_oddString_widthLessThan_beginFormatting() {
        assertAppendFormattedEqualsExpected(
            ODD_LENGTH_STRING,
            -1,
            9,
            "Test_Stri "
        );
    }

    @Test
    public void appendFormatted_oddString_widthEquals_midFormatting() {
        assertAppendFormattedEqualsExpected(
            ODD_LENGTH_STRING,
            0,
            11,
            "Test_String "
        );
    }

    @Test
    public void appendFormatted_oddString_widthGreaterThan_midFormatting() {
        assertAppendFormattedEqualsExpected(
            ODD_LENGTH_STRING,
            0,
            12,
            "Test_String  "
        );
    }

    @Test
    public void appendFormatted_oddString_widthLessThan_midFormatting() {
        assertAppendFormattedEqualsExpected(
            ODD_LENGTH_STRING,
            0,
            1,
            "T "
        );
    }

    @Test
    public void appendFormatted_oddString_widthEquals_endFormatting() {
        assertAppendFormattedEqualsExpected(
            ODD_LENGTH_STRING,
            1,
            11,
            "Test_String "
        );
    }

    @Test
    public void appendFormatted_oddString_widthGreaterThan_endFormatting() {
        assertAppendFormattedEqualsExpected(
            ODD_LENGTH_STRING,
            1,
            12,
            " Test_String "
        );
    }

    @Test
    public void appendFormatted_oddString_widthLessThan_endFormatting() {
        assertAppendFormattedEqualsExpected(
            ODD_LENGTH_STRING,
            -1,
            1,
            "T "
        );
    }

    private void assertAppendFormattedEqualsExpected(
        StringBuilder stringBuilder,
        String value,
        int align,
        int width,
        String expected
    ) {
        ShoppingCart.appendFormatted(stringBuilder, value, align, width);
        assertEquals(expected, stringBuilder.toString());
    }

    // With empty StringBuilder
    private void assertAppendFormattedEqualsExpected(
        String value,
        int align,
        int width,
        String expected
    ) {
        assertAppendFormattedEqualsExpected(
            new StringBuilder(),
            value,
            align,
            width,
            expected
        );
    }
}
