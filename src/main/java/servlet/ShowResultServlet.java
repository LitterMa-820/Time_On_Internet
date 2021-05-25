package servlet;

import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

/**
 * @ProjectName: Time_On_Internet
 * @Package: servlet
 * @ClassName: ShowResultServlet
 * @Author: 82042
 * @Description:
 * @Date: 2021/4/27 15:44
 * @Version: 1.0
 */
@WebServlet(urlPatterns = "/show")
public class ShowResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        System.out.println("被访问了");
        HashMap<String, Integer> useTime = StudentDao.scanTable("useTime");
        //System.out.println("查询完毕了");
        Set<String> strings =useTime.keySet();
        System.out.println("map 查询");
//        for (String string : strings) {
//            System.out.println("map:"+string+":"+useTime.get(string));
//        }
        req.setAttribute("Time",useTime);
        req.getRequestDispatcher("/datas.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
