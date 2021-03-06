package all.about.apartment.message.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import all.about.apartment.message.domain.MessageDTO;
import all.about.apartment.message.domain.MessageVO;
import all.about.apartment.message.persistence.MessageDAO;
import all.about.apartment.publicDomain.Criteria;
import all.about.apartment.publicDomain.SearchCriteria;

@Service
public class MessageServiceImpl implements MessageService {

	@Inject
	MessageDAO dao;
	
	//메세지 전송(insert)
	@Override
	public void sendMessage(MessageDTO dto) throws Exception {
		dao.sendMessage(dto);
	}

	//받은 메세지 Criteria 객체 포함
	@Override
	public List<MessageVO> recieveMessage(String reciever,String r_authority,SearchCriteria cri) throws Exception {
		return dao.recieveMessage(reciever,r_authority,cri);
	}

	@Override
	public void update_ck(int msg_id) throws Exception {
		dao.update_ck(msg_id);
	}

	@Override
	public int msgCnt(String receiver,String r_authority,SearchCriteria cri) throws Exception {
		return dao.msgCnt(receiver,r_authority,cri);
	}

	@Override
	public int newMsgCount(String reciever) throws Exception {
		return dao.newMsgCount(reciever);
	}
}
