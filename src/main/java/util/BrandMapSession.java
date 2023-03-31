package util;

import mapper.BrandMapper;
import org.apache.ibatis.session.SqlSession;


public class BrandMapSession {
    private final SqlSession session;
    private  final BrandMapper brandMapper;

    public BrandMapSession(){
        session=getSessionFactory.get().openSession(true);
        brandMapper=session.getMapper(BrandMapper.class);
    }

    public BrandMapper getMapper() {
        return brandMapper;
    }
    public void closeSession() {
        session.close();
    }

}
