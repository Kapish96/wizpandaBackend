package com.example.wizpanda.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wizpanda.dao.StudentDao;
import com.example.wizpanda.domain.Student;
import com.example.wizpanda.domain.StudentVO;

@Service
public class StudentService {
	
	private StudentDao studentDao;
	
	@Autowired
	StudentService(StudentDao studentDao){
		this.studentDao = studentDao;
	}
	
	@Transactional
	public void createStudent(StudentVO studentVO) {
		Student student = new Student().builder()
				.name(studentVO.getName())
				.email(studentVO.getEmail())
				.number(studentVO.getNumber())
				.password(studentVO.getPassword())
				.build();
		
		studentDao.saveStudent(student);
	}
	
}