package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

import model.PatientAppointment;

public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PatientAppointment p1 = new PatientAppointment();

	public NewServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("caseAction");
		String id1 = request.getParameter("caseAction1");
		if (id.equalsIgnoreCase("out")) {
			PatientDAO pd1 = new PatientDAO();
			List<PatientBean> pList1 = pd1.viewAllPatient();
			request.setAttribute("pList1", pList1);
			RequestDispatcher reqDisp1 = request
					.getRequestDispatcher("ViewAllOutPatientDetails.jsp");
			reqDisp1.forward(request, response);
		}

		if (id1.equalsIgnoreCase("in")) {
			PatientDAO pd2 = new PatientDAO();
			List<PatientBean> pList2 = pd2.viewAllInPatient();
			request.setAttribute("pList2", pList2);
			RequestDispatcher reqDisp1 = request
					.getRequestDispatcher("ViewAllInPatientDetails.jsp");
			reqDisp1.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("submit");
		String action1 = request.getParameter("action");

		if (action1 != null) {
			PatientAppointment p2 = new PatientAppointment();
			if (action1.equalsIgnoreCase("new")) {
				int opd = Integer.parseInt(request.getParameter("opd"));
				String specialization = request.getParameter("specialization");
				int doctorId = Integer.parseInt(request
						.getParameter("doctorid"));
				String dateOfAppointment = request
						.getParameter("dateofappointment");
				String appointmentSlot = request
						.getParameter("appointmenttime");
				PatientAppointment pa = new PatientAppointment(opd, doctorId,
						dateOfAppointment, appointmentSlot, specialization);
				try {
					int j = p2.validateOpd(opd);
					if (j == 0) {
						RequestDispatcher reqDisp = request
								.getRequestDispatcher("opderror.jsp");
						reqDisp.forward(request, response);
					} else {
						int i = p2.createAppointment(opd, specialization,
								doctorId, dateOfAppointment, appointmentSlot);
						if (i == -2) {
							request.setAttribute("pa", pa);
							RequestDispatcher reqDisp = request
									.getRequestDispatcher("sloterror.jsp");
							reqDisp.forward(request, response);

						} else if (i == -1) {
							request.setAttribute("pa", pa);
							RequestDispatcher reqDisp = request
									.getRequestDispatcher("docerror.jsp");
							reqDisp.forward(request, response);

						} else if (i == -3) {
							request.setAttribute("pa", pa);
							RequestDispatcher reqDisp = request
									.getRequestDispatcher("dateerror.jsp");
							reqDisp.forward(request, response);

						} else {
							request.setAttribute("pa", pa);
							request.setAttribute("appid", i);
							RequestDispatcher reqDisp = request
									.getRequestDispatcher("appointmentsuccess.jsp");
							reqDisp.forward(request, response);
						}
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else if (action1.equalsIgnoreCase("get")) {
				int appointmentid = Integer.parseInt(request
						.getParameter("appointmentid"));
				try {
					p2 = p1.getPatientAppointmentDetails(appointmentid);
					if (p2 == null) {
						RequestDispatcher rd = request
								.getRequestDispatcher("appidnotfound.jsp");
						rd.forward(request, response);
					} else {
						request.setAttribute("patientdetails", p2);
						RequestDispatcher rd = request
								.getRequestDispatcher("alternewappointment.jsp");
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} else if (action1.equalsIgnoreCase("alter")) {
				int appointmentid = Integer.parseInt(request
						.getParameter("appointmentid"));
				int opd = Integer.parseInt(request.getParameter("opd"));
				String specialization = request.getParameter("specialization");
				int doctorId = Integer.parseInt(request
						.getParameter("doctorid"));
				String dateOfAppointment = request
						.getParameter("dateofappointment");
				String appointmentSlot = request
						.getParameter("appointmenttime");
				PatientAppointment.deleteAppointment(appointmentid);
				try {
					int i = p2.UpdateAppointment(appointmentid, opd,
							specialization, doctorId, dateOfAppointment,
							appointmentSlot);
					if (i == -2) {
						RequestDispatcher reqDisp = request
								.getRequestDispatcher("sloterror.jsp");
						reqDisp.forward(request, response);

					} else if (i == -1) {
						RequestDispatcher reqDisp = request
								.getRequestDispatcher("docerror.jsp");
						reqDisp.forward(request, response);

					} else if (i == -3) {
						RequestDispatcher reqDisp = request
								.getRequestDispatcher("dateerror.jsp");
						reqDisp.forward(request, response);

					} else if (i == 1) {
						RequestDispatcher reqDisp = request
								.getRequestDispatcher("updationsuccess.jsp");
						reqDisp.forward(request, response);
					} else {
						RequestDispatcher reqDisp = request
								.getRequestDispatcher("updationfailed.jsp");
						reqDisp.forward(request, response);
					}

				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else if (action1.equalsIgnoreCase("delete")) {
				int appointmentId = Integer.parseInt(request
						.getParameter("appointmentid"));
				System.out.println(appointmentId);
				int i = PatientAppointment.deleteAppointment(appointmentId);
				if (i == -1) {
					RequestDispatcher rd = request
							.getRequestDispatcher("deletefailed.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request
							.getRequestDispatcher("deletesuccess.jsp");
					rd.forward(request, response);
				}
			}

		}

		else if (action != null) {
			if (action.equalsIgnoreCase("searchOneOutPatient")) {
				String OPDNo = request.getParameter("OPDNo");
				PatientDAO pd = new PatientDAO();
				List<PatientBean> pList = pd.viewOneOutPatient(OPDNo);

				request.setAttribute("pList", pList);

				RequestDispatcher reqDisp = request
						.getRequestDispatcher("ViewOutPatient.jsp");
				reqDisp.forward(request, response);
			}
			if (action.equalsIgnoreCase("SearchOneInPatient")) {
				String OPDNo = request.getParameter("OPDNo");
				PatientDAO pd = new PatientDAO();
				List<PatientBean> pList = pd.viewOneInPatient(OPDNo);

				request.setAttribute("pList", pList);

				RequestDispatcher reqDisp = request
						.getRequestDispatcher("ViewInPatient.jsp");
				reqDisp.forward(request, response);
			}

			if (action.equalsIgnoreCase("updatePatient")) {
				String OPDNo1 = request.getParameter("OPDNo");
				PatientDAO pd1 = new PatientDAO();
				pd1.updatePatient(OPDNo1);
			}

			if (action.equalsIgnoreCase("searchdate")) {
				String doctorId = request.getParameter("doctorid");
				String givenDate = request.getParameter("date");

				AppointmentDAO appdao = new AppointmentDAO();
				List<PatientAppointment1> pList = appdao.viewAppointment(
						doctorId, givenDate);

				request.setAttribute("pList", pList);

				RequestDispatcher reqDisp1 = request
						.getRequestDispatcher("ViewAppointmentDetails.jsp");
				reqDisp1.forward(request, response);
			}
			if (action.equalsIgnoreCase("search")) {
				int opdNo = Integer.parseInt(request
						.getParameter("searchOpdNo"));

				PatientObservationDAO pod = new PatientObservationDAO();
				PatientObservation pobs = pod.ReadPatientObservation(opdNo);

				if (pobs != null) {
					request.setAttribute("patientObj", pobs);
					RequestDispatcher reqd = request
							.getRequestDispatcher("PatientObservationDetails.jsp");
					reqd.forward(request, response);
				} else {
					PrintWriter pwtr = response.getWriter();
					pwtr
							.print("<html><body><h3>Invalid opdNo</h3></body></html>");
				}
			}
			if (action.equalsIgnoreCase("Update")) {
				int opdNo = Integer.parseInt(request
						.getParameter("updateOpdNo"));
				String updateAdvices = request.getParameter("updateAdvices");
				String updatePrescription = request
						.getParameter("updatePrescription");

				PatientObservation updateObj = new PatientObservation(
						updateAdvices, updatePrescription);

				PatientObservationDAO pod1 = new PatientObservationDAO();
				int count = pod1.updateRecordOfSearchPatient(updateObj, opdNo);
				if (count != 0) {
					response.sendRedirect("UpdatedSuccess.jsp");
				} else {
					PrintWriter out = response.getWriter();
					out
							.print("<html><body>Update Operation is unsuccessful</body></html>");
				}
			}

		}

		
		
		
		//By DD
		
		try {

			if (request.getParameter("vieworcheck").equals("checkdetails")) {
				String opdNumber = request.getParameter("opdnumber");
				int opdn = Integer.parseInt(opdNumber);
				PatientDetailsDAO patientDAO = new PatientDetailsDAO();
				PatientBeanDD patient = new PatientBeanDD();

				patient = patientDAO.displayPatient(opdn);

				if (patient == null) {
					RequestDispatcher reqDisp = request
							.getRequestDispatcher("Fail.jsp");
					reqDisp.forward(request, response);

				} else {
					request.setAttribute("patients", patient);
					RequestDispatcher reqDisp = request
							.getRequestDispatcher("ShowDetails.jsp");
					reqDisp.forward(request, response);

				}
				patient=null;
				patientDAO=null;
			} else if (request.getParameter("vieworcheck").equals("view")) {

				request.setAttribute("pList", PatientDetailsDAO
						.viewAllPatients());

				RequestDispatcher reqDisp = request
						.getRequestDispatcher("ViewAllPatients.jsp");
				reqDisp.forward(request, response);
			}
			
			else if (request.getParameter("vieworcheck").equals("reg")) {
				String fname = request.getParameter("fname");
				String mname = request.getParameter("mname");
				String lname = request.getParameter("lname");
				String date = request.getParameter("dob");
				String gender = request.getParameter("gender");
				String bloodGroup = request.getParameter("bloodgroup");
				String fsname = request.getParameter("fsname");
				String address = request.getParameter("address");
				String phno = request.getParameter("phno");
				String email = request.getParameter("email");
				String isvisited = request.getParameter("isvisited");
				String disease = request.getParameter("disease");
				String specialization = request.getParameter("specialization");

				PatientBeanDD s = new PatientBeanDD();
				s.setFirstName(fname);
				s.setMiddleName(mname);
				s.setLastName(lname);
				s.setDateOfBirth(date);
				s.setFatherOrSpouseName(fsname);
				s.setGender(gender);
				s.setBloodGroup(bloodGroup);
				s.setAddress(address);
				s.setContactNo(phno);
				s.setEmailId(email);
				s.setIsVisitedEarlier(isvisited);
				s.setDisease(disease);
				s.setSpecialization(specialization);
				PatientDetailsDAO dao = new PatientDetailsDAO();
				dao.insertPatientDetails(s);
				PatientBeanDD opdno = dao.displayOpdNo();
				if (opdno != null) {
					request.setAttribute("opdno", opdno);
					RequestDispatcher reqDisp = request
							.getRequestDispatcher("RegistrationSuccess.jsp");
					reqDisp.forward(request, response);
				} else {
					System.out.println("Problem in displayOpdNo");
				}
				s=null;
				dao=null;
			} else if (request.getParameter("vieworcheck").equals("delete")) {
				
				String opdNumber = request.getParameter("opdno");
				int opdn = Integer.parseInt(opdNumber);
				PatientBeanDD s2 = new PatientBeanDD();
				s2.setOpdNumber(opdn);
				PatientDetailsDAO dao1 = new PatientDetailsDAO();
				
				int flag=dao1.deletePatientDetails(s2);
				
				if(flag==0){
					RequestDispatcher reqDisp = request
					.getRequestDispatcher("Fail.jsp");
					reqDisp.forward(request, response);

				}
				else{
					RequestDispatcher reqDisp = request
					.getRequestDispatcher("successdelete.jsp");
					reqDisp.forward(request, response);

				}
				s2=null;
				dao1=null;
			} else if (request.getParameter("vieworcheck").equals("loginfom")) {
				String userName = request.getParameter("userid");
				String password = request.getParameter("password");
				PatientDetailsDAO patientDAO = new PatientDetailsDAO();
				int check = patientDAO.checkFomLogin(userName, password);
				if (check == 1) {
					RequestDispatcher reqDisp = request
							.getRequestDispatcher("FOM_page.jsp");
					reqDisp.forward(request, response);
				} else {
					RequestDispatcher reqDisp = request
							.getRequestDispatcher("loginFail.jsp");
					reqDisp.forward(request, response);
				}
				patientDAO=null;
			}
			else if(request.getParameter("vieworcheck").equals("opdn")){
				String opdNumber = request.getParameter("opdnumber");
				int opdn = Integer.parseInt(opdNumber);
				PatientDetailsDAO patientDAO = new PatientDetailsDAO();
				PatientBeanDD patient = new PatientBeanDD();

				patient = patientDAO.displayPatientForUpdation(opdn);

				if (patient == null) {
					RequestDispatcher reqDisp = request
							.getRequestDispatcher("Fail.jsp");
					reqDisp.forward(request, response);

				} else {
					request.setAttribute("patients", patient);
					RequestDispatcher reqDisp = request
							.getRequestDispatcher("ShowDetailsAndUpdate.jsp");
					reqDisp.forward(request, response);

				}
				patient=null;
				patientDAO=null;
			}
			else if (request.getParameter("vieworcheck").equals("update")) {
				int opdn=Integer.parseInt(request.getParameter("opdnum"));
				String address=request.getParameter("address");
				String phno=request.getParameter("phno");
				String disease=request.getParameter("disease");
				PatientBeanDD patient=new PatientBeanDD();
				patient.setOpdNumber(opdn);
				patient.setAddress(address);
				patient.setContactNo(phno);
				patient.setDisease(disease);
				PatientDetailsDAO dao=new PatientDetailsDAO();
				int count=dao.updatePatient(patient);
				
				if(count==0){
					RequestDispatcher reqDisp = request
					.getRequestDispatcher("Fail.jsp");
					reqDisp.forward(request, response);

				}
				else{
					RequestDispatcher reqDisp = request
					.getRequestDispatcher("SuccessUpdate.jsp");
					reqDisp.forward(request, response);

				}
			}
			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		
		
		
		
	}

}
