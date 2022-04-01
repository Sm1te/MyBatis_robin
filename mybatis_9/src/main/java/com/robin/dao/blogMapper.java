package com.robin.dao;

import com.robin.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface blogMapper {
    int addBlog(Blog blog);

    int updateBlog(Map map);

    List<Blog> queryBlogIF(Map map);

    List<Blog> queryBlogChoose(Map map);

    List<Blog> queryBlogByForeach(Map map);
}
