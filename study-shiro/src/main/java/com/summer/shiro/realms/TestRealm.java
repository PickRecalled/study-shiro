package com.summer.shiro.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 只是一个测试类，测试实现认证与授权只需要继承AuthorizingRealm类并实现doGetAuthorizationInfo()与doGetAuthenticationInfo()两个抽象方法
 */
public class TestRealm extends AuthorizingRealm {

	@Override
	// 用于授权的方法
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	// 用于认证的方法
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		return null;
	}

}
