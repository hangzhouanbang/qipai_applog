package com.anbang.qipai.applog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anbang.qipai.applog.plan.bean.Applog;
import com.anbang.qipai.applog.plan.service.ApplogService;
import com.anbang.qipai.applog.web.vo.CommonVO;

@RestController
@RequestMapping("/log")
public class ApplogUploadController {

	@Autowired
	private ApplogService applogService;

	/**
	 * 上传日志
	 */
	@RequestMapping("/upload")
	public CommonVO uploadLog(String memberId, String content) {
		CommonVO vo = new CommonVO();
		Applog log = new Applog();
		log.setMemberId(memberId);
		log.setContent(content);
		log.setCreateTime(System.currentTimeMillis());
		applogService.addApplog(log);
		return vo;
	}

	/**
	 * 根据时间删除日志
	 */
	@RequestMapping("/removelog")
	public CommonVO removelog(long deadTime) {
		CommonVO vo = new CommonVO();
		applogService.removeApplogByTime(deadTime);
		return vo;
	}
}
