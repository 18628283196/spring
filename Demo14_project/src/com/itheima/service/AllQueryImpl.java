package com.itheima.service;

import com.itheima.dao.AddProduct;
import com.itheima.dao.AddProductImpl;
import com.itheima.pojo.Employee;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.user;
import com.itheima.utils.JDBCUtils2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AllQueryImpl implements AllQuery {
    AddProductImpl ad = new AddProductImpl();

    public AllQueryImpl() throws SQLException {

    }

    @Override
    public List<user> queryAll() throws SQLException {

        List<user> list = ad.addAll();
        return list;
    }

    @Override
    public int delete(int id) throws SQLException {
        return ad.delet(id);
    }

    @Override
    public void addAll(Employee emp) throws SQLException {
        AddProductImpl ad = new AddProductImpl();
        ad.add(emp);
    }

    //通过id查询员工用于回显数据
    @Override
    public user queryService(int id) throws SQLException {
        user list = ad.updateDao(id);
        return list;
    }

    //修改员工信息
    @Override
    public void queryService(user use) throws SQLException {
        ad.updatedao(use);
    }


    //通过id批量删除员工信息
    @Override
    public int deleteAllById(String dir) throws SQLException {
        Connection connection = null;
        String[] arr = null;
        int count = 0;


        try {
            connection = JDBCUtils2.getConnection();
            //设置为手动提交事务
            connection.setAutoCommit(false);
            //dir是个字符串，需要切割字符串
            arr = dir.split(",");
            //定义一个count，每删除一次count++，最后判断count是否等于arr.length
            for (String eidtr : arr) {
                int eid = Integer.parseInt(eidtr);
                //调用dao层的删除方法
                ad.deletAll(connection, eid);
                count++;
            }
            //事务提交
            connection.commit();
        } catch (SQLException e) {
            //异常，事务回滚

                connection.rollback();
            }


        if(count==arr.length){
            return 1;
        }else {
            return 0;
        }
    }
    //分页查询
    @Override
    public PageBean findPageBean(Long currentPage,int rows) throws SQLException {
        /**
         *1. 创建一个没有数据的pageBean
         * 2.设置属性
         *      1.total 总记录数  没有---调用dao的查询方法
         *      2.totalPage 总页码数 没有
         *      计算： 总页码数=总记录数%每页条数==0 ？总记录数/每页条数 ： 总记录数/每页条数+1
         *      3.每页条数----已经有了rows
         *      4.当前页码---已经有了currentPage
         *      5.每页的数据list<Employee> 没有----dao查询
         *          每页的数据=（当前页-1）*每页条数
         *          调用dao方法查询
         *  3.返回已经含有数据的pageBean对象
         *
         */
            PageBean pageBean = new PageBean();

            //total 总记录数  没有---调用dao的查询方法
            Long total = ad.queryTotal();
            //设置属性
            pageBean.setTotal(total);
            //totalPage 总页码数 没有
            //计算： 总页码数=总记录数%每页条数==0 ？总记录数/每页条数 ： 总记录数/每页条数+1
            Long totalPage = total%rows==0 ? total/rows : total/rows + 1;
            pageBean.setTotalPage(totalPage);
            //每页条数
            pageBean.setRows(rows);
            //当前页码
            pageBean.setCurrentPage(currentPage);
            //每页的数据list<Employee> 没有----dao查询
            //          每页的数据=（当前页-1）*每页条数
            //           调用dao方法查询
            Long index = (currentPage-1) * rows;
           List<user> list = ad.findEmpDept(index,rows);
           pageBean.setList(list);

                return pageBean;
    }
}
