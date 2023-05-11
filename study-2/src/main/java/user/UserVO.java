package user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {

	private long id;
	private String username, password, role;
	private int enabled;
	
}
