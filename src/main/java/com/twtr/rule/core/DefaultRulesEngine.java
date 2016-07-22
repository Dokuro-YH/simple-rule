package com.twtr.rule.core;

import java.util.ArrayList;
import java.util.List;

import com.twtr.rule.api.Rule;
import com.twtr.rule.api.RulesEngine;

/**
 * 规则引擎默认实现
 * 
 * @author yanhai
 *
 */
public class DefaultRulesEngine implements RulesEngine {

	private List<Rule> rules = new ArrayList<Rule>();

	@Override
	public void registerRule( Rule rule ){
		rules.add( rule );
	}

	@Override
	public void unregisterRule( Rule rule ){
		rules.remove( rule );
	}

	@Override
	public List<Rule> getRules(){
		return rules;
	}

	@Override
	public void run( Object context ){
		rules.forEach( rule -> rule.apply( context ) );
	}
}
