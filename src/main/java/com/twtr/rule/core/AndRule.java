package com.twtr.rule.core;

import java.util.Arrays;
import java.util.List;

import com.twtr.rule.api.Rule;

/**
 * 逻辑与规则
 * 
 * @author yanhai
 *
 */
public class AndRule extends Rule {

	private final List<Rule> rules;

	public AndRule( Rule... rules ) {
		super();
		this.rules = Arrays.asList( rules );
	}

	@Override
	public boolean apply( Object context ){
		for (Rule rule : rules) {
			if (!rule.apply( context )) {
				return false;
			}
		}
		return true;
	}
}
