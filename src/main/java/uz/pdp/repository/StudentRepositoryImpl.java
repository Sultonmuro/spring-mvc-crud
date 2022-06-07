package uz.pdp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import uz.pdp.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{

//    Bazaga ulanish xosil qilib beradigan
    @Autowired
    JdbcTemplate jdbcTemplate;

    public StudentRepositoryImpl(DriverManagerDataSource dataSource) {
    }

    @Override
    public int create(Student student) {
        try{
            return jdbcTemplate.update("insert into student(name,email,course) values (?,?,?)",
                    student.getName(), student.getEmail(), student.getCourse());
        }catch (Exception e){
            return 0;
        }

    }

    @Override
    public List<Student> read() {
        return  jdbcTemplate.query("select * from student", BeanPropertyRowMapper.newInstance(Student.class));

    }

    @Override
    public Student findStudentById(int studentId) {


        Student student = jdbcTemplate.queryForObject("select * from student where id = ?",BeanPropertyRowMapper.newInstance(Student.class));
        return student;
        }

    @Override
    public Student findStudentByEmail(String studentEmail) {
        Student student = jdbcTemplate.queryForObject("select * from student where email = ?",BeanPropertyRowMapper.newInstance(Student.class));
        return student;
    }

    @Override
    public Student findStudentByCourse(String studentCourse) {
        Student student = jdbcTemplate.queryForObject("select * from student where course = ?",BeanPropertyRowMapper.newInstance(Student.class));
        return student;
    }


    @Override
    public int update(Student student) {
         return jdbcTemplate.update("update student set name = ? , email = ? , course = ? where id = ? ",student.getName(),student.getEmail(),student.getCourse());
    }

    @Override
    public int delete(int studentId) {
        return jdbcTemplate.update("delete from student where id = ?",BeanPropertyRowMapper.newInstance(Student.class));
    }
}
