package com.qfedu.controller;

import com.qfedu.controller.beans.Book;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/book")
public class BookController {
    @RequestMapping("/add")
    public String addBook(Book book, MultipartFile imgFile, HttpServletRequest request) throws IOException {
        String originalFilename = imgFile.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName= UUID.randomUUID().toString()+ext;
        String dir = request.getServletContext().getRealPath("images");
        String savePath = dir+"/"+fileName;
        imgFile.transferTo(new File(savePath));
        book.setBookImg("images/"+fileName);
        System.out.println(book);
        return "/tips.jsp";
    }

    @RequestMapping("/list")
    @ResponseBody
    public String[] listImages(HttpServletRequest request){
        String dir = request.getServletContext().getRealPath("images");
        File images = new File(dir);
        String[] fileNames = images.list();
        return fileNames;
    }

    @RequestMapping("/download")
    public void downloadImage(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String dir = request.getServletContext().getRealPath("images");
        String filePath = dir+"/"+fileName;
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ServletOutputStream outputStream = response.getOutputStream();
        response.setContentType("application/exe");
        response.addHeader("content-disposition", "attachment;filename="+fileName);
        IOUtils.copy(fileInputStream, outputStream);
    }
}
