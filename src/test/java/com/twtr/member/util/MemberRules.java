package com.twtr.member.util;

import com.twtr.member.rule.MemberBirthdayDiscountRule;
import com.twtr.member.rule.MemberDiscountRule;
import com.twtr.member.rule.MemberLevelRule;
import com.twtr.rule.api.Rule;
import com.twtr.rule.util.Rules;

public abstract class MemberRules extends Rules {

	public static Rule discountByMemberLevel( int level, double discount ){
		return new MemberLevelRule( level ).then( discount( discount ) );
	}

	public static Rule level( int level ){
		return new MemberLevelRule( level );
	}

	public static Rule birthday(){
		return new MemberBirthdayDiscountRule();
	}

	public static Rule discount( double discount ){
		return new MemberDiscountRule( discount );
	}
}
