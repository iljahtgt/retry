

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private   SessionFactory factory;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Session session = factory.openSession();

// Query query = session.createQuery("from Coffees where price > :id ");
		List list = session.createQuery("FROM Coffees").list();
		// query.setParameter("id", 0);

		// You can replace the above to commands with this one
		// Query query = session.createQuery("from Student where studentId = 1 ");
// List<model.Coffees> list = query.list();

		model.Coffees cf = (model.Coffees) list.get(0);
		model.Coffees cf1 = (model.Coffees) list.get(1);
		model.Coffees cf2 =(model.Coffees)list.get(2);
		model.Coffees cf3 =(model.Coffees)list.get(3);

		System.out.println(list);
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet QueryServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet QueryServlet at " + cf.toString() + "</h1>");
			out.println("<h1>Servlet QueryServlet at " + cf1.toString() + "</h1>");
			out.println("<h1>Servlet QueryServlet at" + cf2.toString()+"</h1>");
			out.println("<h1>Servlet QueryServlet at" + cf3.toString()+"</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
