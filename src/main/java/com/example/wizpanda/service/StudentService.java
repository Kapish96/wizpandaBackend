package com.example.wizpanda.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wizpanda.dao.StudentDao;
import com.example.wizpanda.domain.Student;
import com.example.wizpanda.domain.StudentVO;

@Service
public class StudentService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

	private StudentDao studentDao;

	@Autowired
	StudentService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Transactional
	public void createStudent(StudentVO studentVO) {

		LOGGER.info("Creating account");
		Student student = new Student().builder().name(studentVO.getName()).email(studentVO.getEmail())
				.number(studentVO.getNumber()).password(studentVO.getPassword()).build();

		studentDao.saveStudent(student);
		LOGGER.info("Account Created Successfully");
	}

	public String validateLogin(StudentVO studentVO) {

		LOGGER.info("Validing User with email: {}",studentVO.getEmail());
		Map<String, Student> studentMap = studentDao.getStudents().stream()
				.collect(Collectors.toMap(Student::getEmail, Function.identity()));
		if (studentMap.containsKey(studentVO.getEmail())) {
			if (!studentMap.get(studentVO.getEmail()).getPassword().equals(studentVO.getPassword()))
				throw new RuntimeException("Email or Password is wrong");
		} else {
			throw new RuntimeException("Email doesn't exist");
		}
		LOGGER.info("User Validated Successfully");
		return studentMap.get(studentVO.getEmail()).getName();
		
	}

	public List<StudentVO> getAllStudentsList() {
		
		LOGGER.info("Fetching all accounts");
		List<Student> studentsList = studentDao.getStudents();
		List<StudentVO> studentVOList = studentsList.stream().map(s -> {

			StudentVO studentVO = StudentVO.builder().name(s.getName()).email(s.getEmail()).number(s.getNumber())
					.build();
			return studentVO;

		}).collect(Collectors.toList());
		return studentVOList;
	}
}