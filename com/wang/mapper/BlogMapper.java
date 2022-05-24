package com.wang.mapper;

import com.wang.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//@Component
@Repository
public interface BlogMapper {
    //==============Blog列表

    //查询全部
    List<Blog> queryBlog();
    //查询
    Blog getUserById(int id);
    //增加
    int addBlog(Blog blog);
    //删除
    int deleteBlog(int id);
    //修改
    int updateBlog(Blog blog);

    //===================== 侧边栏链接

    //ul修改
    int updateBlogul(Blogul blogul);
    //ul查询
    List<Blogul> queryBlogul();

    //=====================Friend列表

    List<Friend> queryFriend();
    //查询
    Blog getFriendById(int id);
    //增加
    int addFriend(Friend friend);
    //删除
    int deleteFriend(int id);
    //修改
    int updateFriend(Friend friend);

    //=====================Person列表
    //修改
    int updatePerson(Person person);
    Person getPersonById(int id);
    List<Person> queryPerson();
    //============登录
    Admin login(@Param("username") String username, @Param("password") String password);

    int updateAdmin(Admin admin);

}
