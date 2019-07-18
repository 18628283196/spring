package com.itheima.dao;

import com.itheima.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * 1.根据id查询用户
 * 2.根据name查询用户
 * 3.添加user
 */

/**
 * dao层编写的时候
 * SQLSession对象来执行  selectOne  selectList   insert（）
 *
 *sqlSession是由工厂创建
 * 继承Spring提供的 sqlSessionDaoSupport  就可以使用它里面提供的SqlSession方法
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
    //1.根据id查询用户
    public User findUserById(int id) {
        SqlSession sqlSession = this.getSqlSession();
        User user = sqlSession.selectOne("test.findUserById",id);
        return user;
    }
    //2.根据name查询用户
    public List<User> findUserByName(String name) {
        SqlSession sqlSession = this.getSqlSession();
        List<User> list = sqlSession.selectList("test.findUserByName", name);
        return list;
    }
    //3.添加user
    public void inserUser(User user) {
        getSqlSession().insert("test.insertUser",user);

    }
}
