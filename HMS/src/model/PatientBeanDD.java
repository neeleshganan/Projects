package model;

public class PatientBeanDD {
	private int opdNumber;
	private String firstName;
	private String middleName;
	private  String lastName;
	private String dateOfBirth;
	private String bloodGroup;
	private String gender;
	private String fatherOrSpouseName;
	private String address;
	private String contactNo;
	private String emailId;
	private String isVisitedEarlier;
	private String  disease;
	private String specialization;
	
	public void setOpdNumber(int opdNumber){
		this.opdNumber=opdNumber;
	}
	public int getOpdNumber(){
		return opdNumber;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setFatherOrSpouseName(String fatherOrSpouseName) {
		this.fatherOrSpouseName = fatherOrSpouseName;
	}
	public String getFatherOrSpouseName() {
		return fatherOrSpouseName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setIsVisitedEarlier(String isVisitedEarlier) {
		this.isVisitedEarlier = isVisitedEarlier;
	}
	public String getIsVisitedEarlier() {
		return isVisitedEarlier;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getDisease() {
		return disease;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getSpecialization() {
		return specialization;
	}
	

}
