# spring集成
- - -
* 1
>加入 Spring 和 Shiro 的 jar 包
   • 配置 Spring 及 SpringMVC
   • 参照:1.3.2\shiro-root-1.3.2-source-
   release\shiro-root-1.3.2\samples\spring 配置
   web.xml 文件和 Spring 的配置文件
* 2
>Shiro 提供了与 Web 集成的支持,其通过一个
   ShiroFilter 入口来拦截需要安全控制的URL,然后
   进行相应的控制
   • ShiroFilter 类似于如 Strut2/SpringMVC 这种
   web 框架的前端控制器,是安全控制的入口点,其
   负责读取配置(如ini 配置文件),然后判断URL
   是否需要登录/权限等工作。
* 3
>DelegatingFilterProxy 作用是自动到 Spring 容器查找名
   字为 shiroFilter(filter-name)的 bean 并把所有 Filter
   的操作委托给它。
```
<filter>
       <filter-name>shiroFilter</filter-name>
       <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
       <init-param>
           <param-name>targetFilterLifecycle</param-name>
           <param-value>true</param-value>
       </init-param>
   </filter>

   <filter-mapping>
       <filter-name>shiroFilter</filter-name>
       <url-pattern>/*</url-pattern>
   </filter-mapping>
```
## 部分细节
- - -
+ 1 [urls] 部分的配置,其格式是: “url=拦截器[参数],拦截
器[参数]”;
+ 2 如果当前请求的 url 匹配 [urls] 部分的某个 url 模式,将会
执行其配置的拦截器。
+ 3 anon(anonymous) 拦截器表示匿名访问(即不需要登
录即可访问)
+ 4 authc (authentication)拦截器表示需要身份认证通过后
才能访问
## URL 匹配模式
* 1 url 模式使用 Ant 风格模式
* 2 Ant 路径通配符支持 ?、*、**,注意通配符匹配不包括目录分隔符“/”:
```
– ?:匹配一个字符,如 /admin? 将匹配 /admin1,但不
匹配 /admin 或 /admin/;
– *:匹配零个或多个字符串,如 /admin 将匹配 /admin、
/admin123,但不匹配 /admin/1;
– **:匹配路径中的零个或多个路径,如 /admin/** 将匹
配 /admin/a 或 /admin/a/b
```
## URL 匹配顺序
+ 1 URL 权限采取第一次匹配优先的方式,即从头开始
    使用第一个匹配的 url 模式对应的拦截器链。
+ 2 如:
```
-/bb/**=filter1
-/bb/aa=filter2
-/**=filter3
如果请求的url是“/bb/aa”,因为按照声明顺序进行匹
配,那么将使用 filter1 进行拦截。
```