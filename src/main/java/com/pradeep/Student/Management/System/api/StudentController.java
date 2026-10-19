package com.pradeep.Student.Management.System.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/name/{name}")
	public ResponseEntity<List<StudentDTO>> getStudentByName(@PathVariable String name) throws StudentException {

		List<StudentDTO> students = studentService.getStudentByName(name);

		return ResponseEntity.ok(students);
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable Integer studentId) throws StudentException {

		StudentDTO student = studentService.getStudentById(studentId);

		return ResponseEntity.ok(student);
	}

	@GetMapping
	public ResponseEntity<List<StudentDTO>> getAllStudents() throws StudentException {

		List<StudentDTO> students = studentService.getAllStudents();

		return ResponseEntity.ok(students);
	}

	@PutMapping("/{studentId}")
	public ResponseEntity<Void> updateStudentDetails(@PathVariable Integer studentId,
			@RequestBody StudentDTO studentDTO) throws StudentException {
		studentService.updateStudentDetails(studentId, studentDTO);

		return ResponseEntity.noContent().build();
	}

	public ResponseEntity<Void> deleteStudent(Integer studentId) throws StudentException {

		return null;
	}

}
