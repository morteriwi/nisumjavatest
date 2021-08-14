package nisum.java.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nisum.java.test.models.entity.User;
import nisum.java.test.models.entity.request.CreateUserRequest;
import nisum.java.test.models.exceptions.ExistingUserException;
import nisum.java.test.models.services.IUserService;

@RestController
@RequestMapping("/api/user")
class UserController {
	
	@Autowired
	IUserService userService;
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public User CreateUser(@Valid @RequestBody CreateUserRequest request) throws ExistingUserException{
		return userService.CreateUser(request);
		
	}
	
}
