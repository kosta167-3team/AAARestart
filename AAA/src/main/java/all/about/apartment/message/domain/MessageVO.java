package all.about.apartment.message.domain;

public class MessageVO {
	int msg_id;
	String msg_content;
	String msg_regdate;
	char read_check;
	String sender;
	String receiver;
	int type_id;

	private String r_authority;
	
	public String getMsg_content() {
		return msg_content;
	}
	public int getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public String getMsg_regdate() {
		return msg_regdate;
	}
	public void setMsg_regdate(String msg_regdate) {
		this.msg_regdate = msg_regdate;
	}
	public char getRead_check() {
		return read_check;
	}
	public void setRead_check(char read_check) {
		this.read_check = read_check;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	@Override
	public String toString() {
		return "MessageVO [msg_id=" + msg_id + ", msg_content=" + msg_content + ", msg_regdate=" + msg_regdate
				+ ", read_check=" + read_check + ", sender=" + sender + ", receiver=" + receiver + ", type_id="
				+ type_id + ", r_authority=" + r_authority + "]";
	}
	
	
	
}
