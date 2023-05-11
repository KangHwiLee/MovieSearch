package security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Model.user;
import repository.MemberRepository;

@Service
public class UserDetail implements UserDetailsService{
	
	@Autowired MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		member member = memberRepository.findByusername(username).orElseThrow(() -> 
//							new IllegalArgumentException("존재하지 않는 유저입니다."));
		user member = memberRepository.findByusername(username).orElseThrow(() -> 
		new IllegalArgumentException("존재하지 않는 유저입니다."));
		
//		CustomUserDetails customUserDetails = new CustomUserDetails();
//			return customUserDetails;
			return new User(member.getUsername(), member.getPassword(), Arrays.asList(new SimpleGrantedAuthority(member.getRole())));
	}

}