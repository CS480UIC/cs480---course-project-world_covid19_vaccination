package VaccineSimple3.web.servlet;

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

import VaccineSimple3.dao.VaccineSimple3Dao;
import VaccineSimple3.domain.VaccineAvgProtectionByType;
import VaccineSimple3.service.VaccineSimple3Exception;
import VaccineSimple3.service.VaccineSimple3Service;

/**
 * Servlet implementation class UserServlet
 */

public class VaccineServletSimple3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VaccineServletSimple3() {
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

		VaccineSimple3Service vaccinesimple3service = new VaccineSimple3Service();
		
		try {
			request.setAttribute("AvgProtectionByTypeList", vaccinesimple3service.avgProtectionByType());

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
			List<Object> li = vaccinesimple3service.avgProtectionByType();
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/Queryresult/AvgProtectionByTypelist.jsp").forward(request, response);

	
	}

}
