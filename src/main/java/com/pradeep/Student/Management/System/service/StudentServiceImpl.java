package com.pradeep.Student.Management.System.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pradeep.Student.Management.System.dto.StudentDTO;
import com.pradeep.Student.Management.System.exception.StudentException;

@Service
public class StudentServiceImpl implements StudentService {

	@Override
	public Integer addStudent(StudentDTO studentDTO) throws StudentException {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public List<StudentDTO> getStudentByName(String name) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDTO getStudentById(Integer studentId) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDTO> getAllStudents() throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudentDetails(StudentDTO studentDto) throws StudentException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudent(Integer studentId) throws StudentException {
		// TODO Auto-generated method stub

	}

}
