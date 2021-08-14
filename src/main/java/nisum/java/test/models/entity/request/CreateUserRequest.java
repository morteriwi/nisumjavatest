package nisum.java.test.models.entity.request;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CreateUserRequest {
	@JsonProperty
	private String name;
	@JsonProperty
	@Email(message = "invalido")
	private String email;
	@JsonProperty
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9].*[0-9])(?=.*[a-z]).{4,}$", message="debe contener al menos una mayuscula, una minuscula y al menos dos numeros")
	private String password;
	private List<PhoneRequest> phones;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PhoneRequest> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneRequest> phones) {
		this.phones = phones;
	}

}
