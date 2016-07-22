package com.twtr.member.rule;

import com.twtr.member.domian.Member;
import com.twtr.rule.api.Rule;

/**
 * 会员折扣规则
 * @author yanhai
 *
 */
public class MemberDiscountRule extends Rule {

	private final double discount;

	public MemberDiscountRule( double discount ) {
		super();
		this.discount = discount;
	}

	@Override
	public boolean apply( Object context ){
		Member member = (Member) context;
		if (member.getDiscount() == 0.0d) {
			member.setDiscount( discount );
		} else {
			member.setDiscount( member.getDiscount() * discount );
		}
		return true;
	}
}
