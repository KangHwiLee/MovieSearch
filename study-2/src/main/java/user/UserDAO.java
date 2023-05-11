package user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import security.CustomUserDetails;

@Repository
public class UserDAO{

	@Autowired SqlSession sql;
	
	public CustomUserDetails getUserByUsername(String username) {
		System.out.println("여긴 와지지?");
		System.out.println(username);
		return sql.selectOne("study.mapper.getUserByUsername", username);
	}

}
