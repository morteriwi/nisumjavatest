package nisum.java.test.models.services;

import java.util.List;

import nisum.java.test.models.entity.Phone;
import nisum.java.test.models.entity.User;
import nisum.java.test.models.entity.request.CreateUserRequest;
import nisum.java.test.models.entity.request.PhoneRequest;
import nisum.java.test.models.exceptions.ExistingUserException;

public interface IUserService {
	public User CreateUser(CreateUserRequest Request) throws ExistingUserException;
	public Boolean ValidateExistingUser(String Email);
	public List<Phone> addPhones(List<PhoneRequest> PhoneList);
}
