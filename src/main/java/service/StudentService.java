package service;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IStudentRepo;

import java.util.ArrayList;

public class StudentService implements IStudentService {
@Autowired
    IStudentRepo iStudentRepo;
    @Override
    public Student save(Student student) {
        return iStudentRepo.save(student);
    }

    @Override
    public Student findById(long id) {
       return iStudentRepo.findById(id).get();
    }

    @Override
    public ArrayList<Student> findAll() {
        return (ArrayList<Student>) iStudentRepo.findAll();
    }

    @Override
    public ArrayList<Student> findAllByName(String name) {
        return iStudentRepo.findAllByName(name);
    }

    @Override
    public void Delete(Student student) {
iStudentRepo.delete(student);
    }

    @Override
    public void edit(Student student) {
iStudentRepo.save(student);
    }
}
