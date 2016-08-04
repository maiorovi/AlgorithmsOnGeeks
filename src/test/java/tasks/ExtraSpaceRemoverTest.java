package tasks;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExtraSpaceRemoverTest {
    private ExtraSpaceRemover extraSpaceRemover;

    @Before
    public void setUp() {
        extraSpaceRemover = new ExtraSpaceRemover();
    }

    @Test
    public void onEmptyStringInputShouldReturnEmptyString() {
        assertThat(extraSpaceRemover.remove("")).isEmpty();
    }

    @Test
    public void removesPrependedWhiteSpaces() throws Exception {
        String input = "      abc";
        assertThat(extraSpaceRemover.remove(input)).isEqualTo(input.trim());
    }

    @Test
    public void removesAppendedWhiteSpaces() throws Exception {
        String input = "abc     ";
        assertThat(extraSpaceRemover.remove(input)).isEqualTo(input.trim());
    }

    @Test
    public void removesExcessiveWhiteSpacesInsideString() {
        String input = "   Hello      Geeks   ";
        String output = "Hello Geeks";

        assertThat(extraSpaceRemover.remove(input)).isEqualTo(output);
    }

    @Test
    public void processDotsInString() throws Exception {
        String input = "   Hello Geeks . Welcome   to  GeeksforGeeks   .    ";
        String output = "Hello Geeks. Welcome to GeeksforGeeks.";

        assertThat(extraSpaceRemover.remove(input)).isEqualTo(output);
    }

    @Test
    public void stringsWithOutWhitespacesIsReturnedUnChanged() throws Exception {
        String input = "GeeksforGeeks";
        assertThat(extraSpaceRemover.remove(input)).isEqualTo(input);
    }

    @Test
    public void holdCorrectlyStringWhichContainsOnlyWhiteSpaces() throws Exception {
        String input = "        ";
        assertThat(extraSpaceRemover.remove(input)).isEqualTo("");
    }
}
