package com.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroRealmC extends AuthenticatingRealm {//假如只用作登录那么只需继承这个即可不用继承AuthorizingRealm(ps实际中是不可能的)
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1. 把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        //2. 从 UsernamePasswordToken 中来获取 username
        String username = upToken.getUsername();

        //3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
        System.out.println("从数据库中获取 username: " + username + " 所对应的用户信息.");

        //4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
        if ("unknown".equals(username)) throw new UnknownAccountException("用户不存在!");

        //5. 根据用户信息的情况, 决定是否需要抛出其他的 AuthenticationException 异常.
        if ("monster".equals(username)) throw new LockedAccountException("用户被锁定");

        //6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        //以下信息是从数据库中获取的.
        //1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        Object principal = username;
        //2). credentials: 密码.
        Object credentials = null; //
        if ("Lee".equals(username)) {
            credentials = "f6d8d02dcf3a08b85c47d6e0e894fc21e0889fc4";//是用方法算出来的username,password,salt
        } else if ("zhou".equals(username)) {
            credentials = "44ce5388329e6ac5679651450072ff01cf2e4528";
        }
        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        String realmName = getName();
        //4). 盐值.
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);

        SimpleAuthenticationInfo info = null;
        info = new SimpleAuthenticationInfo("ShiroRealmCName", credentials, credentialsSalt, realmName);
        logger.info("--------------------->  ShiroRealmC ------------>"+info);
        return info;
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "SHA1";
        Object credentials = "123";
        Object salt = ByteSource.Util.bytes("Lee");;
        int hashIterations = 1024;

        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
    }
}
