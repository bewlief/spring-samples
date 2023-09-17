package com.example.springsecurity.entity.impl;

import com.alibaba.fastjson2.annotation.JSONField;
import com.example.springsecurity.entity.user;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class LoginUser implements UserDetails {
    private static final long serialVersionUID = 1L;

    public LoginUser() {
    }

    public LoginUser(user user, Set<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    public LoginUser(Long userId, user user, Set<String> permissions) {
        this.userId = userId;
        this.user = user;
        this.permissions = permissions;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public com.example.springsecurity.entity.user getUser() {
        return user;
    }

    public void setUser(com.example.springsecurity.entity.user user) {
        this.user = user;
    }

    private Long userId;
    /**
     * 过期时间
     */
    private Long expireTime;

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 登录时间
     */
    private Long loginTime;

    private String token;
    /**
     * 权限列表
     */
    private Set<String> permissions;
    /**
     * 用户信息
     */
    private user user;



    /**
     * 账户是否未过期,过期无法验证
     */
    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指定用户是否解锁,锁定的用户无法进行身份验证
     *
     * @return
     */
    @Override
    @JSONField(serialize = false)
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
     *
     * @return
     */
    @JSONField(serialize = false)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    /**
     * 是否可用 ,禁用的用户不能身份验证
     *
     * @return
     */
    @JSONField(serialize = false)
    @Override
    public boolean isEnabled() {
        return true;
    }

    @JSONField(serialize = false)
    @Override
    public String getPassword() {
        return user.getPasswore();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 根据自定义逻辑来返回用户权限，如果用户权限返回空或者和拦截路径对应权限不同，验证不通过
//        if (!permissions.isEmpty()) {
//            List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
//            for (String temp : permissions) {
//                GrantedAuthority au = new SimpleGrantedAuthority(temp);
//                list.add(au);
//            }
//            return list;
//        }
        return null;
    }

}
