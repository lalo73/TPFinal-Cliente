package client;

import interfaces.IEmail;

public abstract class Rule {

	Field f;
	
	public Field getF() {
		return f;
	}

	public void setF(Field f) {
		this.f = f;
	}

	public abstract boolean satisfy(IEmail e);

	public Rule(String s,Field f){
		this.setString(s);
		this.setF(f);
	}
}
