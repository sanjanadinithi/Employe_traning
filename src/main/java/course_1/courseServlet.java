package course_1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/courseServlet")

public class courseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		
		System.out.print("dopost eke ekat awa");
		
		String cname = request.getParameter("course_name");
		String cDuration = request.getParameter("duration");
		String cInstructor = request.getParameter("instructor");
		String cDescription = request.getParameter("course_description");
		String cLink = request.getParameter("link");    
	
		boolean isTrue;
	
		isTrue = course_1DButil.createCourse( cname, cDuration, cInstructor, cDescription, cLink);	   	
	
		if(isTrue == true) {  
		
		System.out.print("data insert una");
		
		RequestDispatcher dis = request.getRequestDispatcher("/ViewServlet");
		dis.forward(request, response);

		
		} else {
			System.out.print("data giy nh");
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}

	}
}
