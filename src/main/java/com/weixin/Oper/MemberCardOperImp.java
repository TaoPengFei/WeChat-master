package com.weixin.Oper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.weixin.membean.MemberCard;


public class MemberCardOperImp extends BaseOperator{
	 private static MemberCardOperImp instance = new MemberCardOperImp();
	    
	    private MemberCardOperImp()
	    {
	        
	    }
	    public static MemberCardOperImp getInstance()
	    {
	        return instance;
	    }
	    public static MemberCard selectMemberById(int member_id)
	    {
	        SqlSession ss = ssf.openSession();
	        MemberCard membercard = null;
	        try
	        {
	        	membercard = ss.selectOne("com.weixin.Oper.MemberCardOperImp.selectMemberById",new MemberCard(member_id, null, null));
	        }
	        finally
	        {
	            ss.close();
	        }
	        return membercard;
	    }
	    public static List<MemberCard> SelectAllByCode(String MemberCode){
	    	SqlSession ss = ssf.openSession();
	    	List<MemberCard> list =null;
	    	list = ss.selectList("com.weixin.Oper.MemberCardOperImp.SelectAllByCode", MemberCode);
	    	ss.close();
			return list;
	    	
	    }
}
