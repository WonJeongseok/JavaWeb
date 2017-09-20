package com.newlecture.javaweb.dao;

import java.util.List;

import com.newlecture.javaweb.entity.Notice;
import com.newlecture.javaweb.entity.NoticeView;

public interface NoticeDao {
	List<NoticeView> getList(int page, String query);
	int getCount();
	NoticeView get(String no);
	int update(String id, String title, String content);
	int insert(String title, String content);
}
