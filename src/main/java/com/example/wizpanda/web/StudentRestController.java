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
	
	
}