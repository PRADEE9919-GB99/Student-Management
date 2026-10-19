package com.pradeep.Student.Management.System.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pradeep.Student.Management.System.dto.StudentDTO;
import com.pradeep.Student.Management.System.entity.Student;
import com.pradeep.Student.Management.System.exception.StudentException;
import com.pradeep.Student.Management.System.repository.StudentRepository;
import com.pradeep.Student.Management.System.utility.StudentUtil;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;
	private final StudentUtil studentUtil;

	public StudentServiceImpl(StudentRepository studentRepository, StudentUtil studentUtil) {
		this.studentRepository = studentRepository;
		this.studentUtil = studentUtil;
	}

	@Override
	public Integer addStudent(StudentDTO studentDTO) throws StudentException {
		Student student = studentUtil.convertToEntity(studentDTO);

		Student savedStudent = studentRepository.save(student);

		return savedStudent.getStudentId();
	}

	@Override
	public List<StudentDTO> getStudentByName(String name) throws StudentException {
		// TODO Auto-generated method stub
		List<Student> students = studentRepository.findByStudentName(name);

		List<StudentDTO> studentDTOs = new ArrayList<>();

		for (Student student : students) {
			studentDTOs.add(studentUtil.convertToDTO(student));
		}

		return studentDTOs;
	}

	@Override
	public StudentDTO getStudentById(Integer studentId) throws StudentException {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentException("Student not found with ID: " + studentId));

		return studentUtil.convertToDTO(student);
	}

	@Override
	public List<StudentDTO> getAllStudents() throws StudentException {
		// TODO Auto-generated method stub
		List<Student> students = (List<Student>) studentRepository.findAll();

		List<StudentDTO> studentDTOs = new ArrayList<>();

		for (Student student : students) {
			studentDTOs.add(studentUtil.convertToDTO(student));
		}

		return studentDTOs;
	}

	@Override
	public void updateStudentDetails(Integer studentId, StudentDTO studentDto) throws StudentException {
		// TODO Auto-generated method stub
		Student existingStudent = studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentException("Student not found with ID: " + studentDto.getStudentId()));

		existingStudent.setStudentName(studentDto.getStudentName());
		existingStudent.setEmail(studentDto.getEmail());
		existingStudent.setAge(studentDto.getAge());
		existingStudent.setGender(studentDto.getGender());

		studentRepository.save(existingStudent);
	}

	@Override
	public void deleteStudent(Integer studentId) throws StudentException {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentException("Student not found with ID: " + studentId));

		studentRepository.delete(student);
	}

}
