# 权限问题

+ 1 v1:角色权限的限制
+ 2 v2:角色权限的授权　(在登录用户的时候根据用户授予角色权限,那么根据不同的角色可以访问不同的资源 Lee和zhou 用户可以根据角色不同访问admin.jsp以及user.jsp等)

+ 3 v3:多 realm验证(很重要)
> 打印的消息
* 1: 2018-02-12 12:13:52,148 INFO [com.shiro.realm.ShiroRealmA] - --------------------->ShiroRealmA------------------->Lee 
* 2:2018-02-12 12:13:52,149 INFO [com.shiro.realm.ShiroRealmC] - --------------------->  ShiroRealmC ------------>ShiroRealmCName 
* 3:2018-02-12 12:13:52,149 INFO [com.shiro.realm.ShiroRealmC] - --------------------->  ShiroRealmC ------------>ShiroRealmCName 

```
<property name="realms">
            <list>
                <ref bean="shiroRealmB" />
                <ref bean="shiroRealmA" />
                <ref bean="shiroRealmC" /><!-- 多Realm验证 ,不要加上shiroRealmA有这两个就够了,当然加上也无妨但是总感多余呀!-->
                <!--
                 -->
            </list>
        </property>
```

