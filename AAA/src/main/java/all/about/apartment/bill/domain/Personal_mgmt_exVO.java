package all.about.apartment.bill.domain;

import java.util.HashMap;
import java.util.Map;

public class Personal_mgmt_exVO {

	private static String[] list = { "일반 관리비", "청소비", "소독비", "승강기 유지비", "수선유지비", "장기 수선 충당금", "건물 보험료", "경비비", "관리 수수료",
			"세대전기료", "공동전기료", "TV 수신료", "세대수도료", "세대 급탕비", "생활 폐기물수거", "입대위운영비", "선관위 운영비", "기본 난방비", "공동 난방비",
			"기타 난방비", "세대 가스비", "공동 가스비", "세대 난방비" };
	private static String[] EngList = { "general_mgmt", "clean", "fumigate", "elevator_maintain", "repair",
			"long_term_repair", "building_insurance", "security", "consignment", "personal_elec", "public_elec", "tv",
			"personal_water", "personal_heat_water", "trash_pick_up", "resident_repre", "emc", "basic_heat",
			"public_heat", "etc_heat", "personal_gas", "public_gas", "personal_heat"
	};

	private int input_num;
	private String p_month;
	private String u_id;
	private int general_mgmt;
	private int clean;
	private int fumigate;
	private int elevator_maintain;
	private int repair;
	private int long_term_repair;
	private int building_insurance;
	private int security;
	private int consignment;
	private int personal_elec;
	private int public_elec;
	private int tv;
	private int personal_water;
	private int personal_heat_water;
	private int trash_pick_up;
	private int resident_repre;
	private int emc;
	private String pay_check;
	private int width;
	private int outstanding_pay;

	private int basic_heat;
	private int public_heat;
	private int etc_heat;
	private int personal_gas;
	private int public_gas;
	private int personal_heat;

	public int getPersonal_heat() {
		return personal_heat;
	}

	public void setPersonal_heat(int personal_heat) {
		this.personal_heat = personal_heat;
	}

	public Personal_mgmt_exVO() {
	};

	public Personal_mgmt_exVO(int input_num, String p_month, String u_id, int general_mgmt, int clean, int fumigate,
			int elevator_maintain, int repair, int long_term_repair, int building_insurance, int security,
			int consignment, int personal_elec, int public_elec, int tv, int personal_water, int personal_heat_water,
			int trash_pick_up, int resident_repre, int emc, String pay_check, int width, int outstanding_pay,
			int basic_heat, int public_heat, int etc_heat, int personal_gas, int public_gas, int personal_heat) {
		super();
		this.input_num = input_num;
		this.p_month = p_month;
		this.u_id = u_id;
		this.general_mgmt = general_mgmt;
		this.clean = clean;
		this.fumigate = fumigate;
		this.elevator_maintain = elevator_maintain;
		this.repair = repair;
		this.long_term_repair = long_term_repair;
		this.building_insurance = building_insurance;
		this.security = security;
		this.consignment = consignment;
		this.personal_elec = personal_elec;
		this.public_elec = public_elec;
		this.tv = tv;
		this.personal_water = personal_water;
		this.personal_heat_water = personal_heat_water;
		this.trash_pick_up = trash_pick_up;
		this.resident_repre = resident_repre;
		this.emc = emc;
		this.pay_check = pay_check;
		this.width = width;
		this.outstanding_pay = outstanding_pay;
		this.basic_heat = basic_heat;
		this.public_heat = public_heat;
		this.etc_heat = etc_heat;
		this.personal_gas = personal_gas;
		this.public_gas = public_gas;
		this.personal_heat = personal_heat;
	}

	public int getBasic_heat() {
		return basic_heat;
	}

	public void setBasic_heat(int basic_heat) {
		this.basic_heat = basic_heat;
	}

	public int getPublic_heat() {
		return public_heat;
	}

	public void setPublic_heat(int public_heat) {
		this.public_heat = public_heat;
	}

	public int getEtc_heat() {
		return etc_heat;
	}

	public void setEtc_heat(int etc_heat) {
		this.etc_heat = etc_heat;
	}

	public int getPersonal_gas() {
		return personal_gas;
	}

	public void setPersonal_gas(int personal_gas) {
		this.personal_gas = personal_gas;
	}

	public int getPublic_gas() {
		return public_gas;
	}

	public void setPublic_gas(int public_gas) {
		this.public_gas = public_gas;
	}

	public int getInput_num() {
		return input_num;
	}

	public void setInput_num(int input_num) {
		this.input_num = input_num;
	}

	public String getP_month() {
		return p_month;
	}

	public void setP_month(String p_month) {
		this.p_month = p_month;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public int getGeneral_mgmt() {
		return general_mgmt;
	}

	public void setGeneral_mgmt(int general_mgmt) {
		this.general_mgmt = general_mgmt;
	}

	public int getClean() {
		return clean;
	}

	public void setClean(int clean) {
		this.clean = clean;
	}

	public int getFumigate() {
		return fumigate;
	}

	public void setFumigate(int fumigate) {
		this.fumigate = fumigate;
	}

	public int getElevator_maintain() {
		return elevator_maintain;
	}

	public void setElevator_maintain(int elevator_maintain) {
		this.elevator_maintain = elevator_maintain;
	}

	public int getRepair() {
		return repair;
	}

	public void setRepair(int repair) {
		this.repair = repair;
	}

	public int getLong_term_repair() {
		return long_term_repair;
	}

	public void setLong_term_repair(int long_term_repair) {
		this.long_term_repair = long_term_repair;
	}

	public int getBuilding_insurance() {
		return building_insurance;
	}

	public void setBuilding_insurance(int building_insurance) {
		this.building_insurance = building_insurance;
	}

	public int getSecurity() {
		return security;
	}

	public void setSecurity(int security) {
		this.security = security;
	}

	public int getConsignment() {
		return consignment;
	}

	public void setConsignment(int consignment) {
		this.consignment = consignment;
	}

	public int getPersonal_elec() {
		return personal_elec;
	}

	public void setPersonal_elec(int personal_elec) {
		this.personal_elec = personal_elec;
	}

	public int getPublic_elec() {
		return public_elec;
	}

	public void setPublic_elec(int public_elec) {
		this.public_elec = public_elec;
	}

	public int getTv() {
		return tv;
	}

	public void setTv(int tv) {
		this.tv = tv;
	}

	public int getPersonal_water() {
		return personal_water;
	}

	public void setPersonal_water(int personal_water) {
		this.personal_water = personal_water;
	}

	public int getPersonal_heat_water() {
		return personal_heat_water;
	}

	public void setPersonal_heat_water(int personal_heat_water) {
		this.personal_heat_water = personal_heat_water;
	}

	public int getTrash_pick_up() {
		return trash_pick_up;
	}

	public void setTrash_pick_up(int trash_pick_up) {
		this.trash_pick_up = trash_pick_up;
	}

	public int getResident_repre() {
		return resident_repre;
	}

	public void setResident_repre(int resident_repre) {
		this.resident_repre = resident_repre;
	}

	public int getEmc() {
		return emc;
	}

	public void setEmc(int emc) {
		this.emc = emc;
	}

	public String getPay_check() {
		return pay_check;
	}

	public void setPay_check(String pay_check) {
		this.pay_check = pay_check;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getOutstanding_pay() {
		return outstanding_pay;
	}

	public void setOutstanding_pay(int outstanding_pay) {
		this.outstanding_pay = outstanding_pay;
	}

	public int allBill() {

		return general_mgmt + clean + fumigate + elevator_maintain + repair + long_term_repair + building_insurance
				+ security + consignment + personal_elec + public_elec + tv + personal_water + personal_heat_water
				+ trash_pick_up + resident_repre + emc + outstanding_pay;
	}

	public Map<String, Integer> getSeris() {
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < this.list.length; i++) {
			map.put(this.list[i], getDetailBill()[i]);
		}
		return map;
	}

	public int[] getDetailBill() {
		int[] bill = { general_mgmt, clean, fumigate, elevator_maintain, repair, long_term_repair, building_insurance,
				security, consignment, personal_elec, public_elec, tv , personal_water, personal_heat_water,
				trash_pick_up, resident_repre, emc, outstanding_pay, basic_heat, public_heat, etc_heat
				, personal_gas , public_gas , personal_heat };
		return bill;
	}

	public static String[] getList() {
		return list;
	}

	public static void setList(String[] list) {
		Personal_mgmt_exVO.list = list;
	}

	public static String[] getEngList() {
		return EngList;
	}

	public static void setEngList(String[] engList) {
		EngList = engList;
	}

	public int allElec() {
		return elevator_maintain + personal_elec + public_elec + tv;
	}

	public int allHeat() {
		return personal_heat_water + basic_heat + public_heat + etc_heat + personal_gas + public_gas + personal_heat;
	}

	@Override
	public String toString() {
		return "Personal_mgmt_exVO [input_num=" + input_num + ", p_month=" + p_month + ", u_id=" + u_id
				+ ", general_mgmt=" + general_mgmt + ", clean=" + clean + ", fumigate=" + fumigate
				+ ", elevator_maintain=" + elevator_maintain + ", repair=" + repair + ", long_term_repair="
				+ long_term_repair + ", building_insurance=" + building_insurance + ", security=" + security
				+ ", consignment=" + consignment + ", personal_elec=" + personal_elec + ", public_elec=" + public_elec
				+ ", tv=" + tv + ", personal_water=" + personal_water + ", personal_heat_water=" + personal_heat_water
				+ ", trash_pick_up=" + trash_pick_up + ", resident_repre=" + resident_repre + ", emc=" + emc
				+ ", pay_check=" + pay_check + ", width=" + width + ", outstanding_pay=" + outstanding_pay
				+ ", basic_heat=" + basic_heat + ", public_heat=" + public_heat + ", etc_heat=" + etc_heat
				+ ", personal_gas=" + personal_gas + ", public_gas=" + public_gas + ", personal_heat=" + personal_heat
				+ "]";
	}

}
