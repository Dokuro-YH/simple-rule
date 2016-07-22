package com.twtr.rule.core;

import java.util.Arrays;
import java.util.List;

import com.twtr.rule.api.Rule;

/**
 * 排它规则
 * 
 * @author yanhai
 *
 */
public class AnyRule extends Rule {

	private final List<Rule> rules;

	public AnyRule( Rule... rules ) {
		super();
		this.rules = Arrays.asList( rules );
	}

	@Override
	public boolean apply( Object context ){
		for (Rule rule : rules) {
			if (rule.apply( context )) {
				return true;
			}
		}
		return false;
	}
}
