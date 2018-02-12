# shiro （java安全框架）
## 主要功能
> 三个核心组件：Subject, SecurityManager 和 Realms.
- - -
###
+ 1 Subject：即“当前操作用户”。但是，在Shiro中，Subject这一概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑到大多数目的和用途，你可以把它认为是Shiro的“用户”概念。
+ 2 Subject代表了当前用户的安全操作，SecurityManager则管理所有用户的安全操作。
+ 3 SecurityManager：它是Shiro框架的核心，典型的Facade模式，Shiro通过SecurityManager来管理内部组件实例，并通过它来提供安全管理的各种服务。
+ 4 Realm： Realm充当了Shiro与应用安全数据间的“桥梁”或者“连接器”。也就是说，当对用户执行认证（登录）和授权（访问控制）验证时，Shiro会从应用配置的Realm中查找用户及其权限信息。
+ 5 从这个意义上讲，Realm实质上是一个安全相关的DAO：它封装了数据源的连接细节，并在需要时将相关数据提供给Shiro。当配置Shiro时，你必须至少指定一个Realm，用于认证和（或）授权。配置多个Realm是可以的，但是至少需要一个。
+ 6 Shiro内置了可以连接大量安全数据源（又名目录）的Realm，如LDAP、关系数据库（JDBC）、类似INI的文本配置资源以及属性文件等。如果缺省的Realm不能满足需求，你还可以插入代表自定义数据源的自己的Realm实现。

# Shiro 架构
## A
- - -
+ 1 Authentication:身份认证/登录,验证用户是不是拥有相应的身份;
+ 2 Authorization:授权,即权限验证,验证某个已认证的用户是否拥有某个权限;即判断用
    户是否能进行什么操作,如:验证某个用户是否拥有某个角色。或者细粒度的验证某个用户
    对某个资源是否具有某个权限;
+ 3 Session Manager:会话管理,即用户登录后就是一次会话,在没有退出之前,它的所有
    信息都在会话中;会话可以是普通 JavaSE 环境,也可以是 Web 环境的;
+ 4 Cryptography:加密,保护数据的安全性,如密码加密存储到数据库,而不是明文存储;
+ 5 Web Support:Web 支持,可以非常容易的集成到Web 环境;
+ 6 Caching:缓存,比如用户登录后,其用户信息、拥有的角色/权限不必每次去查,这样可
    以提高效率;
+ 7 Concurrency:Shiro 支持多线程应用的并发验证,即如在一个线程中开启另一个线程,能
    把权限自动传播过去;
+ 8 Testing:提供测试支持;
+ 9 Run As:允许一个用户假装为另一个用户(如果他们允许)的身份进行访问;
+ 10 Remember Me:记住我,这个是非常常见的功能,即一次登录后,下次再来的话不用登
     录了
## B
- - -
* 1 Subject:应用代码直接交互的对象是 Subject,也就是说 Shiro 的对外
    API 核心就是 Subject。Subject 代表了当前“用户”, 这个用户不一定
    是一个具体的人,与当前应用交互的任何东西都是 Subject,如网络爬虫,
    机器人等;与 Subject 的所有交互都会委托给 SecurityManager;
    Subject 其实是一个门面,SecurityManager 才是实际的执行者;
* 2 SecurityManager:安全管理器;即所有与安全有关的操作都会与
    SecurityManager 交互;且其管理着所有 Subject;可以看出它是 Shiro
    的核心,它负责与 Shiro 的其他组件进行交互,它相当于 SpringMVC 中
    DispatcherServlet 的角色
* 3 Realm:Shiro 从 Realm 获取安全数据(如用户、角色、权限),就是说
    SecurityManager 要验证用户身份,那么它需要从 Realm 获取相应的用户
    进行比较以确定用户身份是否合法;也需要从 Realm 得到用户相应的角色/
    权限进行验证用户是否能进行操作;可以把 Realm 看成 DataSource
## C
- - -
+ 1 Subject:任何可以与应用交互的“用户”;
+ 2 SecurityManager :相当于SpringMVC 中的 DispatcherServlet;是 Shiro 的心脏;
    所有具体的交互都通过 SecurityManager 进行控制;它管理着所有 Subject、且负责进
    行认证、授权、会话及缓存的管理。
+ 3 Authenticator:负责 Subject 认证,是一个扩展点,可以自定义实现;可以使用认证
    策略(Authentication Strategy),即什么情况下算用户认证通过了;
+ 4 Authorizer:授权器、即访问控制器,用来决定主体是否有权限进行相应的操作;即控
    制着用户能访问应用中的哪些功能;
+ 5 Realm:可以有 1 个或多个 Realm,可以认为是安全实体数据源,即用于获取安全实体
    的;可以是JDBC 实现,也可以是内存实现等等;由用户提供;所以一般在应用中都需要
    实现自己的 Realm;
+ 6 SessionManager:管理 Session 生命周期的组件;而 Shiro 并不仅仅可以用在 Web
    环境,也可以用在如普通的 JavaSE 环境
+ 7 CacheManager:缓存控制器,来管理如用户、角色、权限等的缓存的;因为这些数据
    基本上很少改变,放到缓存中后可以提高访问的性能
+ 8 Cryptography:密码模块,Shiro 提高了一些常见的加密组件用于如密码加密/解密。