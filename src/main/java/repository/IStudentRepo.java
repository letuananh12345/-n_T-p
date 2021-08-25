package repository;

import model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IStudentRepo extends CrudRepository<Student,Long> {
    @Query(value = "SELECT a FROM Student as a where a.name like concat('%',:name,'%')")
    public ArrayList<Student> findAllByName(@Param("name") String userName);
}
