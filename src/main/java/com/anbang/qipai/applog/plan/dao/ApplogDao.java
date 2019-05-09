package com.anbang.qipai.applog.plan.dao;

import com.anbang.qipai.applog.plan.bean.Applog;

public interface ApplogDao {

	void save(Applog log);

	void removeByTime(long deadTime);
}
