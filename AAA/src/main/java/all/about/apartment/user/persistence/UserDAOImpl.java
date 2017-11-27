package all.about.apartment.user.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.publicDomain.LoginDTO;
import all.about.apartment.publicDomain.ResidentVO;

@Repository
public class UserDAOImpl implements UserDAO{

	@Inject
	private SqlSession session;
	 private static String namespace = "all.about.apartment.mappers.UserMapper";
	 
	@Override
	public ResidentVO login(LoginDTO dto) throws Exception {
		
		return session.selectOne(namespace+".login", dto);
	}

}
