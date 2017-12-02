package all.about.apartment.message.service;

import java.util.List;

import all.about.apartment.message.domain.MessageVO;

public interface MessageService {
	
	public void sendMessage(MessageVO vo)throws Exception;
	
	public List<MessageVO> recieveMessage(String reciever) throws Exception;
}
