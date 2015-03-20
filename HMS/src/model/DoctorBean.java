package model;

/*This class is used to set and get the docId and password of the doctor.
  All the getter and setter methods are written for that purpose.*/
public class DoctorBean {
	private String docId;
	private String password;
	
	public DoctorBean() {
		super();

	}
	public DoctorBean(String docId, String password) {
		super();
		this.docId = docId;
		this.password = password;
	}
	
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
