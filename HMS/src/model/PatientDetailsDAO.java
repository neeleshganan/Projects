package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PatientDetailsDAO {

	/*
	 * method to generate opd Number after successful registration. It accepts
	 * no parameters and returns an object of type class PatientBean
	 */
	public PatientBeanDD displayOpdNo() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DbConnection.getConnection();

			String sql = "SELECT MAX(OPDNO) FROM TBL_P2_T5_PATIENT "
					+ "ORDER BY OPDNO DESC ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

		} catch (Exception e) {
			System.out.println("printing not done");
		}
		try {
			while (rs.next()) {
				PatientBeanDD p3 = new PatientBeanDD();
				System.out.println("Opd no is" + rs.getInt("MAX(OPDNO)"));
				p3.setOpdNumber(rs.getInt("MAX(OPDNO)"));

				return p3;
			}

			rs.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null)

				{
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				System.out.println(" Closing exception" + e);
			}

		}
		return null;

	}

	/*
	 * method to insert details of patient from User Interface to database It
	 * accepts object of class PatientBean and returns nothing.
	 */public void insertPatientDetails(PatientBeanDD p) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DbConnection.getConnection();
			String sql = "INSERT INTO " + "TBL_P2_T5_PATIENT VALUES "
					+ "(SEQ_P2_T5_PATIENT.NEXTVAL,?,?,?,"
					+ "TO_DATE(?,'DD-MON-YYYY'),?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getFirstName());
			pstmt.setString(2, p.getMiddleName());
			pstmt.setString(3, p.getLastName());
			pstmt.setString(4, p.getDateOfBirth());
			pstmt.setString(5, p.getGender());
			pstmt.setString(6, p.getBloodGroup());
			pstmt.setString(7, p.getFatherOrSpouseName());
			pstmt.setString(8, p.getAddress());
			pstmt.setString(9, p.getContactNo());
			pstmt.setString(10, p.getEmailId());
			pstmt.setString(11, p.getIsVisitedEarlier());
			pstmt.setString(12, p.getDisease());
			pstmt.setString(13, p.getSpecialization());
			int count = pstmt.executeUpdate(); // variable to store no:of rows
												// inserted
			pstmt.close();
			System.out.println("Inserted count" + count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)

				{
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				System.out.println(" Closing exception" + e);
			}
		}

	}

	/*
	 * method to display all the patients details It accepts nothing and returns
	 * an array list of type class PatientBean
	 */
	public static ArrayList<PatientBeanDD> viewAllPatients() {

		ArrayList<PatientBeanDD> patient = new ArrayList<PatientBeanDD>();
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs = null;

		try {
			con = DbConnection.getConnection();
			String sql = "SELECT * FROM TBL_P2_T5_PATIENT ORDER BY OPDNO";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {

				PatientBeanDD patients = new PatientBeanDD();
				int opdn = rs.getInt("OPDNO");

				String firstName = rs.getString("FIRSTNAME");
				String middleName = rs.getString("MIDNAME");
				String lastName = rs.getString("LASTNAME");
				String dob = rs.getString("DOB");
				String gender = rs.getString("GENDER");
				String bg = rs.getString("BLOODGROUP");
				String fsName = rs.getString("FATHERORSPOUSENAME");
				String address = rs.getString("ADDRESS");
				String phno = rs.getString("CONTACTNO");
				String mailId = rs.getString("MAILID");
				String disease = rs.getString("DISEASE");
				String tod = rs.getString("SPECIALIZATION");
				String isVisited = rs.getString("ISVISITEDEARLIER");

				patients.setOpdNumber(opdn);
				patients.setFirstName(firstName);
				patients.setMiddleName(middleName);
				patients.setLastName(lastName);
				patients.setDateOfBirth(dob);
				patients.setBloodGroup(bg);
				patients.setGender(gender);
				patients.setFatherOrSpouseName(fsName);
				patients.setAddress(address);
				patients.setContactNo(phno);
				patients.setEmailId(mailId);
				patients.setDisease(disease);
				patients.setSpecialization(tod);
				patients.setIsVisitedEarlier(isVisited);

				patient.add(patients);

			}
			rs.close();
			pst.close();
		} catch (Exception e) {
			System.out.println("Query not executed");
		}

		return patient;
	}

	/*
	 * method to display patient's details referring opd number It accepts opd
	 * number and returns an object of class PatientBean
	 */public PatientBeanDD displayPatient(int opdn) {
		PatientBeanDD patients = new PatientBeanDD();
		PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		Connection con = null;
		ResultSet rs = null;

		int flag = 0; // variable to set flag according to the condition

		try {
			con = DbConnection.getConnection();

			String sql = "UPDATE  TBL_P2_T5_PATIENT SET " +
					"ISVISITEDEARLIER='Y' WHERE OPDNO=?";
			pst1 = con.prepareStatement(sql);

			pst1.setInt(1, opdn);
			pst1.executeUpdate();
			String sql1 = "SELECT * FROM TBL_P2_T5_PATIENT  WHERE OPDNO=?";

			pst = con.prepareStatement(sql1);
			pst.setInt(1, opdn);

			rs = pst.executeQuery();

			if (rs.next() == true) {

				flag = 1;
				String firstName = rs.getString("FIRSTNAME");
				String middleName = rs.getString("MIDNAME");
				String lastName = rs.getString("LASTNAME");
				String dob = rs.getString("DOB");
				String gender = rs.getString("GENDER");
				String bg = rs.getString("BLOODGROUP");
				String fsName = rs.getString("FATHERORSPOUSENAME");
				String address = rs.getString("ADDRESS");
				String phno = rs.getString("CONTACTNO");
				String mailId = rs.getString("MAILID");
				String disease = rs.getString("DISEASE");
				String tod = rs.getString("SPECIALIZATION");
				String isVisited = rs.getString("ISVISITEDEARLIER");

				patients.setOpdNumber(opdn);
				patients.setFirstName(firstName);
				patients.setMiddleName(middleName);
				patients.setLastName(lastName);
				patients.setDateOfBirth(dob);
				patients.setBloodGroup(bg);
				patients.setGender(gender);
				patients.setFatherOrSpouseName(fsName);
				patients.setAddress(address);
				patients.setContactNo(phno);
				patients.setEmailId(mailId);
				patients.setDisease(disease);
				patients.setSpecialization(tod);
				patients.setIsVisitedEarlier(isVisited);

			}

			rs.close();
			pst.close();

		} catch (Exception e) {
			System.out.println("Query not executed");
			e.printStackTrace();
		}
		if (flag == 0) {
			patients = null;
		}

		return patients;

	}

	/*
	 * Method to delete patient details. It accepts object of class PatientBeanDD
	 * and returns nothing.
	 */
	public int deletePatientDetails(PatientBeanDD s1) {

		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {

			conn = DbConnection.getConnection();

			String sql = "DELETE FROM TBL_P2_T5_PATIENT WHERE OPDNO=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, s1.getOpdNumber());
			count = ps.executeUpdate();

			System.out.println("Deleted count" + count);
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)

				{
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				System.out.println(" Closing exception" + e);
			}

		}
		return count;

	}

	/*
	 * method to validate the FOM login. It accepts user name and password from
	 * User Interface and returns a flag after validating with database.
	 */
	public int checkFomLogin(String userName, String password) {

		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs = null;
		int flag = 0; // a variable to set flag according to the condition.
		String uName, pwd;
		try {

			con = DbConnection.getConnection();
			String sql = "SELECT * FROM TBL_P2_T5_USER";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.next()) {
				uName = rs.getString("USERID");
				pwd = rs.getString("PASSWORD");
				if (userName.equals(uName)) {
					if (password.equals(pwd)) {
						flag = 1;
					}

				}
			}

			rs.close();
			pst.close();

		}

		catch (Exception e) {
			System.out.println("Query not executed");
		}finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pst != null)

				{
					pst.close();
				}
				if (con != null) {
					con.close();
				}
				
			} catch (Exception e) {
				System.out.println(" Closing exception" + e);
			}

		}

		return flag;
	}

	public PatientBeanDD displayPatientForUpdation(int opdn) {
		PatientBeanDD patients = new PatientBeanDD();
		PreparedStatement pst = null;

		Connection con = null;
		ResultSet rs = null;

		int flag = 0; // variable to set flag according to the condition

		try {
			con = DbConnection.getConnection();

			String sql1 = "SELECT * FROM TBL_P2_T5_PATIENT  WHERE OPDNO=?";

			pst = con.prepareStatement(sql1);
			pst.setInt(1, opdn);

			rs = pst.executeQuery();

			if (rs.next() == true) {

				flag = 1;
				String firstName = rs.getString("FIRSTNAME");
				String middleName = rs.getString("MIDNAME");
				String lastName = rs.getString("LASTNAME");
				String dob = rs.getString("DOB");
				String gender = rs.getString("GENDER");
				String bg = rs.getString("BLOODGROUP");
				String fsName = rs.getString("FATHERORSPOUSENAME");
				String address = rs.getString("ADDRESS");
				String phno = rs.getString("CONTACTNO");
				String mailId = rs.getString("MAILID");
				String disease = rs.getString("DISEASE");
				String tod = rs.getString("SPECIALIZATION");
				String isVisited = rs.getString("ISVISITEDEARLIER");

				patients.setOpdNumber(opdn);
				patients.setFirstName(firstName);
				patients.setMiddleName(middleName);
				patients.setLastName(lastName);
				patients.setDateOfBirth(dob);
				patients.setBloodGroup(bg);
				patients.setGender(gender);
				patients.setFatherOrSpouseName(fsName);
				patients.setAddress(address);
				patients.setContactNo(phno);
				patients.setEmailId(mailId);
				patients.setDisease(disease);
				patients.setSpecialization(tod);
				patients.setIsVisitedEarlier(isVisited);

			}

			rs.close();
			pst.close();

		} catch (Exception e) {
			System.out.println("Query not executed");
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pst != null)

				{
					pst.close();
				}
				if (con != null) {
					con.close();
				}
				
			} catch (Exception e) {
				System.out.println(" Closing exception" + e);
			}

		}

		if (flag == 0) {
			patients = null;
		}

		return patients;

	}

	public int updatePatient(PatientBeanDD patient) {

		PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		Connection con = null;
		ResultSet rs = null;
		int flag = 0;
		 // variable to set flag according to the condition

		try {
			con = DbConnection.getConnection();
			
			String sql1 = "SELECT * FROM TBL_P2_T5_PATIENT  WHERE OPDNO=?";
			pst = con.prepareStatement(sql1);
			pst.setInt(1, patient.getOpdNumber());
			rs = pst.executeQuery();
			if (rs.next()== true) {

				String sql = "UPDATE  TBL_P2_T5_PATIENT " +
						"SET ADDRESS=?,CONTACTNO=?,DISEASE=? WHERE OPDNO=?";
				pst1 = con.prepareStatement(sql);
				pst1.setString(1, patient.getAddress());
				pst1.setString(2, patient.getContactNo());
				pst1.setString(3, patient.getDisease());
				pst1.setInt(4, patient.getOpdNumber());
				
				flag = pst1.executeUpdate();
				
			}

			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Query not executed");
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pst != null)

				{
					pst.close();
				}
				if (pst1 != null)

				{
					pst1.close();
				}
				if (con != null) {
					con.close();
				}
				
			} catch (Exception e) {
				System.out.println(" Closing exception" + e);
			}

		}


		return flag;

	}

}
