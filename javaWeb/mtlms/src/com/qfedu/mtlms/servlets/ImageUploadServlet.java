package com.qfedu.mtlms.servlets;

import com.google.gson.Gson;
import com.qfedu.mtlms.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * Upload files.
 */
@MultipartConfig
@WebServlet("/ImageUploadServlet")
public class ImageUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receive and save the file.
        Part part = req.getPart("brandLogoImg");
        System.out.println(part);
        //Save picture information.
        //rename
        String header = part.getHeader("Content-Disposition");
        int i = header.lastIndexOf(".");
        int j = header.lastIndexOf("\"");
        String ext = header.substring(i, j);
        String imageName = UUID.randomUUID().toString().replace("-", "")+ext;
        //Get path.
        String dir = getServletContext().getRealPath("/upload");
        //Save picture.
        part.write(dir+"/"+imageName);

        //Return the file access path.
        String path = "upload/"+imageName;
        ResultVO resultVO = new ResultVO(1, path);
        String jsonStr = new Gson().toJson(resultVO);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(jsonStr);
        out.flush();
        out.close();
    }
}
