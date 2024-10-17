package course_1;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateCourseServlet")

public class UpdateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print("2 dopost eke ekat awa");
		
		String cID = request.getParameter("cID");
		String cname = request.getParameter("cname");
		String cDuration = request.getParameter("cDuration");
		String cInstructor = request.getParameter("cInstructor");
		String cDescription = request.getParameter("cDescription");
		String cLink = request.getParameter("cLink");    
	
		
		boolean isTrue;
		
		isTrue = course_1DButil.updateCourse( cID, cname, cDuration, cInstructor, cDescription, cLink);	   
		
		if(isTrue == true) {
			
			List<Course_1> allCourses = course_1DButil.getAllCourse();
            request.setAttribute("courseDetails", allCourses);
            
			RequestDispatcher dis = request.getRequestDispatcher("courseCreate.jsp");
			dis.forward(request, response);
		}
		else {
			
			 List<Course_1> updatedCourse = course_1DButil.getupdatecourse(cID);
	         request.setAttribute("courseDetails", updatedCourse);
			
			RequestDispatcher dis = request.getRequestDispatcher("courseCreate.jsp");
			dis.forward(request, response);
		}

	
		doPost(request, response);
	}

}
