package com.twtr.rule.core;

import com.twtr.rule.api.Rule;

/**
 * 逻辑非规则
 * 
 * @author yanhai
 *
 */
public class NotRule extends Rule {

	private final Rule rule;

	public NotRule( Rule rule ) {
		super();
		this.rule = rule;
	}

	@Override
	public boolean apply( Object context ){
		return !rule.apply( context );
	}
}
