package com.ssafy.house.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.dto.MemberDto;
import com.ssafy.house.service.UserService;

import io.swagger.annotations.Api;

//@RestController
//@RequestMapping("/admin")
//@CrossOrigin("*")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
@Api(value="house", description="Happy house")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/admin/user")
	public ResponseEntity<List<MemberDto>> userList() {
		logger.debug("사용자 목록 표시.........");
		
		List<MemberDto> list = userService.userList();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(value = "/admin/user")
	public ResponseEntity<List<MemberDto>> userRegister(@RequestBody MemberDto memberDto) {
		boolean total = userService.userRegister(memberDto);
		if(total) {
			List<MemberDto> list = userService.userList();
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
		} else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/admin/user/{userid}")
	public ResponseEntity<MemberDto> userInfo(@PathVariable("userid") String userid) {
		logger.debug("파라미터 : {}", userid);
		MemberDto memberDto = userService.userInfo(userid);
		if(memberDto != null)
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "/admin/user")
	public ResponseEntity<List<MemberDto>> userModify(@RequestBody MemberDto memberDto) {
		userService.userModify(memberDto);
		List<MemberDto> list = userService.userList();
		return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/admin/user/{userid}")
	public ResponseEntity<List<MemberDto>> userDelete(@PathVariable("userid") String userid) {
		userService.userDelete(userid);
		List<MemberDto> list = userService.userList();
		return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
	}
	
}
