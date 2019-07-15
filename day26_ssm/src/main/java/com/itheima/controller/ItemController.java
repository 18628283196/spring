package com.itheima.controller;

import com.itheima.pojo.Item;
import com.itheima.service.ItemService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("itemList.action")
    public ModelAndView queryAll() {
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //调用方法
        List<Item> list = itemService.findAll();
        //存放到ModelAndView域中
        modelAndView.addObject("itemList", list);
        //跳转页面（没加全路径是因为我们配置了视图解析器）
        modelAndView.setViewName("itemList");
        //return ModelAndView
        return modelAndView;
    }


    //数据回显

    /**
     *接受参数的方式1：原始方式HttpSerRequest
     * 形参上面可以设置：HttpServletRequest  HttpSerResponse   HttpSession
     *
     */
    /*@RequestMapping("itemEdit.action")
    public ModelAndView findItem(HttpServletRequest request){
        //获取id值
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        Item item = itemService.findItemById(id);
        ModelAndView modelAndView = new ModelAndView();
       modelAndView.addObject("item",item);
       modelAndView.setViewName("itemEdit");
       return modelAndView;
    }*/


    /**
     * 目的：还是回显数据
     *
     * 1.model对象 设置数据
     * 2.跳转页面的方式
     * 返回值String  值如果写的是页面的名字，就会跳转到指定页面
     *  自己调试结论：model不加也可以 ，直接用Request也能完成数据的回显
     */
   /* @RequestMapping("itemEdit.action")
    public String findItem(HttpServletRequest request,Model model){
        //获取id值
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        //调用方法
        Item item = itemService.findItemById(id);
        //通过model设置数据，将要带到哪个页面
       // request.setAttribute("item",item);
        model.addAttribute("item",item);
        return "itemEdit";
    }*/


    /**
     * 传递参数方式2：
     * itemList.jsp中  itemEdit.action?id=${item.id}
     *  页面中的名称和方法中的参数名称一致，即可形成绑定
     *  会把页面中的参数值传到形参中
     */
   /* @RequestMapping("itemEdit.action")
    public String findItem(int id,Model model){
        System.out.println(id);
        Item item = itemService.findItemById(id);
        model.addAttribute("item",item);
        return "itemEdit";
    }*/


    /**
     * 回显数据
     * @Requestparam（参数）
     * 其中参数与前台页面参数必须一致
     */
    @RequestMapping("itemEdit.action")
   public String findItem(@RequestParam("id") int aaa, Model model){
        System.out.println(aaa);
        Item item = itemService.findItemById(aaa);
        model.addAttribute("item",item);
       return "itemEdit";
   }


    /**
     * 回显数据
     * @Requestparam（参数）
     * @Requestparam（参数）注解中有取值：
     *      value：和我们前台页面传递的参数名称一致，可以参数传递到形参
     *      require：前台访问的时候必须传递参数，如果不传递报错400
     *      defaultvalue：在注解中可以通过设置属性设置一个默认值，如果没传递参数，取默认值
     *
     *      测试方式一：
     *      @RequestParam(value = "id" ,required = true,defaultValue = "1") int aaa   正常
     *
     *       测试方式二：
     *      @RequestParam(required = true) int aaa   不传参数 400错误
     *
     *       测试方式三：
     *      @RequestParam(required = true,defaultValue = "1") int aaa   不传参数 ，但默认值始终是1
     *
     */
 /*   @RequestMapping("itemEdit.action")
    public String findItem(@RequestParam(required = true,defaultValue = "1") int aaa, Model model){
        System.out.println(aaa);
        Item item = itemService.findItemById(aaa);
        model.addAttribute("item",item);
        return "itemEdit";
    }*/


    /**
     * 更新用户信息
     *     private int id;
     private String name;
     private double price;
     private String detail;
     private String pic;
     private Date createtime;
     */
   /* @RequestMapping("updateItem.action")
    public String updateItem(int id,String name,Double price,String detail) throws UnsupportedEncodingException {
        System.out.println(id);
        System.out.println(name);
        System.out.println(price);
        System.out.println(detail);
        //如果是get方式的请求
        //需要一个一个的解决，非常麻烦
       // String newName = new String(name.getBytes("ISO-8859-1"),"UTF-8");

        Item item = new Item(id,name,price,detail);
        itemService.updateItem(item);
        return "success";
    }*/


    /**
     * 第四种参数方式的传递：
     * 页面参数之间封装成一个对象
     * 要求：from表单和Item类中的属性名称要一样
     */
    @RequestMapping("updateItem.action")
    public String findItem(Item item) {
        System.out.println(item.toString());
        itemService.updateItem(item);
        return "success";
    }
}