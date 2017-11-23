package all.about.apartment.bill.persistence;

import java.util.List;

import all.about.apartment.bill.domain.Personal_mgmt_ex;


public interface BillDAO {
	public List<Personal_mgmt_ex> getPersonal_mgmt_ex()throws Exception;
}
