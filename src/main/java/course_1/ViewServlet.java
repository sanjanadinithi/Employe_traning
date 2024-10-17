package course_1;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print("2 dopost eke ekat awa");
		
		try {
            List<Course_1> courseDetails = course_1DButil.getAllCourse();  
            request.setAttribute("courseDetails", courseDetails);
            
            
            RequestDispatcher dis = request.getRequestDispatcher("courseCreate.jsp");
            dis.forward(request, response);
            
        } catch(Exception e) {
           
            request.setAttribute("errorMessage", "An error occurred while retrieving course details.");
            RequestDispatcher errorDispatcher = request.getRequestDispatcher("unsuccess.jsp");
            errorDispatcher.forward(request, response);
            
            e.printStackTrace();
        }
	}
	
}
