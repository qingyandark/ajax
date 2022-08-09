package cn.qingyandark.servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request6")
public class RequestServlet6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        注意响应类型为xml
        response.setContentType("text/xml;charset=utf-8");
        PrintWriter writer = response.getWriter();
        StringBuilder str = new StringBuilder();
        str.append("<students>");
        str.append("<student>");
        str.append("<name>zhangsan</name>");
        str.append("<age>12</age>");
        str.append("</student>");
        str.append("<student>");
        str.append("<name>lisi</name>");
        str.append("<age>21</age>");
        str.append("</student>");
        str.append("</students>");
        writer.print(str);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
