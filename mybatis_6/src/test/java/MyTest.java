import com.robin.dao.StudentMapper;
import com.robin.dao.TeacherMapper;
import com.robin.pojo.Student;
import com.robin.pojo.Teacher;
import com.robin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
// obtain SQlSession object
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
// obtain Mapper Interface object
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
// adopt id Ask for teacher information
        Teacher teacher = mapper.getTeacher(1);
// Print the inquired teacher information
        System.out.println(teacher);
// close SQLSession object
        sqlSession.close();
    }

    @Test
    public void test1(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent2();
        for (Student student1 : student) {
            System.out.println(student1);
        }
        sqlSession.close();
    }
}
