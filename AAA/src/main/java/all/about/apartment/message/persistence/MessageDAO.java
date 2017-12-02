package all.about.apartment.message.persistence;

import java.util.List;

import all.about.apartment.message.domain.MessageVO;

public interface MessageDAO {
	
	public void sendMessage(MessageVO vo) throws Exception;
	
	public List<MessageVO> recieveMessage(String reciever) throws Exception; 
}
