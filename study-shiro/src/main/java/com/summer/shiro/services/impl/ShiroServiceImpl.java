package com.summer.shiro.services.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

import com.summer.shiro.services.ShiroService;

@Service
public class ShiroServiceImpl implements ShiroService {

	@Override
	@RequiresRoles(value = { "admin" })
	public String testAnnotationPermissions() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sysDate = df.format(new Date());
		System.out.println("testAnnotationPermissions：" + sysDate);
		return sysDate + "    Hellow Shiro";
	}

}
