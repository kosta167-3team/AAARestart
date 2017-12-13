package all.about.apartment.complain.domain;

import java.sql.Date;

public class ComplainDTO {
	private Integer comp_no;
	private String comp_target;
	private String comp_content;
	private Date comp_regdate;
	private String disclosure_status;
	private String comp_status;
	private String comp_writer;
	private Integer type_id;
	private Integer comp_viewCnt;
	public Integer getComp_no() {
		return comp_no;
	}
	
	public void setComp_no(Integer comp_no) {
		this.comp_no = comp_no;
	}
	public String getComp_target() {
		return comp_target;
	}
	public void setComp_target(String comp_target) {
		this.comp_target = comp_target;
	}
	public String getComp_content() {
		return comp_content;
	}
	public void setComp_content(String comp_content) {
		this.comp_content = comp_content;
	}
	public Date getComp_regdate() {
		return comp_regdate;
	}
	public void setComp_regdate(Date comp_regdate) {
		this.comp_regdate = comp_regdate;
	}
	public String getDisclosure_status() {
		return disclosure_status;
	}
	public void setDisclosure_status(String disclosure_status) {
		this.disclosure_status = disclosure_status;
	}
	public String getComp_status() {
		return comp_status;
	}
	public void setComp_status(String comp_status) {
		this.comp_status = comp_status;
	}
	public String getComp_writer() {
		return comp_writer;
	}
	public void setComp_writer(String comp_writer) {
		this.comp_writer = comp_writer;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public Integer getComp_viewCnt() {
		return comp_viewCnt;
	}
	public void setComp_viewCnt(Integer comp_viewCnt) {
		this.comp_viewCnt = comp_viewCnt;
	}
	@Override
	public String toString() {
		return "ComplainDTO [comp_no=" + comp_no + ", comp_target=" + comp_target + ", comp_content=" + comp_content
				+ ", comp_regdate=" + comp_regdate + ", disclosure_status=" + disclosure_status + ", comp_status="
				+ comp_status + ", comp_writer=" + comp_writer + ", type_id=" + type_id + ", comp_viewCnt="
				+ comp_viewCnt + "]";
	}
	
	
}
