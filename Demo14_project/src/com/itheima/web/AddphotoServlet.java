package com.itheima.web;

import com.itheima.pojo.Employee;
import com.itheima.service.AllQueryImpl;

import org.apache.commons.beanutils.BeanUtils;
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
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/AddphotoServlet")
public class AddphotoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //新创建一个map集合
            Map<String, String[]> map = new HashMap<>();
            //创建磁盘工厂对象
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            //创建核心解析类
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            //设置编码,防止文件名乱码
            servletFileUpload.setHeaderEncoding("utf-8");
            //解析Request类
            List<FileItem> list = servletFileUpload.parseRequest(request);
            //遍历集合
            for (FileItem item : list) {
                //如果是非上传项
                if (item.isFormField()) {
                    //获取name和value，放入map中
                    String fieldName = item.getFieldName();
                    String value = item.getString("utf-8");
                    String[] arr = {value};
                    map.put(fieldName, arr);
                } else {
                    //如果是上传项
                    String name = item.getName();
                    String[] arr = {name};
                    map.put("photo", arr);
                    //使用io进行上传
                    InputStream inputStream = item.getInputStream();
                    FileOutputStream outputStream = new FileOutputStream(new File("D:\\idear\\idear-work\\"+name));
                    int len;
                    byte[] bytes = new byte[1024];
                    while ((len = inputStream.read(bytes)) != -1){
                        outputStream.write(bytes,0,len);
                    }

                    outputStream.close();
                    inputStream.close();


                }
            }

            Employee el = new Employee();
            BeanUtils.populate(el,map);
            AllQueryImpl al = new AllQueryImpl();
            al.addAll(el);
            response.sendRedirect(this.getServletContext().getContextPath()+"/show.html");



        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
