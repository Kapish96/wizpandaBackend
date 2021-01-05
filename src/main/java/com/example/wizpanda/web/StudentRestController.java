package com.example.wizpanda.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody StudentVO studentVO) {
		try {
			studentService.validateLogin(studentVO);
			return new ResponseEntity<>("Successfully Login", HttpStatus.OK);
		} catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@RequestMapping(value = "/student/create", method = RequestMethod.POST)
	public ResponseEntity<String> createStudent(@RequestBody StudentVO studentVO) {
		try {
			studentService.createStudent(studentVO);
			return new ResponseEntity<>("Successfully SignedUp", HttpStatus.OK);
		} catch(DataIntegrityViolationException e) {
			return new ResponseEntity<>("Email Already Exist or Mobile Number too long", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>("Error while creating account", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/students")
	public List<StudentVO> getAllStudent() {

		return studentService.getAllStudentsList();

	}

}
