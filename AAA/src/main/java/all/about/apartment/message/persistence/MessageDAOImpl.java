package all.about.apartment.message.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.message.domain.MessageDTO;
import all.about.apartment.message.domain.MessageVO;
import all.about.apartment.publicDomain.Criteria;
import all.about.apartment.publicDomain.SearchCriteria;

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
	public List<MessageVO> recieveMessage(
			String reciever,String r_authority,SearchCriteria cri) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		map.put("receiver", reciever);
		map.put("r_authority",  "%"+r_authority+"%");
		map.put("keyword",cri.getKeyword());
		map.put("searchType",cri.getSearchType());
		
		return session.selectList(namespace+".recieveMessage", map, 
				new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}
	
	@Override
	public int msgCnt(String receiver,String r_authority,SearchCriteria cri) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		map.put("receiver", receiver);
		
		map.put("keyword",cri.getKeyword());
		map.put("searchType",cri.getSearchType());
		map.put("r_authority", "%"+r_authority+"%");
		
		return session.selectOne(namespace+".msgCnt", map);
	}

	@Override
	public List<MessageVO> recieveMessage(String reciever) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}











