package all.about.apartment.message.persistence;

import java.util.List;

import all.about.apartment.message.domain.MessageDTO;
import all.about.apartment.message.domain.MessageVO;

public interface MessageDAO {
	
	public void sendMessage(MessageDTO vo) throws Exception;
	
	public List<MessageVO> recieveMessage(String reciever) throws Exception; 
	
	//안읽은 메세지 갯수 
	public int newMsgCount(String reciever) throws Exception;
	
}
