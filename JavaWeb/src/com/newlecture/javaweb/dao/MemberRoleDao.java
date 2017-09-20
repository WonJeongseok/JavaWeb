package com.newlecture.javaweb.dao;

public interface MemberRoleDao {

	String gerDefaultRoleId(String memberId);

	boolean hasRole(String id, String string);

}
