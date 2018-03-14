/**
 * 
 */
package study01b;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * 第一个 Servlet
 * 
 * @author zht
 */
// WebInitParam 初始化参数
@WebServlet(name = "MyServlet01", urlPatterns = { "/my" }, initParams = { @WebInitParam(name = "user_name", value = "admin zhao") })
public class MyServlet implements Servlet {

	private transient ServletConfig servletConfig;

	@Override
	public void destroy() {
		// 销毁 Servlet 时执行的方法
	}

	@Override
	public ServletConfig getServletConfig() {
		return servletConfig;
	}

	@Override
	public String getServletInfo() {
		return "我的第一个 Servlet, 2017-12-3";
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		// 第一次请求 Servlet 时执行的方法
		this.servletConfig = servletConfig;
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// 第一次请求 Servlet 时执行的方法
		// 每次请求 Servlet 时都会执行的方法
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String param = request.getParameter("param");

		String servletName = servletConfig.getServletName();
		response.setContentType("text/html");

		PrintWriter writer = response.getWriter();
		writer.print("<html><head></head><body>");
		writer.print(servletName);
		writer.print(" ");
		writer.print(sdf.format(new Date()));
		writer.print("<br />");
		writer.print(getServletInfo());
		writer.print("<br />");
		writer.print(param);
		writer.print("<br />");
		writer.print(servletConfig.getInitParameter("user_name"));			//获取初始化参数
		writer.print("</body></html>");
	}

}
