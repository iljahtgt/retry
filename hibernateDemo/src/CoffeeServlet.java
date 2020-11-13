

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Coffees;
import model.CoffeesHome;

/**
 * Servlet implementation class CoffeeServlet
 */
@WebServlet("/CoffeeServlet")
public class CoffeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoffeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String id=request.getParameter("id");
		String cname=request.getParameter("cname");
		String price=request.getParameter("price");
		String sale=request.getParameter("sale");
		String total=request.getParameter("total");
		String method=request.getParameter("method");
		CoffeesHome home=new CoffeesHome();
		if(method.equals("add")) {
		Coffees c1=new Coffees(cname,Integer.parseInt(id),Double.parseDouble(price),Integer.parseInt(sale),Integer.parseInt(total));
		home.persist(c1);
		}
		if(method.equals("update")) {
			Coffees c1=new Coffees(cname,Integer.parseInt(id),Double.parseDouble(price),Integer.parseInt(sale),Integer.parseInt(total));
			home.merge(c1);
		}
		if(method.equals("remove")) {
			Coffees c1=new Coffees(cname,Integer.parseInt(id),Double.parseDouble(price),Integer.parseInt(sale),Integer.parseInt(total));
			home.delete(c1);
		}
		if(method.equals("find")) {
			Coffees c1=new Coffees(cname,Integer.parseInt(id),Double.parseDouble(price),Integer.parseInt(sale),Integer.parseInt(total));
			Coffees c=home.findById(c1.getCofName());
			List<Coffees> list=new ArrayList<>();
			list.add(c);
			request.setAttribute("coffees",list);
			request.getRequestDispatcher("viewhibernate.jsp").forward(request, response);
			return;
		}
		SessionFactory factory;
		try {
			factory=new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex) {
			System.out.println("ERROR"+ex);
			throw new ExceptionInInitializerError(ex);
		}
		Session session=factory.openSession();
		List<model.Coffees> list=(List<model.Coffees>)session.createQuery("from Coffees").list();
		request.setAttribute("coffees", list);
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
