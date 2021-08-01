package people.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import people.domain.People;
import people.service.PeopleService;

/**
 * Servlet implementation class findAll
 */

public class PeoplefindAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	PeopleService peopleservice = new PeopleService();
	try {
		request.setAttribute("PeopleList", peopleservice.findall());
	} catch (InstantiationException | IllegalAccessException
			| ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		List<Object> li = peopleservice.findall();
		for(int i = 0; i < li.size();i++){
			System.out.println(li.get(i).toString());
		}
		
	} catch (InstantiationException | IllegalAccessException
			| ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	request.getRequestDispatcher("/Queryresult/Peoplelist.jsp").forward(request, response);
	}

}
