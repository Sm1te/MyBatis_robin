
import com.robin.dao.blogMapper;
import com.robin.pojo.Blog;
import com.robin.utils.IDutils;
import com.robin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {

    @Test
    public void addBlog() {

        // 获取sqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 获取Mapper接口对象
        blogMapper mapper = sqlSession.getMapper(blogMapper.class);
        // 实例化Blog实体类
        Blog blog = new Blog();

        // 设置第一条数据信息
        blog.setId(IDutils.getId());
        blog.setTitle("MyBatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        // 插入第一条数据
        mapper.addBlog(blog);

        // 设置第二条数据信息
        blog.setId(IDutils.getId());
        blog.setTitle("Java如此简单");
        // 插入第二条数据
        mapper.addBlog(blog);

        // 设置第三条数据信息
        blog.setId(IDutils.getId());
        blog.setTitle("Spring如此简单");
        // 插入第三条数据
        mapper.addBlog(blog);

        // 设置第四条数据信息
        blog.setId(IDutils.getId());
        blog.setTitle("微服务如此简单");
        // 插入第四条数据
        mapper.addBlog(blog);

        // 关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void testSelect1(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        blogMapper mapper = sqlSession.getMapper(blogMapper.class);

        Map map = new HashMap();
        /*map.put("title", "book1");*/
        map.put("author", "robin");

        List<Blog> blogs = mapper.queryBlogIF(map);
        System.out.println(blogs);
        sqlSession.close();
    }

    @Test
    public void testSelect2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        blogMapper mapper = sqlSession.getMapper(blogMapper.class);

        Map map = new HashMap();
        /*map.put("title", "book1");*/
        /*map.put("author", "robin");*/
        map.put("views", 999);

        List<Blog> blogs = mapper.queryBlogChoose(map);
        System.out.println(blogs);
        sqlSession.close();
    }

    @Test
    public void testSelect3(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        blogMapper mapper = sqlSession.getMapper(blogMapper.class);

        Map map = new HashMap();
        map.put("title", "book5");
        map.put("author", "yijian");
        map.put("id", "3216bd68c5254155a028f68cada02e62");

        int blogs = mapper.updateBlog(map);
        System.out.println(blogs);
        sqlSession.close();
    }

    @Test
    public void test4(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        blogMapper mapper = sqlSession.getMapper(blogMapper.class);
        Map map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        map.put("ids", ids);


        List<Blog> blogs = mapper.queryBlogByForeach(map);
        System.out.println(blogs);


        sqlSession.close();
    }
}
