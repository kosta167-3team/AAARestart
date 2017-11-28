package all.about.apartment.bill.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import all.about.apartment.bill.domain.EnergyVO;
import all.about.apartment.bill.domain.Personal_mgmt_exVO;
import all.about.apartment.bill.domain.SaleBillVO;
import all.about.apartment.bill.domain.SetEnergyAVG;
import all.about.apartment.bill.domain.SetMonthBill;
import all.about.apartment.bill.persistence.BillDAO;

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
	@Override
	public List<SaleBillVO> getSaleBill(Integer input_num) throws Exception {
		
		return dao.getSaleBill(input_num);
	}
	@Override
	public List<EnergyVO> getEnergyList(String u_id, String p_month) throws Exception {
		
		return dao.getEnergyList(new SetMonthBill(u_id, p_month) );
	}
	@Override
	public List<Personal_mgmt_exVO> getSelectDetail(String u_id, String p_month) throws Exception {
		
		String[] a_pMonth = p_month.split("-");
		/* 20%%-01 와 같은 포멧을 만들기 위해서 */
		String year = "20%%";// sql 적용을 위한 
		String month = a_pMonth[1]; // 월 부분 가져오기
		
		
		return dao.getSelectDetail(new SetMonthBill(u_id, year+"-"+month));
	}
	@Override
	public List<EnergyVO> getYearEnergy(String u_id, String p_month) throws Exception {
		
		return dao.getYearEnergy(new SetMonthBill(u_id, p_month));
	}
	@Override
	public int getElecAVG(String energyName, String p_month, int width) throws Exception {
		
		return dao.getElecAVG(new SetEnergyAVG(energyName,p_month, width));
	}




}
