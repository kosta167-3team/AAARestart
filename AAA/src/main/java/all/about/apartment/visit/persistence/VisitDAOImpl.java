package all.about.apartment.visit.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import all.about.apartment.publicDomain.Criteria;
import all.about.apartment.publicDomain.ResidentVO;
import all.about.apartment.visit.domain.ApplicationVO;
import all.about.apartment.visit.dto.ApplicationDTO;

@Repository
public class VisitDAOImpl implements VisitDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "all.about.apartment.mappers.visitMapper";
	@Override
	public ResidentVO get(ApplicationDTO dto) {
		System.out.println("dao : " + dto.toString());
		return session.selectOne(namespace + ".get", dto);
	}
	@Override
	public Integer maxVR() {
		return session.selectOne(namespace + ".maxVR");
	}
	@Override
	public void applicationVisit(ApplicationDTO dto) {
		session.insert(namespace + ".applicationVisit", dto);
	}
	@Override
	public List<ApplicationVO> applicationList(String r_id) {
		return session.selectList(namespace+".applicationList", r_id);
	}
	@Override
	public List<ApplicationVO> applicationListPage(String r_id, int page) {
		if(page<=0){
            page = 2;
      }
      
      page = (page-1)*5;
      //page(시작row)   5 : 5page씩 보여주겠다는 것
      return session.selectList(namespace + ".listPage", page, new RowBounds(page, 5));

	}
	@Override
	public List<ApplicationVO> listCriteria(Criteria cri) {
		 return session.selectList(namespace + ".listCriteria", cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}
	@Override
	public int totalCount(String r_id) {
		return session.selectOne(namespace+".totalCount", r_id);
	}
	@Override
	public void updateCheck(HashMap<String, Object> map) {
		System.out.println(map.get("vr_id") + " " + map.get("check"));
		session.update(namespace+".updateCheck", map);
	}
	@Override
	public List<ApplicationVO> adminListPage(String selectedDate) {
		return session.selectList(namespace + ".adminListPage", selectedDate);
	}
	@Override
	public void updateState(HashMap<String, Object> map) {
		System.out.println(map.get("vr_id") + " " + map.get("state"));
		session.update(namespace+".updateState", map);		
	}
/*	@Override
	public List<ApplicationVO> searchApplication(String selectedDate) {
		return session.selectList(namespace+".searchApplication", selectedDate);
	}*/
	

}
