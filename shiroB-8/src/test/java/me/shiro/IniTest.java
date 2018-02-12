package me.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.apache.shiro.mgt.SecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IniTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void loginA() throws Exception {
        init("shiroA1.ini","zhou","123");
    }

    @Test
    public void testRealm(){
        init("shiro-realm.ini","Lee","123");
    }

    private void init(String ini,String username,String password){
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager 虽然过时的方法但是它的官网依旧是这个方法,而且对以后没影响(毕竟通过spring集成)
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:"+ini);

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        //4 创建用户名和密码令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username+"",""+password);
        try {
            subject.login(token);//登录
            logger.info(".......................> login success");
        }catch (AuthenticationException e){
            logger.error("----------------------> login fail"+e.getMessage());
            throw new AuthenticationException();
        }
        //5 退出
        subject.logout();
    }

}
