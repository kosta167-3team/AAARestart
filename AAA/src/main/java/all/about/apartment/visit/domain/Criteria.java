package all.about.apartment.visit.domain;

public class Criteria {

  private int page;
  private int perPageNum;
  private String r_id;

  public String getR_id() {
	return r_id;
}

public void setR_id(String r_id) {
	this.r_id = r_id;
}

public Criteria() {
    this.page = 1;
    this.perPageNum = 10;
  }

  public void setPage(int page) {

    if (page <= 0) {
      this.page = 1;
      return;
    }

    this.page = page;
  }

  public void setPerPageNum(int perPageNum) {

    if (perPageNum <= 0 || perPageNum > 100) {
      this.perPageNum = 10;
      return;
    }

    this.perPageNum = perPageNum;
  }

  public int getPage() {
    return page;
  }

  // method for MyBatis SQL Mapper -
  public int getPageStart() {

    return (this.page - 1) * perPageNum;
  }

  // method for MyBatis SQL Mapper
  public int getPerPageNum() {

    return this.perPageNum;
  }

@Override
public String toString() {
	return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", r_id=" + r_id + "]";
}


}
