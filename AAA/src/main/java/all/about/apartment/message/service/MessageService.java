package all.about.apartment.message.service;

import java.util.List;

import all.about.apartment.message.domain.MessageVO;
import all.about.apartment.publicDomain.Criteria;

public interface MessageService {
	
	public void sendMessage(MessageVO vo)throws Exception;
	

	public List<MessageVO> recieveMessage(String reciever,Criteria cri) throws Exception;
	
	//안읽은 메세지 갯수 
	public int newMsgCount(String reciever) throws Exception;
	
	//읽은 메세지 처리
	public void update_ck(int msg_id) throws Exception ;
	
	//쪽지 총 갯수
	public int msgCnt(String receiver) throws Exception;
}
