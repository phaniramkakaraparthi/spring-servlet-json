package phani.springframework.springservletjson.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import phani.springframework.springservletjson.entity.Employee;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employeeServlet")
public class EmployeeServlet extends HttpServlet{
	
	/**
	 * Generated serialID
	 */
	private static final long serialVersionUID = 3579035727303315796L;
	private Gson gson = new Gson();
	 
    @Override
    protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws IOException {
        
        Employee employee = new Employee(1, "Karan", "IT", 5000);
        String employeeJsonString = this.gson.toJson(employee);
 
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();   
    }
}
