package filter;

import interfaces.IEmail;

public abstract class Rule {

	Field f;
	
	//Metodo implementado por:Countain,Different y Equal.
	public abstract boolean satisfy(IEmail e);
	
	//Getters y Setters.
	public Field getF() {
		return f;
	}

	public void setF(Field f) {
		this.f = f;
	}
}
