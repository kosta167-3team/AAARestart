package all.about.apartment.bid.domain;

public class BidPenalty {
	private int penalty_id;
	private int bid_id;
	
	public BidPenalty(){}
	
	public BidPenalty(int penalty_id, int bid_id) {
		super();
		this.penalty_id = penalty_id;
		this.bid_id = bid_id;
	}

	public int getPenalty_id() {
		return penalty_id;
	}

	public void setPenalty_id(int penalty_id) {
		this.penalty_id = penalty_id;
	}

	public int getBid_id() {
		return bid_id;
	}

	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}

	@Override
	public String toString() {
		return "BidPenalty [penalty_id=" + penalty_id + ", bid_id=" + bid_id + "]";
	}
	
	
	
	
}
