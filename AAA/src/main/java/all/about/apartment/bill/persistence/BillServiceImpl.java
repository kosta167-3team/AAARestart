package all.about.apartment.bill.persistence;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import all.about.apartment.bill.domain.Personal_mgmt_exVO;
import all.about.apartment.bill.domain.SetMonthBill;

@Service
public class BillServiceImpl implements BillService {
	
	@Inject
	private BillDAO dao;
	
	@Override
	public List<Personal_mgmt_exVO> getPersonal_mgmt_exList() throws Exception {
		
		return dao.getPersonal_mgmt_exList();
	}
	@Override
	public Personal_mgmt_exVO getMonthBill(String u_id, String p_month) throws Exception {		
		
		return dao.monthBill(new SetMonthBill(u_id,p_month));
	}




}
