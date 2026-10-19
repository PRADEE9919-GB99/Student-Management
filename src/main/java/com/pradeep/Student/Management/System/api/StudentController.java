package com.pradeep.Student.Management.System.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.Student.Management.System.dto.StudentDTO;
import com.pradeep.Student.Management.System.exception.StudentException;
import com.pradeep.Student.Management.System.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping
	public ResponseEntity<Integer> addStudent(@RequestBody StudentDTO studentDTO) throws StudentException {

		Integer studentId = studentService.addStudent(studentDTO);

		return ResponseEntity.status(HttpStatus.CREATED).body(studentId);
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
