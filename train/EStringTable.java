package train;

public enum EStringTable {

	COLUMN_L("("),
	COLUMN_R(")"),
	COMMA(","),
	ARROW("->"),
	WHITESPACE(" ");
	
	private final String _constant;
	private EStringTable(String constant) {
		this._constant = constant;
	}
	
	@Override
	public String toString() {
		return this._constant;
	}
}