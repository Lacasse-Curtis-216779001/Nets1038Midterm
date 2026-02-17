package midterm.cl.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import midterm.cl.dao.midtermDao;
import midterm.cl.model.midtermModel;

import java.io.IOException;

/**
 * Servlet implementation class midtermController
 */
@WebServlet("/midtermController")
public class midtermController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private midtermDao midDao;
	
	public void init() {
		midDao = new midtermDao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public midtermController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String Name = request.getParameter("Name");
		String Address = request.getParameter("Address");
		String ContactNumber = request.getParameter("ContactNumber");
		String Email = request.getParameter("Email");
		String Education = request.getParameter("Education");
		String Gender = request.getParameter("Gender");
		String DateAvailable = request.getParameter("DateAvailable");
		String Position = request.getParameter("Position");
		String Salary = request.getParameter("Salary");
		String Authorized = request.getParameter("Authorized");
		String Relatives = request.getParameter("Relatives");
		String Other = request.getParameter("Other");
		
		midtermModel model = new midtermModel();
		model.setName(Name);
		model.setAddress(Address);
		model.setContactNumber(ContactNumber);
		model.setEmail(Email);
		model.setEducation(Education);
		model.setGender(Gender);
		model.setDateAvailable(DateAvailable);
		model.setPosition(Position);
		model.setSalary(Salary);
		model.setAuthorized(Authorized);
		model.setRelatives(Relatives);
		model.setOther(Other);
		
		try{
			midDao.registerMidterm(model);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		response.sendRedirect("MidtermRedirect.html");
	}

}
