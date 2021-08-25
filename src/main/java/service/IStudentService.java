package service;

import model.Student;

import java.util.ArrayList;

public interface IStudentService {
   Student save(Student student);

    Student findById(long id);

    ArrayList<Student> findAll();

    ArrayList<Student> findAllByName(String name);

    void Delete(Student account);

    void edit(Student account);
}
