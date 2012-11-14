package client;

public class Filter {

	boolean exclusive;
    Rule rule;
    Field field;
    Action action;
    
    
    public void filter(IEmail e,IClient c){
	
	if(rule.satisfy(field.getCampo(e))){
		
		action.act(e,c);}
	}

}

	


