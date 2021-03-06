package all.about.apartment.comm.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.comm.domain.Comm_board;
import all.about.apartment.comm.domain.Comm_user;

@Repository
public class CommDAOImpl implements CommDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "all.about.apartment.mappers.CommMapper";

	@Override
	public void insertUser(Comm_user user) throws Exception {

		session.insert(namespace + ".insertUser", user);
	}

	@Override
	public void insertCommBoard(Comm_board board) throws Exception {

		session.insert(namespace + ".insertCommBoard", board);

	}

	@Override
	public Comm_user getUser(String r_id) throws Exception {
		 
		return session.selectOne(namespace+".getUser", r_id);
	}

	@Override
	public void deleteBoard(int cb_no) throws Exception {
		
		session.delete(namespace+".deleteBoard", cb_no);
	}

	@Override
	public int maxBoardNum() throws Exception {
		 
		return session.selectOne(namespace+".maxBoardNum");
	}

}
