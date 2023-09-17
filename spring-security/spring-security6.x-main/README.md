# spring-security6.x

for study, for spring security
## 简介
spring security 其实是 filter ,一组 filter
## 设置默认的账号密码
引入spring security 的依赖后，默认拦截 **所有请求路径**, 并且判断是否已经登录，没有的话会强制跳转到登录页面，
spring security 有自带的登录页面（样式地址可能在国外，比较卡甚至加载不了），或者我们也可以自己指定登录页面。 
在我们未设定账号密码的时候，spring security 会为我们自动生成一个用户，拥有所有权限，**用户名是 user** ，密码
**随机生成，在控制台输出**；
### 指定用户名和密码
在 application.yml 中设置，
spring.security.user.name: username
spring.security.user.password: 123456 
## 配置类
### 类上的注解
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
}
```
在spring5 的时候，是不需要 @Configuration，但是前后版本都需要 
在spring 6 的时候，SecurityConfig 的配置 采用 lambda 表达式的方式。
