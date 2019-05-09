package com.anbang.qipai.applog.plan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anbang.qipai.applog.plan.bean.Applog;
import com.anbang.qipai.applog.plan.dao.ApplogDao;

@Service
public class ApplogService {

	@Autowired
	private ApplogDao applogDao;

	public void addApplog(Applog log) {
		applogDao.save(log);
	}

	public void removeApplogByTime(long deadTime) {
		applogDao.removeByTime(deadTime);
	}
}
