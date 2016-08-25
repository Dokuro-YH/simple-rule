# Simple-Rule 一个简单的规则引擎

示例
```java
/**
 * 规则引擎测试
 * 
 * @author yanhai
 *
 */
public class TestRuleEngine {

	/**
	 * 获取会员等级规则
	 * 
	 * @return {@link Rule}
	 */
	static Rule getMemberLevelRule(){
		final Rule silver_rule = MemberRules.discountByMemberLevel( 1, 0.9 );// 银卡会员，折扣9
		final Rule gold_rule = MemberRules.discountByMemberLevel( 2, 0.8 );// 金卡会员，折扣8
		final Rule platinum_rule = MemberRules.discountByMemberLevel( 3, 0.6 );// 铂金会员，折扣7
		final Rule member_level = MemberRules.any( silver_rule, gold_rule, platinum_rule );// 互斥组合规则
		final Rule member_rules = MemberRules.or( member_level, MemberRules.discount( 1 ) );// 或者组合规则
		return member_rules;// 最终返回的规则为：会员等级1，折扣9；会员等级2，折扣8；会员等级3，折扣7；以上都不是，默认折扣1
	}

	/**
	 * 获取会员生日规则
	 * 
	 * @return {@link Rule}
	 */
	static Rule getMemberBirthRule(){
		final Rule birth_rule = MemberRules.birthday().then( MemberRules.discount( 0.9 ) );// 如果今天是会员的生日，则在原折扣基础上再打9折
		return birth_rule;
	}

	public static void main( String[] args ){
		RulesEngine engine = new DefaultRulesEngine();// 初始化规则引擎
		engine.registerRule( getMemberLevelRule() );// 注册会员等级规则
		engine.registerRule( getMemberBirthRule() );// 注册会员生日规则
		Member member = new Member( 0, new Date() );// other会员，会员等级0，今天生日
		Member member1 = new Member( 1, new Date() );// 初始化银卡会员，会员等级1，今天生日
		Member member2 = new Member( 2, DateUtils.addDays( new Date(), -1 ) );// 初始化金卡会员，会员等级2，生日不是今天
		Member member3 = new Member( 3, DateUtils.addDays( new Date(), -1 ) );// 初始化铂金会员，会员等级3，生日不是今天
		// 运行规则引擎
		engine.run( member );
		System.out.println( "其他会员: " + member );
		engine.run( member1 );
		System.out.println( "银卡会员: " + member1 );
		engine.run( member2 );
		System.out.println( "金卡会员: " + member2 );
		engine.run( member3 );
		System.out.println( "铂金会员: " + member3 );
	}
}
```
