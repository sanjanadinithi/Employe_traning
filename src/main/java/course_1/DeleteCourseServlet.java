package course_1;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/DeleteCourseServlet")
public class DeleteCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.print("4 dopost eke ekat awa");		
		String cID = request.getParameter("cID");  
		
		boolean isTrue;
		isTrue = course_1DButil.deletecourse(cID);
		
		if(isTrue == true) { 
		
		System.out.print("data delete una");
		
		List<Course_1> courseDetails = course_1DButil.getAllCourse();  
        request.setAttribute("courseDetails", courseDetails);
        
		RequestDispatcher dis = request.getRequestDispatcher("courseCreate.jsp");
		dis.forward(request, response);

		
		} else {
			
			List<Course_1> courseDetails = course_1DButil.getupdatecourse(cID);
            request.setAttribute("courseDetails", courseDetails);
			
			System.out.print("data delete un nh");
			RequestDispatcher dis2 = request.getRequestDispatcher("courseCreate.jsp");
			dis2.forward(request, response);
		}
		
		doPost(request, response);
		
	}
	}

