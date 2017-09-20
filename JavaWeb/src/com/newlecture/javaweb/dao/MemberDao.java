package com.newlecture.javaweb.dao;

import com.newlecture.javaweb.entity.Member;

public interface MemberDao {


	int insert(Member member);

	int insert(String id, String pwd, String name, String nicName, String phone, String email);

	Member get(String id);

}
