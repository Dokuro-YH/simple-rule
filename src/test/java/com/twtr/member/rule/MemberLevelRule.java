package com.twtr.member.rule;

import com.twtr.member.domian.Member;
import com.twtr.rule.api.Rule;

/**
 * 会员等级规则
 * 
 * @author yanhai
 *
 */
public class MemberLevelRule extends Rule {

	private final int level;

	/**
	 * 会员等级规则
	 * 
	 * @param level 会员等级
	 */
	public MemberLevelRule( int level ) {
		super();
		this.level = level;
	}

	@Override
	public boolean apply( Object context ){
		return ((Member) context).getLevel() == this.level;
	}
}
