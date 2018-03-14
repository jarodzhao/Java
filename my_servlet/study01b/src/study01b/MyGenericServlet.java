package study01b;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;

@WebServlet(name = "GenericServletTest",
urlPatterns = { "/mygeneric" },
initParams = {
		@WebInitParam(name = "admin", value = "pass"),
		@WebInitParam(name = "email", value = "jarodzhao@qq.com")
		}
)
public class MyGenericServlet extends GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.getWriter().write(getServletConfig().getInitParameter("admin"));
		response.getWriter().write(getServletConfig().getInitParameter("email"));
		
	}

}
