package user;

import security.CustomUserDetails;

public interface UserService {

	CustomUserDetails getUserByUsername(String username);
	
}
