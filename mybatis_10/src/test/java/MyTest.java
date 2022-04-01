import com.robin.dao.UserMapper;
import com.robin.pojo.User;
import com.robin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class MyTest {

    // 通过id查询指定的用户信息
    @Test
    public void queryUserById2() {

        // 分别获取两个sqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        SqlSession sqlSession2 = MyBatisUtils.getSqlSession();

        // 获取第一个Mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 调用queryUserById方法，查询id为1的用户信息
        User user = mapper.queryUserById(1);
        // 打印用户信息
        System.out.println(user);
        // 关闭第一个sqlSession对象
        sqlSession.close();

        // 获取第二个Mapper接口对象
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        // 调用queryUserById方法，再次查询id为1的用户信息
        User user2 = mapper2.queryUserById(1);
        // 打印用户信息
        System.out.println(user2);
        // 判断两个用户信息是否相等
        System.out.println(user==user2);
        // 关闭第二个sqlSession对象
        sqlSession2.close();

    }

}
