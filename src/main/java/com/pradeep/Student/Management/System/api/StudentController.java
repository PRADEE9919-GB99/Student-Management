package com.pradeep.Student.Management.System.api;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pradeep.Student.Management.System.dto.StudentDTO;
import com.pradeep.Student.Management.System.exception.StudentException;
import com.pradeep.Student.Management.System.service.StudentService;

public class StudentController {

	private StudentService studentService;

	public ResponseEntity<Integer> addStudent(StudentDTO studentDTO) throws StudentException {

		return null;
	}

	public ResponseEntity<StudentDTO> getStudentByName(String name) throws StudentException {

		return null;
	}

	public ResponseEntity<StudentDTO> getStudentById(Integer studentId) throws StudentException {

		return null;
	}

	public ResponseEntity<List<StudentDTO>> getAllStudents() throws StudentException {

		return null;
	}

	public ResponseEntity<Void> updateStudentDetails(StudentDTO studentDTO) throws StudentException {

		return null;
	}

	public ResponseEntity<Void> deleteStudent(Integer studentId) throws StudentException {

		return null;
	}

}
