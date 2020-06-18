package it.univpm.marcolini.model;

/**
 * Class that represent metadata
 * @author Alessandro Marcolini
 * @version 1.0
 */
public class Metadata {
	/**
	 * the alias
	 */
	private String alias;
	
	/**
	 * the original name of the field
	 */
	private String sourceField;
	
	/**
	 * the type of the object 
	 */
	private String type;
	
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

	/**
	 * Constructor
	 * @param alias
	 * @param sourceField
	 * @param type
	 */
	public Metadata(String alias, String sourceField, String type) {
		this.alias = alias;
		this.sourceField = sourceField;
		this.type = type;
	}
	
}
