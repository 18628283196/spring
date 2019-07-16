package com.itheima.controller;

import com.itheima.pojo.Item;
import com.itheima.pojo.QueryVo;
import com.itheima.pojo.User;
import com.itheima.service.ItemService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    //全查询
   /* @RequestMapping("itemList.action")
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
    }*/


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
   /* @RequestMapping("itemEdit.action")
   public String findItem(@RequestParam("id") int aaa, Model model){
        System.out.println(aaa);
        Item item = itemService.findItemById(aaa);
        model.addAttribute("item",item);
       return "itemEdit";
   }*/


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
  /*  @RequestMapping("updateItem.action")
    public String findItem(Item item) {
        System.out.println(item.toString());
        itemService.updateItem(item);
        return "success";
    }*/
    /**
     * 根据id和name查询，接收对应的参数
     * 知识：包装类型的参数绑定
     *前台要求：name属性值：Queryvo中 属性.属性  item.id  item.name
     */
    @RequestMapping("queryItem.action")
    public String queryByIdAndName(QueryVo vo){
        System.out.println(vo);
        return "success";
    }
    //////////////////////////////////////////////////////////////////////////////
    //批量删除
   /* @RequestMapping("deleteItem.action")
    public String batchDel(Integer[] ids){
        System.out.println(Arrays.toString(ids));
        return "success";
    }*/

    @RequestMapping("deleteItem.action")
    public String batchDel(QueryVo vo){
        //用QueryVo那就必须具备Integer[] ids这个属性
        System.out.println(Arrays.toString(vo.getIds()));
        return "success";
    }


    //method可以对请求方式进行限定  查询全部用户
    @RequestMapping(value = {"itemList.action","queryAll.action"},method = {RequestMethod.GET,RequestMethod.POST})
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


    /**
     * 完成上传
     * @param item
     * @return
     *
     * multipartFile 上传项的文件
     * 1.常用方法  getoriginalFilename
     * 2.上传操作：transferTo(File file)
     */

   @RequestMapping("updateItem.action")
    public String findItem(Item item , MultipartFile pic) throws IOException {
        //1.上传的操作
                //1.1获取文件的名称
        String originalFilename = pic.getOriginalFilename();
                //1.2 UUID给新名称
        String newFile = UUID.randomUUID().toString();
                 //1.3截取原来名称的后缀名
        int lastIndexOf = originalFilename.lastIndexOf(".");
        String s = originalFilename.substring(lastIndexOf);
                //1.4 新名称和后缀名拼接新文件
        String newFileName = newFile+s;
              //上传文件
        pic.transferTo(new File("D:\\360Downloads\\HotFix\\"+newFileName));

        //2.修改数据的操作
        item.setPicture(newFileName);
        itemService.updateItem(item);
        return "redirect:/itemList.action";
    }


    /**
     * @RequestBody注解用于读取http请求的内容(字符串)，
     *                 通过springmvc提供的HttpMessageConverter接口将读到的内容（json数据）转换为java对象并绑定到Controller方法的参数上。
     *
     *  @ResponseBody注解用于将Controller的方法返回的对象，
     *              通过springmvc提供的HttpMessageConverter接口转换为指定格式的数据如：json,xml等，通过Response响应给客户端
     *  1.前台提交json格式数据=====》形式参数上加  @RequestBody
     *  2.响应的也是json数据的格式
     *               return item对象   =============》加@Responsebody
     *  pom文件中要加json的依赖  :jackson-databind
     */

    @RequestMapping("jsonTest.action")
    public @ResponseBody Item findItem(@RequestBody Item item ) {
        System.out.println(item);

        item.setName("汽车");
        item.setPrice(80000);
       return item;
    }


    /**
     * restFull风格:根据不同请求完成不同操作
     * 资源操作：使用POST、DELETE、PUT、GET，使用不同方法对资源进行操作。
                    分别对应 添加、 删除、修改、查询。

                 传统方式操作资源
                 http://127.0.0.1/item/queryItem.action?id=1	查询,GET
                 http://127.0.0.1/item/saveItem.action			新增,POST
                 http://127.0.0.1/item/updateItem.action		更新,POST
     * 回显页面  原始访问路径;Localhost:8080/itemEdit.action?id=1
     *          restFull访问路径：Localhost:8080/itemEdit/id=1
     *      itemList.jsp和web。xml也需要分别修改路径和拦截
     *      回显数据的路径就是为：http://localhost:8080/itemEdit/1
     */
    @RequestMapping("itemEdit/{id}")
    public String findItem(@PathVariable("id") int aaa, Model model){
        System.out.println(aaa);
        Item item = itemService.findItemById(aaa);
        model.addAttribute("item",item);
        return "itemEdit";
    }



    /**
     * 登录拦截
     *     1.页面跳转的action：原因是json不能通过浏览器直接进行访问
     *        访问路径是：localhost：8080/tologin.action=====>该动作类中转发到  login.jsp
     */
    @RequestMapping("tologin.action")
    public String toLogin(){
        return "forward:/WEB-INF/jsp/login.jsp";
    }

    //处理登录逻辑
    @RequestMapping("login.action")
    public String login(String username, String password, HttpSession session){
        if("zhangsan".equalsIgnoreCase(username.trim()) &&"123".equals(password.trim())){
            //把数据放到Session中
            User user = new User();
            user.setUsername("zhangsan");
            user.setPassword("123");
            session.setAttribute("user",user);
            //页面重定向
            return "redirect:/itemList.action";
        }
        //失败
        session.setAttribute("msg","<font color='red'>用户名或密码错误</font>");
        return "redirect:/tologin.action";
    }





}