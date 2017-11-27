package all.about.apartment.user.service;

import all.about.apartment.publicDomain.LoginDTO;
import all.about.apartment.publicDomain.ResidentVO;

public interface UserService {
	
	public ResidentVO login(LoginDTO dto) throws Exception;
}
