package com.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class ShiroRealmB extends AuthorizingRealm {
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
        Object credentials = null; //"e826d60640ee0c6e9b36a4db5a22043c";
        if ("Lee".equals(username)) {
            credentials = "02660301b7ef1541d2c9577f5fcbeb82";//是用方法算出来的username,password,salt
        } else if ("zhou".equals(username)) {
            credentials = "e826d60640ee0c6e9b36a4db5a22043c";
        }
        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        String realmName = getName();
        //4). 盐值.
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);


        SimpleAuthenticationInfo info = null;
//        info = new SimpleAuthenticationInfo(username, password, realmName);//当然也可以不加盐
        info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
        logger.info("------------->" + info + "");
        return info;
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        Object credentials = "123";
        Object salt = ByteSource.Util.bytes("zhou");
        int hashIterations = 1024;

        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
    }

    /**
     * 授权会被 shiro 回调的方法
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //1. 从 PrincipalCollection 中来获取登录用户的信息
        Object principal = principals.getPrimaryPrincipal();

        //2. 利用登录的用户的信息来用户当前用户的角色或权限(可能需要查询数据库)
        Set<String> roles = new HashSet<>();
        roles.add("user");
        if (principal.equals("zhou")) {
            roles.add("admin");
            logger.info("授予角色权限:" + "admin");
        } else if (principal.equals("Lee")) {
            logger.info("不给授予角色权限");
        }
        /**
         * 无论谁登录　都被授予了user角色权限
         * zhou 被授予了admin权限
         * Lee 未被授予除user以外的角色权限
         * 因此Lee访问admin页面则自动跳转到Unauthorized Page页面(ps表示没有相关的权限)
         */
        //3. 创建 SimpleAuthorizationInfo, 并设置其 reles 属性.
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        //4. 返回 SimpleAuthorizationInfo 对象.
        return info;
    }
}
