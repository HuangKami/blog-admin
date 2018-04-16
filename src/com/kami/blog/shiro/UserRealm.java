package com.kami.blog.shiro;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kami.blog.common.Assist;
import com.kami.blog.model.Privilege;
import com.kami.blog.model.Role;
import com.kami.blog.model.User;
import com.kami.blog.service.PrivilegeService;
import com.kami.blog.service.RoleService;
import com.kami.blog.service.UserService;  
  
@Component  
public class UserRealm extends AuthorizingRealm {  
      
    @Autowired  
    private UserService userService;  
    @Autowired
    private RoleService roleService;
    @Autowired
    private PrivilegeService privilegeService;
  
    /** 
     * 授权操作 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {  
        String name = (String) principalCollection.fromRealm(getName()).iterator().next();  
          
        Set<Role> roleSet =  roleService.selectRolesByUserName(name);  
        //角色名的集合  
        Set<String> roles = new HashSet<String>();  
        //权限名的集合  
        Set<String> permissions = new HashSet<String>();  
          
        Iterator<Role> it = roleSet.iterator();  
        while(it.hasNext()){  
        	Role role = it.next();
            roles.add(role.getName());  
            for(Privilege privilege : privilegeService.selectPrivilegesByRoleId(role.getId())){  
                permissions.add(privilege.getName());  
            }  
        }
        
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();  
        authorizationInfo.addRoles(roles);  
        authorizationInfo.addStringPermissions(permissions);  
        return authorizationInfo;  
    }  
  
    /** 
     * 身份验证操作 
     */  
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(  
            AuthenticationToken authenticationToken) throws AuthenticationException {  
    	UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;  
        Assist assist = new Assist().setRequires(Assist.andEq("name", token.getUsername()));
        List<User> users = userService.selectUser(assist);
        if(users == null || users.size() == 0){  
            throw new UnknownAccountException("没有找到该账号");  
        }  
        User user = users.get(0);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
        		user.getName(), user.getPassword(), getName());  
        return info;  
    }  
      
    @Override  
    public String getName() {  
        return getClass().getName();  
    }  
  
}  