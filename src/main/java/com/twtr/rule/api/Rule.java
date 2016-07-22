package com.twtr.rule.api;

import java.util.Arrays;
import java.util.List;

import com.twtr.rule.core.AndRule;
import com.twtr.rule.core.AnyRule;
import com.twtr.rule.core.IfElseRule;
import com.twtr.rule.core.NotRule;

/**
 * 规则
 * 
 * @author yanhai
 *
 */
public abstract class Rule {

	abstract public boolean apply( Object context );

	public Rule then( Rule rule ){
		return new AndRule( this, rule );
	}

	public Rule ifelse( Rule if_rule, Rule else_rule ){
		return new IfElseRule( this, if_rule, else_rule );
	}

	public Rule any( Rule... rules ){
		List<Rule> rule_list = Arrays.asList( rules );
		rule_list.add( 0, this );
		return new AnyRule( rule_list );
	}

	public Rule and( Rule... rules ){
		List<Rule> rule_list = Arrays.asList( rules );
		rule_list.add( 0, this );
		return new AndRule( rule_list );
	}

	public Rule or( Rule rule ){
		return new AnyRule( this, rule );
	}

	public Rule not(){
		return new NotRule( this );
	}
}
