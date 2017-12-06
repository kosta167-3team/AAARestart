package all.about.apartment.message.persistence;

import java.util.List;

import all.about.apartment.message.domain.MessageDTO;
import all.about.apartment.message.domain.MessageVO;
import all.about.apartment.publicDomain.Criteria;
import all.about.apartment.publicDomain.SearchCriteria;

public interface MessageDAO {
	
	public void sendMessage(MessageDTO dto) throws Exception;
	

	//public List<MessageVO> recieveMessage(String reciever) throws Exception; 
	public List<MessageVO> recieveMessage(String reciever,String r_authority,SearchCriteria cri) throws Exception; 
	
	//안읽은 메세지 갯수 
	public int newMsgCount(String reciever) throws Exception;
	
	//읽은 메세지 처리
	public void update_ck(int msg_id) throws Exception;
	
	//메세지 총 갯수
	public int msgCnt(String receiver,String r_authority,SearchCriteria cri) throws Exception;

}
