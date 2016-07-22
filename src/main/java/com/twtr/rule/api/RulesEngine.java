package com.twtr.rule.api;

import java.util.Collection;

/**
 * 规则引擎
 * 
 * @author yanhai
 *
 */
public interface RulesEngine {

	void registerRule( Rule rule );

	void unregisterRule( Rule rule );

	Collection<Rule> getRules();

	void run( Object context );
}
