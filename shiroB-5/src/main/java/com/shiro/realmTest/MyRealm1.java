package com.shiro.realmTest;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyRealm1 implements Realm {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 返回一个唯一的Realm名字
     *
     * @return
     */
    @Override
    public String getName() {
        return "myRealm1";//this.getClass().getSimpleName() 会返回class name MyRealm1
    }

    /**
     * 判断此Realm是否支持此Token
     *
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        boolean flag = token instanceof UsernamePasswordToken;
        return flag;
    }

    /**
     * 根据Token获取认证信息
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();//得到用户名
        String password = new String((char[])token.getCredentials());//得到密码
        SimpleAuthenticationInfo simpleAuthenticationInfo;
        if (!(username.equals("zhou") || username.equals("Lee"))) throw new UnknownAccountException("用户名错误");
        if (!(password.equals("123"))) throw new IncorrectCredentialsException("密码错误");
        simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
        return simpleAuthenticationInfo;
    }
}
