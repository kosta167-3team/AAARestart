package all.about.apartment.user.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import all.about.apartment.publicDomain.LoginDTO;
import all.about.apartment.publicDomain.ResidentVO;
import all.about.apartment.user.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	UserDAO dao;
	
	@Override
	public ResidentVO login(LoginDTO dto) throws Exception {
		
		return dao.login(dto);
		
	}

}
