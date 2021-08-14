package nisum.java.test.models.entity.request;

public class PhoneRequest {
	private Integer number;
	private Integer citycode;
	private Integer countrycode;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getCitycode() {
		return citycode;
	}

	public void setCitycode(Integer citycode) {
		this.citycode = citycode;
	}

	public Integer getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(Integer contrycode) {
		this.countrycode = contrycode;
	}
}
