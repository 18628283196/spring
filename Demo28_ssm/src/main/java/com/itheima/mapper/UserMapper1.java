package com.itheima.mapper;

import com.itheima.pojo.User1;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@ResponseBody
public interface UserMapper1 {
    public Long findTotal();
   public List<User1> findList(@Param("index") int index, @Param("rowsNum") int rowsNum);

    void addUser1(User1 user);
}
