package all.about.apartment.comm.persistence;

import all.about.apartment.comm.domain.Comm_board;
import all.about.apartment.comm.domain.Comm_user;

public interface CommDAO {

	public void insertUser (Comm_user user) throws Exception;
	
	public void insertCommBoard (Comm_board board) throws Exception;
}
