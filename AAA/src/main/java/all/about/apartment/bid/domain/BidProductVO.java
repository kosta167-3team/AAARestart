package all.about.apartment.bid.domain;

import java.util.Arrays;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class BidProductVO {
	private int bid_id;

	private String bid_seller;
	
	@NotEmpty(message="입력하세요")
	private String bid_name;

	private int bid_start;
	private String bid_date;
	private int bid_time;
	private int bid_nowprice;
	private String bid_bidder; //입찰자
	
	@Size(min=10,message="10자 이상 입력하세요")
	private String bid_content;
	
	private String bid_evaluation;
	private String bid_filename;
	private int addTime;
	private String bid_state;
	
	public String getBid_state() {
		return bid_state;
	}
	public void setBid_state(String bid_state) {
		this.bid_state = bid_state;
	}
	public int getBid_id() {
		return bid_id;
	}
	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}
	public String getBid_seller() {
		return bid_seller;
	}
	public void setBid_seller(String bid_seller) {
		this.bid_seller = bid_seller;
	}
	public String getBid_name() {
		return bid_name;
	}
	public void setBid_name(String bid_name) {
		this.bid_name = bid_name;
	}
	public int getBid_start() {
		return bid_start;
	}
	public void setBid_start(int bid_start) {
		this.bid_start = bid_start;
	}
	public String getBid_date() {
		return bid_date;
	}
	public void setBid_date(String bid_date) {
		this.bid_date = bid_date;
	}
	public int getBid_time() {
		return bid_time;
	}
	public void setBid_time(int bid_time) {
		this.bid_time = bid_time;
	}
	public int getBid_nowprice() {
		return bid_nowprice;
	}
	public void setBid_nowprice(int bid_nowprice) {
		this.bid_nowprice = bid_nowprice;
	}
	public String getBid_bidder() {
		return bid_bidder;
	}
	public void setBid_bidder(String bid_bidder) {
		this.bid_bidder = bid_bidder;
	}
	public String getBid_content() {
		return bid_content;
	}
	public void setBid_content(String bid_content) {
		this.bid_content = bid_content;
	}
	public String getBid_evaluation() {
		return bid_evaluation;
	}
	public void setBid_evaluation(String bid_evaluation) {
		this.bid_evaluation = bid_evaluation;
	}
	public String getBid_filename() {
		return bid_filename;
	}
	public void setBid_filename(String bid_filename) {
		this.bid_filename = bid_filename;
	}
	public int getAddTime() {
		return addTime;
	}
	public void setAddTime(int addTime) {
		this.addTime = addTime;
	}
	@Override
	public String toString() {
		return "BidProductVO [bid_id=" + bid_id + ", bid_seller=" + bid_seller + ", bid_name=" + bid_name
				+ ", bid_start=" + bid_start + ", bid_date=" + bid_date + ", bid_time=" + bid_time + ", bid_nowprice="
				+ bid_nowprice + ", bid_bidder=" + bid_bidder + ", bid_content=" + bid_content + ", bid_evaluation="
				+ bid_evaluation + ", bid_filename=" + bid_filename + ", addTime=" + addTime + ", bid_state="
				+ bid_state + "]";
	}	
}
