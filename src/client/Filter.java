package client;

public class Filter {

	boolean exclusive;
    Rule rule;
    Action action;
    
    
    public void filter(IEmail e,IClient c){
	
	if(rule.satisfy()){
		
		action.act(e,c);}
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


public Field getField() {
	return field;
}


public void setField(Field field) {
	this.field = field;
}


public Action getAction() {
	return action;
}


public void setAction(Action action) {
	this.action = action;
}

    

public Filter(boolean exc,Rule r,Field f,Action a){
	this.setExclusive(exc);
	this.setRule(r);
	this.setField(f);
	this.setAction(a);
}

}

	


