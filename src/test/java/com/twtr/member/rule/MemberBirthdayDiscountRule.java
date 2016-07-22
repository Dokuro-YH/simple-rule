package com.twtr.member.rule;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.twtr.member.domian.Member;
import com.twtr.rule.api.Rule;

/**
 * 会员生日规则
 * 
 * @author yanhai
 *
 */
public class MemberBirthdayDiscountRule extends Rule {

	@Override
	public boolean apply( Object context ){
		Member member = (Member) context;
		return DateFormatUtils.format( member.getBirthday(), "MMdd" ).equals( DateFormatUtils.format( new Date(), "MMdd" ) );
	}
}
