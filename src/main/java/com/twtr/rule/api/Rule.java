package com.twtr.rule.api;

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
		Rule[] rs = new Rule[rules.length + 1];
		rs[0] = this;
		for (int i = 0; i < rules.length; i++) {
			rs[i + 1] = rules[i];
		}
		return new AnyRule( rs );
	}

	public Rule and( Rule... rules ){
		Rule[] rs = new Rule[rules.length + 1];
		rs[0] = this;
		for (int i = 0; i < rules.length; i++) {
			rs[i + 1] = rules[i];
		}
		return new AndRule( rs );
	}

	public Rule or( Rule rule ){
		return new AnyRule( this, rule );
	}

	public Rule not(){
		return new NotRule( this );
	}
}
