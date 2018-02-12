# shiroB
> 建议使用intellij 直接可以用intellij打开都不用导入了(因为包含了项目具体配置)
+ version1 实现了与spring的集成并且还测试了没有spring的情况下的简单测试,/shiroB-1/src/main/java/com/shiro/realmTest不会对spring集成造成影响,此文件包是测试用,但是没有写在test file下

+ version2 实现了shiro的校验　基本假如不用权限的话可以用作登录已经足以,但是缓存没怎么设置呢!

+ version3 实现了md5加密多次的判断

+ version4 shiroB-4-more v1:添加了角色的限制但是并没有在 realms里面加上权限的授权 v2:实现了角色权限的授予 v3:多realm验证　可以打开shiroB-4-more查看readme.md

+ version5 shiro标签

+ version6 shiro注解(角色和权限) 暂时为实现(因为没有加上lifecycleBeanPostProcessor)启用 IOC 容器中使用 shiro 的注解. 但必须在配置了 LifecycleBeanPostProcessor 之后才可以使用

+ version7 封装filterChainDefinitionMap 以及配置监听Bean上生命周期的bean(ps　配置version6的功能)

+ version8 session使用
> logger 2018-02-12 15:49:03,428 INFO [com.blue.common.ShiroService] - key:周 

+ version9 rember me

