package all.about.apartment.bid.domain;

public class BidListVO {
	
	private int list_id; //내역번호
	private int bid_id;  //상품번호
	private String list_bidder;  //입찰자
	private int list_price;   //입찰가
	private String list_date;  //입찰일
	private int list_priority;  //우선순위
	
	public BidListVO(){}
	
	public BidListVO(int list_id, int bid_id, String list_bidder, int list_price, String list_date, int list_priority) {
		super();
		this.list_id = list_id;
		this.bid_id = bid_id;
		this.list_bidder = list_bidder;
		this.list_price = list_price;
		this.list_date = list_date;
		this.list_priority = list_priority;
	}

	public int getList_id() {
		return list_id;
	}

	public void setList_id(int list_id) {
		this.list_id = list_id;
	}

	public int getBid_id() {
		return bid_id;
	}

	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}

	public String getList_bidder() {
		return list_bidder;
	}

	public void setList_bidder(String list_bidder) {
		this.list_bidder = list_bidder;
	}

	public int getList_price() {
		return list_price;
	}

	public void setList_price(int list_price) {
		this.list_price = list_price;
	}

	public String getList_date() {
		return list_date;
	}

	public void setList_date(String list_date) {
		this.list_date = list_date;
	}

	public int getList_priority() {
		return list_priority;
	}

	public void setList_priority(int list_priority) {
		this.list_priority = list_priority;
	}

	@Override
	public String toString() {
		return "BidList [list_id=" + list_id + ", bid_id=" + bid_id + ", list_bidder=" + list_bidder + ", list_price="
				+ list_price + ", list_date=" + list_date + ", list_priority=" + list_priority + "]";
	}
	
	
	
	
	

}
