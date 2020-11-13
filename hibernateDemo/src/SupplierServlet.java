

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Suppliers;

/**
 * Servlet implementation class SupplierServlet
 */
@WebServlet("/SupplierServlet")
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		SessionFactory factory;
		try {
			factory=new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex) {
			System.out.println("Failed"+ex);
			throw new ExceptionInInitializerError(ex);
		}
		Session session=factory.openSession();
		List<Suppliers> list=(List<Suppliers>)session.createQuery("from Suppliers").list();
		request.setAttribute("suppliers", list);
		request.getRequestDispatcher("viewhibernate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
