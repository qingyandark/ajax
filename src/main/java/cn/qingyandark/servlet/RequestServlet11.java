package cn.qingyandark.servlet;

import cn.qingyandark.mapper.AreaMapper;
import cn.qingyandark.mapper.UserMapper;
import cn.qingyandark.pojo.Area;
import cn.qingyandark.pojo.User;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/request11-province")
public class RequestServlet11 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String resource = "mybatis-config.xml";
        System.out.println(resource);
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        get SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        excute sql
        AreaMapper mapper = sqlSession.getMapper(AreaMapper.class);

        List<Area> areas = mapper.selectProvince();

//        release
        sqlSession.close();

        System.out.println(areas.toString());

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(areas));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
