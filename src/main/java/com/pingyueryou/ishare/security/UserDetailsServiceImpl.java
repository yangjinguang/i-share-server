package com.pingyueryou.ishare.security;


import com.pingyueryou.ishare.dbservice.IUserDbService;
import com.pingyueryou.ishare.entity.IUserExtra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUserDbService iUserDbService;


    @Override
    public UserDetails loadUserByUsername(String openId) throws UsernameNotFoundException {
        //查数据库
        IUserExtra user = iUserDbService.getByOpenId(openId);
        if (null != user) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(user.getId());
            userEntity.setUsername(user.getOpenId());
            userEntity.setUser(user);
            return userEntity;
        }
        return null;
    }
}
