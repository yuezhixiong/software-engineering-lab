

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestParseTimeToSeconds {
	@Test
	public void testStatement() {
		assertEquals(48225, TimeParser.parseTimeToSeconds("1:23:45 pm"));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testBranch() {
		thrown.expect(NumberFormatException.class);
		thrown.expectMessage("Unrecognized time format");
		assertEquals(5025, TimeParser.parseTimeToSeconds("12345 am"));
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unacceptable time specified");
		assertEquals(5025, TimeParser.parseTimeToSeconds("1:23:99 am"));
	}

	@Test
	public void testPath() {
		thrown.expect(NumberFormatException.class);
		thrown.expectMessage("Unrecognized time format");
		assertEquals(5025, TimeParser.parseTimeToSeconds("12345 pm"));
		thrown.expect(NumberFormatException.class);
		thrown.expectMessage("Unrecognized time format");
		assertEquals(5025, TimeParser.parseTimeToSeconds("1:2345 pm"));
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unacceptable time specified");
		assertEquals(5025, TimeParser.parseTimeToSeconds("1:23:99 pm"));
	}
}
