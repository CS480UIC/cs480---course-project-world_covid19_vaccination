package complex3.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import complex3.dao.Complex3Dao;
import complex3.domain.Complex3;
import complex3.service.Complex3Exception;
import complex3.service.Complex3Service;

/**
 * Servlet implementation class UserServlet
 */

public class Complex3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Complex3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Map<String, String> form = new HashMap<String,String>();

		Complex3Service complex3Service = new Complex3Service();
		
		try {
			request.setAttribute("SumOfVaccinatedPeopleGreaterThan150000List", complex3Service.sumOfVaccinatedPeopleGreaterThan150000());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
		} 
		
		
		try {
			List<Object> li = complex3Service.sumOfVaccinatedPeopleGreaterThan150000();
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/Queryresult/SumOfVaccinatedPeopleGreaterThan150000list.jsp").forward(request, response);

	
	}

}
