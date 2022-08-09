package cn.qingyandark.servlet;

import cn.qingyandark.mapper.AreaMapper;
import cn.qingyandark.pojo.Area;
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

@WebServlet("/request12-city")
public class RequestServlet12 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");

        String resource = "mybatis-config.xml";
        System.out.println(resource);
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        get SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        excute sql
        AreaMapper mapper = sqlSession.getMapper(AreaMapper.class);

        List<Area> areas = mapper.selectCity(Integer.parseInt(code));

//        release
        sqlSession.close();

//        System.out.println(us);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(areas));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
