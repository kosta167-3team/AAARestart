package all.about.apartment.message.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.message.domain.MessageDTO;
import all.about.apartment.message.domain.MessageVO;
import all.about.apartment.publicDomain.Criteria;

@Repository
public class MessageDAOImpl implements MessageDAO {

	@Inject
	private SqlSession session;
	private static String namespace = "all.about.apartment.mappers.MessageMapper";
	
	
	public void sendMessage(MessageDTO dto) throws Exception {
		session.insert(namespace+".sendMessage", dto);
	}

	/*@Override
	public List<MessageVO> recieveMessage(String reciever,) throws Exception {
		return session.selectList(namespace+".recieveMessage", reciever);
	}*/


	@Override
	public int newMsgCount(String reciever) throws Exception {
		return session.selectOne(namespace+".newMsgCount", reciever);
	}

	@Override
	public void update_ck(int msg_id) throws Exception {
		session.update(namespace+".update_ck", msg_id);
	}
	//페이징 처리해서 글 목록 불러오기
	@Override
	public List<MessageVO> recieveMessage(String reciever,Criteria cri) throws Exception {
		return session.selectList(namespace+".recieveMessage", reciever, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}
	
	//총 쪽지 갯수
	@Override
	public int msgCnt(String receiver) throws Exception {
		return session.selectOne(namespace+".msgCnt", receiver);
	}

	@Override
	public List<MessageVO> recieveMessage(String reciever) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
