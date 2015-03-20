package model;

/*This class is used to get and set the details of a patient.
 All the getter and setter methods are written for that purpose.*/
public class PatientBean {
	private int OPDNo;
	private String name;
	private String address;
	private String gender;
	private String deptNo;

	public PatientBean() {
		super();
	}

	public PatientBean(int oPDNo, String name, String address, String gender,
			String deptNo) {
		super();
		OPDNo = oPDNo;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.deptNo = deptNo;
	}

	public int getOPDNo() {
		return OPDNo;
	}

	public void setOPDNo(int oPDNo) {
		OPDNo = oPDNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
}
