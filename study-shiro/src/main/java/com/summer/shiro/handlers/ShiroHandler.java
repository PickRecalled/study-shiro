package com.summer.shiro.handlers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shiro")
public class ShiroHandler {

	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		Subject currentUser = SecurityUtils.getSubject();

		if (!currentUser.isAuthenticated()) {
			// 把用户名和密码封装为 UsernamePasswordToken 对象
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			// rememberme
			token.setRememberMe(true);
			try {
				//打印login方法中token的哈希码是否与自定义实现ShiroRealm中doGetAuthenticationInfo方法中token的哈希码是否一至
				System.out.println("shiroHandlerLogin:" + token.hashCode());
				// 执行登录.
				currentUser.login(token);
			}
			// ... catch more exceptions here (maybe custom ones specific to your application?
			// 所有认证时异常的父类.
			catch (AuthenticationException ae) {
				// unexpected condition? error?
				System.out.println("登录失败: " + ae.getMessage());
			}
		}

		return "redirect:/list.jsp";
	}
}
