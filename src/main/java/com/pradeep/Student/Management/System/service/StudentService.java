package com.pradeep.Student.Management.System.service;

import java.util.List;

import com.pradeep.Student.Management.System.dto.StudentDTO;
import com.pradeep.Student.Management.System.exception.StudentException;

public interface StudentService {
	public Integer addStudent(StudentDTO studentDTO) throws StudentException;
	public List<StudentDTO> getStudentByName(String name)throws StudentException;
	public StudentDTO getStudentById(Integer studentId)throws StudentException;
	public List<StudentDTO> getAllStudents()throws StudentException;
	public void updateStudentDetails(StudentDTO studentDto)throws StudentException;
	public void deleteStudent(Integer studentId)throws StudentException;
}
