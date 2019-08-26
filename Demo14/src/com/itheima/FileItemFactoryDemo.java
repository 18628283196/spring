package com.itheima;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@WebServlet("/FileItemFactoryDemo")
public class FileItemFactoryDemo extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        //创建磁盘工厂对象
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        //创建核心解析类
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("utf-8");

            List<FileItem> list = servletFileUpload.parseRequest(req);
            //判断是否是普通项
            for (FileItem fileItem : list) {
               if(fileItem.isFormField()){
                   //获取名称
                   String name = fileItem.getFieldName();
                   //获取属性
                   String value = fileItem.getString("utf-8");
                   System.out.println("name="+name+",value="+value);
               }else {
                   //获取文件名
                   String name = fileItem.getName();
                   //获取输入流对象
                   InputStream inputStream = fileItem.getInputStream();
                   //定义输出流对象
                   FileOutputStream outputStream = new FileOutputStream(new File("D:\\idear\\idear-work\\"+name));
                   int len;
                   byte[] arr = new byte[1024 << 2];
                   while ((len = inputStream.read(arr)) != -1){
                       outputStream.write(arr,0,len);
                   }
                   outputStream.close();
                   inputStream.close();
               }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
