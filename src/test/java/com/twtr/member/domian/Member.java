package com.twtr.member.domian;

import java.util.Date;

/**
 * 会员
 * 
 * @author yanhai
 *
 */
public class Member {

	private int level;

	private Date birthday;

	private double discount;

	public Member( int level, Date birthday ) {
		super();
		this.level = level;
		this.birthday = birthday;
	}

	public int getLevel(){
		return level;
	}

	public void setLevel( int level ){
		this.level = level;
	}

	public Date getBirthday(){
		return birthday;
	}

	public void setBirthday( Date birthday ){
		this.birthday = birthday;
	}

	public double getDiscount(){
		return discount;
	}

	public void setDiscount( double discount ){
		this.discount = discount;
	}

	@Override
	public String toString(){
		return "Member [level=" + level + ", birthday=" + birthday + ", discount=" + discount + "]";
	}
}
