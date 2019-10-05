package com.dc.studenttab.dao.repository;

import com.dc.studenttab.dao.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
