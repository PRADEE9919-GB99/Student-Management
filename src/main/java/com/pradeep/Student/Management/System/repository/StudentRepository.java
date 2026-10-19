package com.pradeep.Student.Management.System.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pradeep.Student.Management.System.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	public List<Student> findByStudentName(String name);
}
