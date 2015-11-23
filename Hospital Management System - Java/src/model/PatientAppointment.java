package model;

import java.sql.Connection;
import java.util.Date;
import java.util.TimeZone;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PatientAppointment 
{

	private int opd,doctorId,appointmentId;
	private String consultationDate,slot,specialization;


	public PatientAppointment(int opd, int doctorId, int appointmentId,
			String consultationDate, String slot) 
	{
		this.opd = opd;
		this.doctorId = doctorId;
		this.appointmentId = appointmentId;
		this.consultationDate = consultationDate;
		this.slot = slot;
	}
	
		
	public PatientAppointment(int opd, int doctorId, String consultationDate,
			String slot, String specialization) {
		super();
		this.opd = opd;
		this.doctorId = doctorId;
		this.consultationDate = consultationDate;
		this.slot = slot;
		this.specialization = specialization;
	}

	
	public PatientAppointment()
	{
	}
	
	
	

	public String getSpecialization() 
	{
		return specialization;
	}

	public void setSpecialization(String specialization)
	{
		this.specialization = specialization;
	}	
	
	public int getOpd() 
	{
		return opd;
	}
	public void setOpd(int opd) 
	{
		this.opd = opd;
	}
	public int getDoctorId() 
	{
		return doctorId;
	}
	public void setDoctorId(int doctorId) 
	{
		this.doctorId = doctorId;
	}
	public int getAppointmentId() 
	{
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) 
	{
		this.appointmentId = appointmentId;
	}
	public String getConsultationDate() 
	{
		return consultationDate;
	}
	public void setConsultationDate(String consultationDate) 
	{
		this.consultationDate = consultationDate;
	}
	public String getSlot() 
	{
		return slot;
	}
	public void setSlot(String slot) 
	{
		this.slot = slot;
	}
	
	public int createAppointment(int opd,String specialization,int doctorId,String dateOfAppointment,String appointmentSlot) throws java.text.ParseException
	{
	
		DbConnection db = new DbConnection();
		Connection conn= db.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String day=validateDate(dateOfAppointment);
		
		try
		{
			if(!(day.equalsIgnoreCase(null)))
			{
				ps = conn.prepareStatement("SELECT * FROM LP15_DOCTOR");
				ResultSet rst=ps.executeQuery();
				while(rst.next())
				{
					int did=rst.getInt("DOCTOR_ID");
					if(did==doctorId)
					{
						String tf=rst.getString(day);
						System.out.println(tf);
						if(tf.equalsIgnoreCase("F"))
						{
							
							System.out.println("DOCTOR DOESNT COME THAT DAY");
							return -1;
						}
						else
							System.out.println("docotor present");
					}
				}
				rst.close();
				if(slotCheck(doctorId,dateOfAppointment,appointmentSlot))
				{
					ps= conn.prepareStatement("INSERT INTO LP15_PATIENT_APPOINTMENT VALUES(APPID_LP15.nextval,?,?,TO_DATE(?,'DD-MM-YYYY'),?,?)");
					ps.setInt(1,opd);
					ps.setInt(2,doctorId);
					ps.setString(3,dateOfAppointment );
					ps.setString(4,appointmentSlot);
					ps.setString(5,specialization);
					ps.executeUpdate();
					System.out.println("new appointment created successfully");
					PreparedStatement pst;
					pst = conn.prepareStatement("SELECT * FROM LP15_PATIENT_APPOINTMENT");
					rs=pst.executeQuery();
					int appid=0;
					while(rs.next())
					{
						int id=rs.getInt("APPOINTMENT_ID");	
						if(id>appid)
							appid=id;
					}
					System.out.println("your appointment id is : "+appid);
					return appid;
					
				}
				else
				{
					System.out.println("slot already filled select different slot");
					return -2;
				}
			}
			else
			{
				System.out.println("please select date greater than todays");
				return -3;
			}
		}
		catch(Exception e)
		{
			System.out.println("Creation of new appointment failed");
			return -3;
		}
		/*finally
		{
			try 
			{
				conn.close();
				ps.close();
				rs.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			
		}
		*/
	}
	public String validateDate(String dateOfAppointment) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try
		{
			date = format.parse(dateOfAppointment);
		} 
		catch (java.text.ParseException e)
		{         
			e.printStackTrace();
			System.out.println("PROBLEM WITH DATE");
		}
		if (new SimpleDateFormat("dd-MM-yyyy").parse(dateOfAppointment).getTime() / (1000 * 60 * 60 * 24) >= System.currentTimeMillis() / (1000 * 60 * 60 * 24))
		{
			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
			calendar.setTime(date);
			int day=calendar.get(Calendar.DAY_OF_WEEK);
			if(day==1)
			{
				return "MONDAY";
			}	
			else if(day==2){
				return "TUESDAY";
			}
			else if(day==3){
				return "WEDNESDAY";
			}
			else if(day==4){
				return "THURSDAY";
			}
			else if(day==5){
				return "FRIDAY";
			}
			else if(day==6){
				return "SATURDAY";
			}
			else if(day==7){
				return "SUNDAY";
			}	
		}
		else
		{
			System.out.println("select date greater than todays date");
			return null;
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public PatientAppointment getPatientAppointmentDetails(int appointmentid) throws SQLException {
		
		DbConnection db = new DbConnection();
		Connection con= db.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		PatientAppointment p=new PatientAppointment();
		try
		{
			String sql="SELECT * FROM LP15_PATIENT_APPOINTMENT WHERE APPOINTMENT_ID='"+appointmentid+"'";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			int count=0;
			while(rs.next())
			{
				count++;
				p.appointmentId=rs.getInt("APPOINTMENT_ID");
				
				Date d=rs.getDate("CDATE");
				int day=d.getDate();
				int month=d.getMonth()+1;
				int year=d.getYear()+1900;				
				if(month<9)
				{
					if(day<10)
					{
						p.consultationDate="0"+day+"-0"+month+"-"+year+"";
					}
					else
					{
						p.consultationDate=day+"-0"+month+"-"+year+"";
					}
				}
				else
				{
					if(day<10)
					{
						p.consultationDate="0"+day+"-"+month+"-"+year+"";
					}
					else
					{
						p.consultationDate=day+"-"+month+"-"+year+"";
					}
				}
				p.doctorId=rs.getInt("DOCTOR_ID");
				p.opd=rs.getInt("OPDNO");
				p.slot=rs.getString("SLOT");
				p.specialization=rs.getString("SPECIALIZATION");
				return p;
			}
			if(count==0)
			{
				return null;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try 
			{
				con.close();
				stmt.close();
				rs.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return p;
	}
	public boolean slotCheck(int docid,String date,String slot) throws SQLException
	{
		DbConnection db = new DbConnection();
		Connection con= db.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			ps= con.prepareStatement("Select * from lp15_consultation where DOCTOR_ID=? AND CDATE=TO_DATE(?,'DD-MM-YYYY')");
			ps.setInt(1,docid);
			ps.setString(2,date);
			rs=ps.executeQuery();
			int num=0;
			if(slot.equalsIgnoreCase("10"))
				num=3;
			if(slot.equalsIgnoreCase("11"))
				num=4;
			if(slot.equalsIgnoreCase("12"))
				num=5;
			if(slot.equalsIgnoreCase("01"))
				num=6;
			if(slot.equalsIgnoreCase("02"))
				num=7;
			if(slot.equalsIgnoreCase("03"))
				num=8;
			if(slot.equalsIgnoreCase("04"))
				num=9;
			int count=0;
			while(rs.next())
			{
				count++;
			}
			System.out.println("count="+count);
			rs.close();
			if(count==0)
			{
				ps=con.prepareStatement("INSERT INTO LP15_CONSULTATION VALUES(?,TO_DATE(?,'DD-MM-YYYY'),?,?,?,?,?,?,?)");
				ps.setInt(1,docid);
				ps.setString(2,date);
				for(int i=3;i<=9;i++)
				{
					if(i==num)
					{
						ps.setString(i,"F");
					}
					else
					{
						ps.setString(i,"E");
					}
				}
				ps.executeUpdate();
				System.out.println("inserted");
				return true;
			}
			else if(count==1)
			{
				ps=con.prepareStatement("select * from lp15_consultation where doctor_id=? and cdate=TO_DATE(?,'DD-MM-YYYY')");
				ps.setInt(1, docid);
				ps.setString(2,date);
				rs=ps.executeQuery();
				rs.next();
				String colname="";
				if(slot.equalsIgnoreCase("10"))
					num=3;
				if(slot.equalsIgnoreCase("11"))
					num=4;
				if(slot.equalsIgnoreCase("12"))
					num=5;
				if(slot.equalsIgnoreCase("01"))
					num=6;
				if(slot.equalsIgnoreCase("02"))
					num=7;
				if(slot.equalsIgnoreCase("03"))
					num=8;
				if(slot.equalsIgnoreCase("04"))
					num=9;
				if(num==3)
					colname="SLOTAT10";
			
				if(num==4)
					colname="SLOTAT11";

				if(num==5)
					colname="SLOTAT12";
				
				if(num==6)
					colname="SLOTAT01";
				
				if(num==7)
					colname="SLOTAT02";

				if(num==8)
					colname="SLOTAT03";

				if(num==9)
					colname="SLOTAT04";

				for(int i=3;i<=9;i++)
				{
					if(i==num)
					{
						if(rs.getString(i).equalsIgnoreCase("E"))
						{
							System.out.println(colname);
							ps=con.prepareStatement("UPDATE LP15_CONSULTATION SET "+colname+"=? where "+colname+"=? AND DOCTOR_ID=? AND CDATE=TO_DATE(?,'DD-MM-YYYY')");
							ps.setString(1,"F");
							ps.setString(2,"E");
							ps.setInt(3,docid);
							ps.setString(4,date);
							ps.executeUpdate();
							System.out.println("updated");
							return true;
						}
						else
						{
							System.out.println("Slot is not empty");
							return false;
						}
					}
				
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try 
			{
				con.close();
				ps.close();
				rs.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return false;
		
	}


	public int UpdateAppointment(int appointmentid, int opd,
			String specialization, int doctorId, String dateOfAppointment,
			String appointmentSlot) throws ParseException 
	{
		DbConnection db = new DbConnection();
		Connection conn= db.getConnection();
		PreparedStatement ps=null;
		ResultSet rst=null;
		
		String day=validateDate(dateOfAppointment);
		
		try
		{
			if(!(day.equalsIgnoreCase(null)))
			{
				ps = conn.prepareStatement("SELECT * FROM LP15_DOCTOR");
				rst=ps.executeQuery();
				while(rst.next())
				{
					int did=rst.getInt("DOCTOR_ID");
					if(did==doctorId)
					{
						String tf=rst.getString(day);
						System.out.println(tf);
						if(tf.equalsIgnoreCase("F"))
						{
							
							System.out.println("DOCTOR DOESNT COME THAT DAY");
							return -1;
						}
						else
							System.out.println("docotor present");
					}
				}
				rst.close();
				if(slotCheck(doctorId,dateOfAppointment,appointmentSlot))
				{
					ps= conn.prepareStatement("INSERT INTO LP15_PATIENT_APPOINTMENT VALUES(?,?,?,TO_DATE(?,'DD-MM-YYYY'),?,?)");
					ps.setInt(1,appointmentid);
					ps.setInt(2,opd);
					ps.setInt(3,doctorId);
					ps.setString(4,dateOfAppointment );
					ps.setString(5,appointmentSlot);
					ps.setString(6,specialization);
					ps.executeUpdate();
					System.out.println("Appointment updated successfully");
					return 1;
				}
				else
				{
					System.out.println("slot already filled select different slot");
					return -2;
				}
			}
			else
			{
				System.out.println("please select date greater than todays");
				return -3;
			}
		}
		catch(Exception e)
		{
			System.out.println("Updation of appointment failed");
			return -3;
		}
		finally
		{
			try 
			{
				conn.close();
				ps.close();
				rst.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	
	}
	@SuppressWarnings("deprecation")
	public static int deleteAppointment(int appointmentId)
	{
		DbConnection db = new DbConnection();
		Connection conn= db.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			ResultSet rs1=null;
			ps=conn.prepareStatement("SELECT * FROM LP15_PATIENT_APPOINTMENT WHERE APPOINTMENT_ID="+appointmentId+"");
			rs1=ps.executeQuery();
			rs1.next();
			int docid=rs1.getInt("DOCTOR_ID");
			System.out.println("4");
			System.out.println(docid);
			Date d=rs1.getDate("CDATE");
			int day=d.getDate();
			int month=d.getMonth()+1;
			int year=d.getYear()+1900;
			String date;
			
			if(month<9)
			{
				if(day<10)
				{
					date="0"+day+"-0"+month+"-"+year+"";
				}
				else
				{
					date=day+"-0"+month+"-"+year+"";
				}
			}
			else
			{
				if(day<10)
				{
					date="0"+day+"-"+month+"-"+year+"";
				}
				else
				{
					date=day+"-"+month+"-"+year+"";
				}
			}
			System.out.println(date);
			String slot=rs1.getString("SLOT");
			rs1.close();
			System.out.println(slot);
			ps=conn.prepareStatement("select * from lp15_consultation where doctor_id=? and cdate=TO_DATE(?,'DD-MM-YYYY')");
			ps.setInt(1, docid);
			ps.setString(2,date);
			rs=ps.executeQuery();
			rs.next();
			String colname="";
			System.out.println(rs.getString(6));
			int num=0;
			if(slot.equalsIgnoreCase("10"))
			num=3;
			if(slot.equalsIgnoreCase("11"))
			num=4;
			if(slot.equalsIgnoreCase("12"))
			num=5;
			if(slot.equalsIgnoreCase("01"))
			num=6;
			if(slot.equalsIgnoreCase("02"))
			num=7;
			if(slot.equalsIgnoreCase("03"))
			num=8;
			if(slot.equalsIgnoreCase("04"))
			num=9;
			if(num==3)
				colname="SLOTAT10";
			
			if(num==4)
				colname="SLOTAT11";

			if(num==5)
				colname="SLOTAT12";

			if(num==6)
				colname="SLOTAT01";

			if(num==7)
				colname="SLOTAT02";

			if(num==8)
				colname="SLOTAT03";

			if(num==9)
				colname="SLOTAT04";

			for(int i=3;i<=9;i++)
			{
				if(i==num){
					System.out.println(rs.getString(i));
					if(rs.getString(i).equalsIgnoreCase("F"))
					{
						System.out.println(colname);
						ps=conn.prepareStatement("UPDATE LP15_CONSULTATION SET "+colname+"=? where "+colname+"=? AND DOCTOR_ID=? AND CDATE=TO_DATE(?,'DD-MM-YYYY')");
						ps.setString(1,"E");
						ps.setString(2,"F");
						ps.setInt(3,docid);
						ps.setString(4,date);
						ps.executeUpdate();
						ps.close();
						System.out.println("SLOT FREED");
						
					}
					else
					{
						System.out.println("FREEING OF SLOT FAILED");
					}
				}
				
			}

			ps= conn.prepareStatement("DELETE FROM LP15_PATIENT_APPOINTMENT WHERE APPOINTMENT_ID=?");
			ps.setInt(1,appointmentId);
			ps.executeUpdate();
			System.out.println("deleted successfully");
			return 1;
		}
		catch(Exception e)
		{
			System.out.println("appointment id was not found in the database");
			System.out.println("deletion of appointment failed");
			return -1;
		}
		/*finally
		{
			try 
			{
				conn.close();
				ps.close();
				rs.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}*/
	}


	public int validateOpd(int opd) 
	{

		DbConnection db = new DbConnection();
		Connection conn= db.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			ps=conn.prepareStatement("SELECT OPDNO FROM LP15_PATIENT WHERE OPDNO="+opd+"");
			int count=0;
			rs=ps.executeQuery();
			while(rs.next())
			{
				count++;
			}
			if(count==0)
			{
				return 0;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
		return 1;
	}
}
