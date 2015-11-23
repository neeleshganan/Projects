package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*This class is written to retrieving the appointment from the DB and displaying the
details in the UI.*/
public class AppointmentDAO {
	ArrayList<PatientAppointment1> pList = new ArrayList<PatientAppointment1>();
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	/*This method is written to retrieving the appointment from the DB and forwarding the 
	 * List of Appointments for a particular doctor to the controller.*/
	public ArrayList<PatientAppointment1> viewAppointment(String doctorId,String givenDate) {

		String strDate = givenDate;
		try {
			//The below logic is written to format the date from one form to another form.
			SimpleDateFormat sdfSource = new SimpleDateFormat("dd/MM/yyyy");
			Date date = sdfSource.parse(strDate);
			SimpleDateFormat sdfDestination = new SimpleDateFormat(
					"dd-MMM-yyyy");
			strDate = sdfDestination.format(date);
		
			conn = DbConnection.getConnection();
			String sql="SELECT DISTINCT a.OPDNO, p.NAME,p.ADDRESS,p.GENDER,a.VISITINGTIME " +
					"FROM TBL_LP16_APPOINTMENT a , TBL_LP16_PATIENT p, TBL_LP16_DOCTOR d " +
					"WHERE a.OPDNO=p.OPDNO and d.DOCTORID='" + doctorId+ "' and " +
							"a.VISITINGDATE ='" + strDate+ "'" ;
			
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				PatientAppointment1 papp=new PatientAppointment1();
				papp.setOpdNo(rs.getInt("OPDNo"));
				papp.setName(rs.getString("Name"));
				papp.setGender(rs.getString("Gender"));
				papp.setVisitingTime(rs.getString("VisitingTime"));
			
				pList.add(papp);
			}
			rs.close();
			pst.close();
			conn.close();

		} 
		catch (ParseException pe) {
			System.out.println("Parse Exception : " + pe);
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println(" Clsoing exception" + e);
			}
		}
		return pList;

	}
}
