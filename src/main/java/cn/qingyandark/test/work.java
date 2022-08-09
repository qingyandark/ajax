package cn.qingyandark.test;

import cn.qingyandark.mapper.UserMapper;
import cn.qingyandark.pojo.User;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class work {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        System.out.println(resource);
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        get SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        excute sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.selectAll();

//        release
        sqlSession.close();

        System.out.println(users);

    }
}
