package user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import security.CustomUserDetails;

@Service
public class UserServiceImpl implements UserService{

	@Autowired private UserDAO dao;
	
	@Override
	public CustomUserDetails getUserByUsername(String username) {
		return dao.getUserByUsername(username);
	}

	
}
