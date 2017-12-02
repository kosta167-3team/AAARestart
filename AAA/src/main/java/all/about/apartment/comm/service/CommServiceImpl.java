package all.about.apartment.comm.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import all.about.apartment.comm.domain.Comm_board;
import all.about.apartment.comm.domain.Comm_user;
import all.about.apartment.comm.persistence.CommDAO;

@Service
public class CommServiceImpl implements CommService {

	@Inject
	CommDAO commDao;

	@Override
	public void insertUser(Comm_user user) throws Exception {

		commDao.insertUser(user);

	}

	@Override
	public void insertCommBoard(Comm_board board) throws Exception {

		commDao.insertCommBoard(board);

	}

}
