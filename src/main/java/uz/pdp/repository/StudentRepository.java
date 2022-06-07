package uz.pdp.repository;

import uz.pdp.entity.Student;

import java.util.List;

public interface StudentRepository {
    public int create(Student student);

    public List<Student> read();

    public Student findStudentById(int studentId);
public Student findStudentByEmail(String studentEmail);
public Student findStudentByCourse(String studentCourse );
    public int update(Student student);

    public int delete(int studentId);




}
