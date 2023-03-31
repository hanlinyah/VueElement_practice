package service;

import pojo.User;

public interface UserService {
    User login(String username, String password);

    boolean register(String username,String password);

    boolean registerCheckName(String username);
}
