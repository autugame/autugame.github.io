package com.qfedu.mtlms.servlets;

import com.qfedu.mtlms.dto.Manager;
import com.qfedu.mtlms.dto.Menu1;
import com.qfedu.mtlms.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    private static final MenuService MENU_SERVICE = new MenuService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.Query the menu list based on the administrator id.
        //a.Gets the administrator id from session.
        HttpSession session = req.getSession();
        Manager manager = (Manager) session.getAttribute("mgr");
        String mgrId = manager.getMgrId();
        //b.Invoke the 'MenuService' query menu.
        List<Menu1> menuList = MENU_SERVICE.listMenusByMgrId(mgrId);

        //2.Pass the menu collection to index.jsp.
        req.setAttribute("menuList", menuList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
