package client;

import exceptions.NoLoggedUserException;

public class Filter {

	boolean exclusive;
	Rule rule;
	Action action;

	public void filter(IEmail e, IClient c) throws NoLoggedUserException {

		if (rule.satisfy(e)) {

			action.act(e, c);
		}
	}

	public boolean isExclusive() {
		return exclusive;
	}

	public void setExclusive(boolean exclusive) {
		this.exclusive = exclusive;
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

	public Filter(boolean exc, Rule r, Action a) {
		this.setExclusive(exc);
		this.setRule(r);
		this.setAction(a);
	}

}
