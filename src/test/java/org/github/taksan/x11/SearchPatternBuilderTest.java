package org.github.taksan.x11;

import org.junit.Assert;
import org.junit.Test;

public class SearchPatternBuilderTest {
	@Test
	public void onBuild_ShouldReturnSearchPattern(){
		SearchPatternBuilder subject = new SearchPatternBuilder("foo","bar");
		String actual = subject.build();
		String expected = "search --onlyvisible foo search --onlyvisible bar";
		Assert.assertEquals(expected, actual);
	}
}
