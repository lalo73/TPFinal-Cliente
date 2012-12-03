package filter;

import interfaces.IClient;
import interfaces.IEmail;

public class Filter {

	Rule rule;
	Action action;

	

	public boolean filter(IEmail e, IClient c) throws Exception {

		boolean movedFromfolder = false;

		if (this.getRule().satisfy(e)) {

			movedFromfolder = movedFromfolder || this.getAction().act(e, c);
		}
		return movedFromfolder;
	}

	
	//Getters y Setters.
	public boolean getExclusive() {

		return this.getAction().exclusive();

	}

	public void setExclusive(boolean bool) throws Exception {
		this.getAction().setExclusive(bool);

	}
	
	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	
	//Constructor de filtro.
	public Filter(Rule r, Action a) {

		this.setRule(r);
		this.setAction(a);
	}

}
