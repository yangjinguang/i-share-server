package com.pingyueryou.ishare.security;


import com.pingyueryou.ishare.jooq.tables.pojos.IUser;
import com.pingyueryou.ishare.service.IUserDbService;
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
        IUser user = iUserDbService.getByOpenId(openId);
        if (null != user) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(user.getId());
            userEntity.setUsername(user.getOpenId());
            return userEntity;
        }
        return null;
    }
}
