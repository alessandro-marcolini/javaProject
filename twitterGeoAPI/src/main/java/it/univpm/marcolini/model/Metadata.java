package it.univpm.marcolini.model;

public class Metadata {
	
	protected String alias;
	protected String sourceField;
	protected String type;
	
	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the sourceField
	 */
	public String getsourceField() {
		return sourceField;
	}

	/**
	 * @param sourceField the sourceField to set
	 */
	public void setsourceField(String sourceField) {
		this.sourceField = sourceField;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public Metadata(String alias, String sourceField, String type) {
		this.alias = alias;
		this.sourceField = sourceField;
		this.type = type;
	}
	
}
