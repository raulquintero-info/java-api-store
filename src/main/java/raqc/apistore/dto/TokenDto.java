package raqc.apistore.dto;



public class TokenDto {

	private String token ;
	
	

	public TokenDto() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "TokenDto [token=" + token + "]";
	}
	
	
}
