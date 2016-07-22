package com.twtr.rule.util;

import com.twtr.rule.api.Rule;
import com.twtr.rule.core.AndRule;
import com.twtr.rule.core.AnyRule;
import com.twtr.rule.core.NotRule;

/**
 * 规则工具类
 * @author yanhai
 *
 */
public abstract class Rules {

	/**
	 * 逻辑与
	 * @param rules
	 * @return
	 */
	public static Rule and( Rule... rules ){
		return new AndRule( rules );
	}

	/**
	 * 逻辑非
	 * @param rule
	 * @return
	 */
	public static Rule not( Rule rule ){
		return new NotRule( rule );
	}

	/**
	 * 排它
	 * @param rules
	 * @return
	 */
	public static Rule any( Rule... rules ){
		return new AnyRule( rules );
	}

	/**
	 * 逻辑或
	 * @param rule1
	 * @param rule2
	 * @return
	 */
	public static Rule or(Rule rule1,Rule rule2){
		return new AnyRule(rule1,rule2);
	}
}
