package nisum.java.test.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nisum.java.test.models.entity.Phone;
import nisum.java.test.models.entity.User;
import nisum.java.test.models.entity.request.CreateUserRequest;
import nisum.java.test.models.entity.request.PhoneRequest;
import nisum.java.test.models.exceptions.ExistingUserException;
import nisum.java.test.models.repository.IUserRepository;
import nisum.java.test.utils.JWTUtil;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepository;
	@Override
	public User CreateUser(CreateUserRequest Request) throws ExistingUserException {
		if(!ValidateExistingUser(Request.getEmail())) {
			throw new ExistingUserException("Ya existe usuario ingresado con el mail " + Request.getEmail());
		}else {
			User newUser = new User();
			newUser.setEmail(Request.getEmail());
			newUser.setIsactive(true);
			newUser.setName(Request.getName());
			newUser.setPassword(Request.getPassword());
			newUser.setPhones(addPhones(Request.getPhones()));
			newUser.setToken(JWTUtil.getJWTToken(Request.getName()));
			return userRepository.save(newUser);
		}
		
	}
	
	@Override
	public List<Phone> addPhones(List<PhoneRequest> PhoneList) {
		ArrayList<Phone> Phones = new ArrayList<Phone>();
		for (int i=0;i<PhoneList.size();i++) {
		      Phone phone = new Phone();
		      phone.setNumber(PhoneList.get(i).getNumber());
		      phone.setCountrycode(PhoneList.get(i).getCountrycode());
		      phone.setCitycode(PhoneList.get(i).getCitycode());
		      Phones.add(phone);
		    }
		return Phones;
	}
	@Override
	public Boolean ValidateExistingUser(String Email) {
		return userRepository.findByEmail(Email).isEmpty();
	}

}
