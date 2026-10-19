package com.pradeep.Student.Management.System.utility;

import org.springframework.stereotype.Component;

import com.pradeep.Student.Management.System.dto.StudentDTO;
import com.pradeep.Student.Management.System.entity.Student;

@Component
public class StudentUtil {
	public StudentDTO convertToDTO(Student student) {
		StudentDTO dto = new StudentDTO();
		dto.setStudentId(student.getStudentId());
		dto.setStudentName(student.getStudentName());
		dto.setEmail(student.getEmail());
		dto.setAge(student.getAge());
		dto.setGender(student.getGender());
		return dto;
	}

	public Student convertToEntity(StudentDTO dto) {
		Student student = new Student();
		student.setStudentId(dto.getStudentId());
		student.setStudentName(dto.getStudentName());
		student.setEmail(dto.getEmail());
		student.setAge(dto.getAge());
		student.setGender(dto.getGender());
		return student;
	}

}
