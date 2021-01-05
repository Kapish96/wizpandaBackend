package com.example.wizpanda.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.wizpanda.domain.StudentVO;
import com.example.wizpanda.service.StudentService;

@RestController
public class StudentRestController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/student/create", method = RequestMethod.POST)
	public ResponseEntity<String> createStudent(@RequestBody StudentVO studentVO) {
		try {
			studentService.createStudent(studentVO);
			return new ResponseEntity<>("Successfully SignedUp", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/students")
	public List<StudentVO> getAllStudent() {

		return studentService.getAllStudentsList();

	}

}
