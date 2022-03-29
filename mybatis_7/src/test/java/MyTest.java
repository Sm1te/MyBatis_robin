import com.robin.dao.StudentMapper;
import com.robin.dao.TeacherMapper;
import com.robin.pojo.Student;
import com.robin.pojo.Teacher;
import com.robin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class MyTest {

    @Test
    public void getTeacher() {
        // 获取sqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 获取TeacherMapper接口(实质是通过反射)
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        // 获取查询的教师信息集合
        List<Teacher> teachers = mapper.getTeacher();
        // 使用foreach循环遍历教师信息集合
        for (Teacher teacher : teachers) {
            // 打印教师信息
            System.out.println(teacher);
        }
        // 下面是以上几行代码的简写形式, 但是并不建议这样写
/*
for (Teacher teacher : sqlSession.getMapper(TeacherMapper.class).getTeacher()) {
            System.out.println(teacher);
        }
        */
        // 关闭sqlSession对象
        sqlSession.close();
    }

}
