package all.about.apartment.bill.persistence;

import java.util.List;

import all.about.apartment.bill.domain.EnergyVO;
import all.about.apartment.bill.domain.Personal_mgmt_exVO;
import all.about.apartment.bill.domain.SaleBillVO;
import all.about.apartment.bill.domain.ScorePMEVO;
import all.about.apartment.bill.domain.SetEnergyAVG;
import all.about.apartment.bill.domain.SetMonthBill;



public interface BillDAO {
	public List<Personal_mgmt_exVO> getPersonal_mgmt_exList() throws Exception;
	public Personal_mgmt_exVO monthBill(SetMonthBill setMonthBill) throws Exception;
	public List<SaleBillVO> getSaleBill(Integer input_num) throws Exception;
	public List<EnergyVO> getEnergyList(SetMonthBill setMonthBill) throws Exception;
	public List<Personal_mgmt_exVO> getSelectDetail(SetMonthBill setMonthBill) throws Exception;
	public List<EnergyVO> getYearEnergy(SetMonthBill setMonthBill) throws Exception;
	public int getElecAVG(SetEnergyAVG setEnergyAVG) throws Exception;
	public List<ScorePMEVO> getElecList() throws Exception;
	public List<ScorePMEVO> getHeatList() throws Exception;
	public int getScoreNum(String viewName) throws Exception;
	public List<ScorePMEVO> getSelectEnergyList(String viewName) throws Exception;
}
