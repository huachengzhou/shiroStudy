# shiro标签
> Shiro 提供了 JSTL 标签用于在 JSP 页面进行权限控制,如
  根据登录用户显示相应的页面按钮。
+ 1:guest 标签:用户没有身份验证时显示相应信息,即游客
    访问信息:
```
<shiro:guest>欢迎游客访问</shiro:guest>
```
+ 2:user 标签:用户已经经过认证/记住我登录后显示相应的信
    息。
```
<shiro:user>欢迎<shiro:principal /> </shiro:user>
```
+ 3: