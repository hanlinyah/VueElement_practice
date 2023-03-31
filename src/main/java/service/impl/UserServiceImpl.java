package service.impl;

import pojo.User;
import service.UserService;
import util.UserMapSession;

public class UserServiceImpl implements UserService {

    @Override
    public  User login(String username, String password){
        UserMapSession userMapSession= new UserMapSession();
        User user=userMapSession.getMapper().selectByUsernameAndPassword(new User(username,password));
        userMapSession.closeSession();
        return user;
    }

    @Override
    public  boolean register(String username,String password){
        UserMapSession userMapSession= new UserMapSession();
        User user=userMapSession.getMapper().selectByUsername(username);
        if(user == null){
            userMapSession.getMapper().insert(new User(username,password));
        }
        userMapSession.closeSession();
        return  user == null;
    }

    @Override
    public  boolean registerCheckName(String username){
        UserMapSession userMapSession= new UserMapSession();
        User user=userMapSession.getMapper().selectByUsername(username);
        userMapSession.closeSession();
        return  user == null;
    }
}
