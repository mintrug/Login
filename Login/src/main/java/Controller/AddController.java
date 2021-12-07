package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import Model.DocGia;

/**
 * Servlet implementation class AddController
 */
@WebServlet("/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("currentSessionUser") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AddDocGia.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		if("Hủy".equals(request.getParameter("state"))) {
			response.sendRedirect("Welcome");
		}
		else {
			DocGia docGia = new DocGia();
			docGia.setMaDG(request.getParameter("MaDG"));
			docGia.setHoDG(request.getParameter("HoDG"));
			docGia.setTenDG(request.getParameter("TenDG"));
			docGia.setNgaySinh(request.getParameter("NgaySinh"));
			docGia.setGioiTinh(request.getParameter("GioiTinh"));
			docGia.setEmail(request.getParameter("Email"));
			docGia.setAnhDG(request.getParameter("AnhDG"));
			docGia.setMaLDG(request.getParameter("MaLDG"));
			
			try {
				UserDAO.addDocGia(docGia);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("Welcome");
		}
	}
}
