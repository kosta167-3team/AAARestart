package all.about.apartment.user.persistence;

import all.about.apartment.publicDomain.LoginDTO;
import all.about.apartment.publicDomain.ResidentVO;

public interface UserDAO {
	
	public ResidentVO login(LoginDTO dto) throws Exception;
}
