package com.dell.servlet;

public class ExcelBean {
	public ExcelBean(String sElementName, String sAttributeName, String sType, String sLength, String sMapping,
			String sNotes) {
		super();
		this.sElementName = sElementName;
		this.sAttributeName = sAttributeName;
		this.sType = sType;
		this.sLength = sLength;
		this.sMapping = sMapping;
		this.sNotes = sNotes;
	}
	private String sElementName;
    private String sAttributeName;
    private String sType;
    private String sLength;
    private String sMapping;
    private String sNotes;
	public String getsElementName() {
		return sElementName;
	}
	public void setsElementName(String sElementName) {
		this.sElementName = sElementName;
	}
	public String getsAttributeName() {
		return sAttributeName;
	}
	public void setsAttributeName(String sAttributeName) {
		this.sAttributeName = sAttributeName;
	}
	public String getsType() {
		return sType;
	}
	public void setsType(String sType) {
		this.sType = sType;
	}
	public String getsLength() {
		return sLength;
	}
	public void setsLength(String sLength) {
		this.sLength = sLength;
	}
	public String getsMapping() {
		return sMapping;
	}
	public void setsMapping(String sMapping) {
		this.sMapping = sMapping;
	}
	public String getsNotes() {
		return sNotes;
	}
	public void setsNotes(String sNotes) {
		this.sNotes = sNotes;
	}

    
}
