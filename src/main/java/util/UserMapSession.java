package util;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;


public class UserMapSession {
    private final SqlSession session;
    private  final UserMapper userMapper;

    public UserMapSession(){
        session=getSessionFactory.get().openSession(true);
        userMapper=session.getMapper(UserMapper.class);
    }

    public UserMapper getMapper() {
        return userMapper;
    }
    public void closeSession() {
        session.close();
    }

}
