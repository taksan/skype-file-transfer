package org.github.taksan.x11;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class XDoToolTest {
	@Test
	public void onQuoteToType_ShouldSlashQuotes()
	{
		String actual = XDoTool.quoteToType("\"foo\"");
		assertEquals("\\\"foo\\\"", actual);
	}
}