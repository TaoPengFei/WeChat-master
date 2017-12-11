package com.weixin.Imem;

import java.util.List;

import com.weixin.membean.MemberCard;

//该接口暂时不实现 用的时候再去实现它 留着备用
public interface CheckMember {
	/**
	 * 根据输入的卡号去匹配数据库的卡号
	 * 只匹配一条
	 */
	public MemberCard SelectOneByCode(String Code);
	
	
	/**
	 * 根据输入的卡号去匹配数据库的卡号
	 * 可以匹配多条放入数据库
	 * @param Code
	 * @return
	 */
	public List<MemberCard> CheckCode(String Code);
	
}
