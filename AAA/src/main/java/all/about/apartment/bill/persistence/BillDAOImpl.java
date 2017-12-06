package all.about.apartment.bill.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.bill.domain.EnergyVO;
import all.about.apartment.bill.domain.Personal_mgmt_exVO;
import all.about.apartment.bill.domain.SaleBillVO;
import all.about.apartment.bill.domain.ScorePMEVO;
import all.about.apartment.bill.domain.SetEnergyAVG;
import all.about.apartment.bill.domain.SetMonthBill;


@Repository
public class BillDAOImpl implements BillDAO {

	@Inject
	private SqlSession session;
	private static String namespace = "all.about.apartment.mappers.BillMapper";

	@Override
	public List<Personal_mgmt_exVO> getPersonal_mgmt_exList() throws Exception {
		
		return session.selectList(namespace + ".getPersonal_mgmt_ex");
	}

	@Override
	public Personal_mgmt_exVO monthBill(SetMonthBill setMonthBill) throws Exception {
		
		return session.selectOne(namespace+".getOnePersonal_mgmt_ex", setMonthBill);
	}

	@Override
	public List<SaleBillVO> getSaleBill(Integer input_num) throws Exception {
		
		return session.selectList(namespace + ".getSaleBill", input_num);
	}

	@Override
	public List<EnergyVO> getEnergyList(SetMonthBill setMonthBill) throws Exception {
		
		return session.selectList(namespace+".getEnergyList", setMonthBill);
	}

	@Override
	public List<Personal_mgmt_exVO> getSelectDetail(SetMonthBill setMonthBill) throws Exception {
		
		return session.selectList(namespace + ".getSelectDetail", setMonthBill);
	}

	@Override
	public List<EnergyVO> getYearEnergy(SetMonthBill setMonthBill) throws Exception {
		
		return session.selectList(namespace + ".getYearEnergy", setMonthBill);
	}

	@Override
	public int getElecAVG(SetEnergyAVG setEnergyAVG) throws Exception {
		
		return session.selectOne( namespace+ ".getElecAVG", setEnergyAVG);
	}

	@Override
	public List<ScorePMEVO> getElecList() throws Exception {
		return session.selectList(namespace + ".getElecList");
	}

	@Override
	public List<ScorePMEVO> getHeatList() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getHeatList");
	}

	@Override
	public int getScoreNum(String viewName) throws Exception {
		
		return session.selectOne(namespace + ".getScoreNum", viewName);
	}

	@Override
	public List<ScorePMEVO> getSelectEnergyList(String viewName) throws Exception {
		
		return session.selectList(namespace+ ".getSelectEnergyList", viewName);
	}

	@Override
	public double getAVGelecMonth(String p_month) throws Exception {
		
		return session.selectOne(namespace + ".getAVGelecMonth", p_month);
	}



}
