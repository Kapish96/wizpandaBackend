package com.example.wizpanda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.wizpanda.domain.Student;
import com.example.wizpanda.repository.StudentRepository;

@Component
public class StudentDao {

	private StudentRepository studentRepository;
	
	@Autowired
	StudentDao(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
	}
	
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}
	
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
}
