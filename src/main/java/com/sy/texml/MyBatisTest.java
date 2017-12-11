package com.sy.texml;

import java.util.List;

import com.weixin.Oper.MemberCardOperImp;
import com.weixin.membean.MemberCard;

public class MyBatisTest
{
    public static void main(String[] args)
    {
    	String a = null;
    	System.out.println(123);
    	int id = 1;
    	//根据member_code去获取会员信息返回多条记录
    	List<MemberCard> list = MemberCardOperImp.SelectAllByCode("100000002");
    	if(list.size()<=0) {
    		System.out.println("没有这个记录");
    	}else if(list.size()>1) {
    		a=list.get(1).getMember_name();
    		System.out.println("else if 的a :"+a);
    	}else if(list.size()==1) {
    		a=list.get(0).getMember_name();
    		System.out.println("else if 的a :"+a);
    	}
    	System.out.println(a);
    	System.out.println(list.size());
    	System.out.println(list.get(0).getMember_name());
    	System.out.println(list.get(1).getMember_name());
    	//根据member_id去获取会员信息返回一条记录
    	MemberCard membercard = MemberCardOperImp.selectMemberById(1);
    	if(membercard==null) {
    		System.out.println("没有该会员卡,请重新输入");
    	}else {
    		System.out.println("卡号正确卡号为:"+membercard.getMember_code());
    	}
    }
}