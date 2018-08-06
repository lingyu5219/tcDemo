package com.center.editor;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class LongEditor extends PropertiesEditor {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(text==null||"".equals(text)){
			text = "0";
		}
		setValue(Long.parseLong(text));
	}
	@Override
	public String getAsText() {
		return getValue().toString();
	}
}
