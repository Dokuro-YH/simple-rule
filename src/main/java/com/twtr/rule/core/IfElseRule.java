package com.twtr.rule.core;

import com.twtr.rule.api.Rule;

/**
 * IfElse 规则
 * @author yanhai
 *
 */
public class IfElseRule extends Rule {

	private final Rule con;

	private final Rule if_rule;

	private final Rule else_rule;

	public IfElseRule( Rule con, Rule if_rule, Rule else_rule ) {
		super();
		this.con = con;
		this.if_rule = if_rule;
		this.else_rule = else_rule;
	}

	@Override
	public boolean apply( Object context ){
		if (con.apply( context ) && if_rule != null) {
			return if_rule.apply( context );
		} else if (else_rule != null) {
			return else_rule.apply( context );
		} else {
			return false;
		}
	}
}
