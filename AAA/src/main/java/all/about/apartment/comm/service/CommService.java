package all.about.apartment.comm.service;

import all.about.apartment.comm.domain.Comm_board;
import all.about.apartment.comm.domain.Comm_user;

public interface CommService {

	public void insertUser (Comm_user user) throws Exception;
	
	public void insertCommBoard (Comm_board board) throws Exception;
	
	public int maxBoardNum () throws Exception;
	
	public Comm_user getUser (String r_id) throws Exception;
	
	public void deleteBoard (int cb_no) throws Exception;
	 
}
