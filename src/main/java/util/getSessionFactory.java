package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class getSessionFactory {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        String resource = "mybatis_config.xml";

        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory get(){
        return sqlSessionFactory;
    }
}
