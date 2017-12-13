package all.about.apartment.bill.service;

import java.util.List;

import all.about.apartment.bill.domain.EnergyVO;
import all.about.apartment.bill.domain.Personal_mgmt_exVO;
import all.about.apartment.bill.domain.SaleBillVO;
import all.about.apartment.bill.domain.ScorePMEVO;
import all.about.apartment.bill.domain.SetMonthBill;

public interface BillService {
	
	public List<Personal_mgmt_exVO> getPersonal_mgmt_exList() throws Exception;
	public Personal_mgmt_exVO getMonthBill(String u_id , String p_month) throws Exception;
	public List<SaleBillVO> getSaleBill(Integer input_num) throws Exception;
	public List<EnergyVO> getEnergyList(String u_id, String p_month) throws Exception;
	public List<Personal_mgmt_exVO> getSelectDetail(String u_id, String p_month) throws Exception;
	public List<EnergyVO> getYearEnergy(String u_id, String p_month) throws Exception;
	public int getElecAVG(String energyName,String p_month, int width) throws Exception;
	public List<ScorePMEVO> getElecList() throws Exception;
	public List<ScorePMEVO> getHeatList() throws Exception;
	public int getScoreNum(String energyName) throws Exception;
	public List<ScorePMEVO> getSelectEnergyList(String energyName) throws Exception;
	public double getAVGelecMonth(SetMonthBill setMonthBill) throws Exception;
}
