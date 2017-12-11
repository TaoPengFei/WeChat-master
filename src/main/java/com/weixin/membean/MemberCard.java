package com.weixin.membean;

public class MemberCard {
	private int member_id;
	private String member_name;
	private String member_code;
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_code() {
		return member_code;
	}
	public void setMember_code(String member_code) {
		this.member_code = member_code;
	}
	@Override
	public String toString() {
		return "MemberCard [member_id=" + member_id + ", member_name=" + member_name + ", member_code=" + member_code
				+ "]";
	}
	public MemberCard()
    {
        super();
    }
	public MemberCard(int member_id, String member_name, String member_code) {
		
		this.member_id = member_id;
		this.member_name = member_name;
		this.member_code = member_code;
	}
	

}
