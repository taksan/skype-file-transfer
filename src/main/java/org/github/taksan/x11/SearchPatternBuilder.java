package org.github.taksan.x11;

class SearchPatternBuilder {
	private final String[] patterns;

	public SearchPatternBuilder(String... patterns) {
		this.patterns = patterns;
	}

	public String build() {
		StringBuffer sb = new StringBuffer();
		for (String aPattern : patterns) {
			sb.append("search --onlyvisible "+ aPattern + " ");
		}
		return sb.toString().trim();
	} 
	
}