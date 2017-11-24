package all.about.apartment.bill.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.bill.domain.EnergyVO;
import all.about.apartment.bill.domain.Personal_mgmt_exVO;
import all.about.apartment.bill.domain.SaleBillVO;
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



}
