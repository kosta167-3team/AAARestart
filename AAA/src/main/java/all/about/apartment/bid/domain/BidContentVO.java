package all.about.apartment.bid.domain;

public class BidContentVO {

	private int content_id;
	private int bid_id;
	private String content_filename;
	
	
	public BidContentVO(){}


	public int getContent_id() {
		return content_id;
	}


	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}


	public int getBid_id() {
		return bid_id;
	}


	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}


	public String getContent_filename() {
		return content_filename;
	}


	public void setContent_filename(String content_filename) {
		this.content_filename = content_filename;
	}


	public BidContentVO(int content_id, int bid_id, String content_filename) {
		super();
		this.content_id = content_id;
		this.bid_id = bid_id;
		this.content_filename = content_filename;
	}
	
	
	

	
	
}
