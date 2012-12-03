package filter;

import interfaces.IClient;
import interfaces.IEmail;

public class Filter {

	Rule rule;
	Action action;

	public boolean getExclusive() {

		return this.getAction().exclusive();

	}

	public void setExclusive(boolean bool) throws Exception {
		this.getAction().setExclusive(bool);

	}

	public boolean filter(IEmail e, IClient c) throws Exception {

		boolean movedFromfolder = false;

		if (rule.satisfy(e)) {

			movedFromfolder = movedFromfolder || action.act(e, c);
		}
		return movedFromfolder;
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

	public Filter(Rule r, Action a) {

		this.setRule(r);
		this.setAction(a);
	}

}
