package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*This class is used for performing the read and update operations for the observation of a patient*/
public class PatientObservationDAO {

	/*This method is used to read the previous observations of a patient from the DB*/
	public PatientObservation ReadPatientObservation(int opdNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DbConnection.getConnection();
	
		String query = "select * from TBL_LP16_OBSERVATION where OPDNo='"
				+ opdNo + "'";
		PatientObservation p = new PatientObservation();
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == opdNo) {
					p.setOpdNo(rs.getInt(1));
					p.setAdvices(rs.getString(2));
					p.setDoctorPrescription(rs.getString(3));
					return p;
				}
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("error : " + e.getMessage());
		}finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println(" Clsoing exception" + e);
			}
		}
		return null;
	}
	
	/*This method is used to update the observations of a patient to the DB*/
	public int updateRecordOfSearchPatient(PatientObservation updateObj, int opdNo) {
		Connection conn = null;
		PreparedStatement respstmt = null;
		
		conn = DbConnection.getConnection();
		String updateAdvice = updateObj.getAdvices();
		String updatePrescription = updateObj.getDoctorPrescription();
		String query = "update TBL_LP16_OBSERVATION  " +
				"set ADVICES='" + updateAdvice+"', PRESCRIPTIONS='" + updatePrescription + "' where " +
						"OPDNO='" + opdNo + "'" ;
		
		try {
			respstmt = conn.prepareStatement(query);	
			respstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{	
			try {
				if (respstmt != null) {
					respstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println(" Clsoing exception" + e);
			}
		}
		return 1;
	}
}
