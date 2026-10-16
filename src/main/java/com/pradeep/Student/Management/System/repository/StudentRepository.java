package com.pradeep.Student.Management.System.repository;

import org.springframework.data.repository.CrudRepository;

import com.pradeep.Student.Management.System.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
