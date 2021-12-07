package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.DocGia;
import Model.User;

public class UserDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static Statement stmt = null;
	
	public static User login(User user) throws SQLException {
		String username = user.getUsername();
		String password = user.getPassword();
		
		String searchQuery = "select * from Login where username='"
				+ username + "' and password='" + password + "'";
	    
		currentCon = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Thi60CNTT2_60137363;user=sa;password=sa");
		stmt = currentCon.createStatement();
		rs = stmt.executeQuery(searchQuery);
		boolean more = rs.next();
		
		if(!more) {
//			System.out.println("Sorry, you are not a registered user! Please sign up first");
			user.setValid(false);
		}
		else {
			user.setFirstName(rs.getString(3));
			user.setValid(true);
		}
		
		return user;
	}
	
	public static void register(User user) throws SQLException {
		String name = user.getFirstName();
		String username = user.getUsername();
		String password = user.getPassword();
		
		String query = "insert into Login values ('" + username + "', '" + password + "', N'" + name + "')";
//		System.out.println(query);
		currentCon = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Thi60CNTT2_60137363;user=sa;password=sa");
		stmt = currentCon.createStatement();
		stmt.executeUpdate(query);
	}
	
	public static List<DocGia> danhSach() throws SQLException {
		List<DocGia> list = new ArrayList<DocGia>();
		String query = "select a.*, b.TenLDG from DOCGIA a, LOAIDOCGIA b where a.MaLDG = b.MaLDG";
		currentCon = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Thi60CNTT2_60137363;user=sa;password=sa");
		stmt = currentCon.createStatement();
		rs = stmt.executeQuery(query);
		while(rs.next()) {
			DocGia docGia = new DocGia();
			docGia.setMaDG(rs.getString(1));
			docGia.setHoDG(rs.getString(2));
			docGia.setTenDG(rs.getString(3));
			docGia.setNgaySinh(rs.getString(4));
			docGia.setGioiTinh(rs.getString(5));
			docGia.setEmail(rs.getString(6));
			docGia.setAnhDG(rs.getString(7));
			docGia.setMaLDG(rs.getString(8));
			docGia.setTenLDG(rs.getString(9));
			
			list.add(docGia);
//			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " 
//					+ rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8) + " " 
//					+ rs.getString(9));
		}
		return list;
	}
	
	public static void addDocGia(DocGia docGia) throws SQLException {
		String maDG = docGia.getMaDG();
		String hoDG = docGia.getHoDG();
		String tenDG = docGia.getTenDG();
		String ngaySinh = docGia.getNgaySinh();
		String gioiTinh = docGia.getGioiTinh();
		String email = docGia.getEmail();
		String anhDG = docGia.getAnhDG();
		String maLDG = docGia.getMaLDG();
		
		String query = "insert into DOCGIA values ('" + maDG + "', N'" + hoDG + "', N'" + tenDG + "', '" + ngaySinh
				+ "', " + gioiTinh + ", '" + email + "', '" + anhDG + "', '" + maLDG + "')";
//		System.out.println(query);
		currentCon = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Thi60CNTT2_60137363;user=sa;password=sa");
		stmt = currentCon.createStatement();
		stmt.executeUpdate(query);
	}
	
	public static DocGia findDocGia(DocGia docGia) throws SQLException {
		String MaDG = docGia.getMaDG();
		String query = "select a.*, b.TenLDG from DOCGIA a, LOAIDOCGIA b where a.MaDG='" + MaDG + "' and a.MaLDG=b.MaLDG";
		currentCon = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Thi60CNTT2_60137363;user=sa;password=sa");
		stmt = currentCon.createStatement();
		rs = stmt.executeQuery(query);
		rs.next();
		
		docGia.setHoDG(rs.getString(2));
		docGia.setTenDG(rs.getString(3));
		docGia.setNgaySinh(rs.getString(4));
		docGia.setGioiTinh(rs.getString(5));
		docGia.setEmail(rs.getString(6));
		docGia.setAnhDG(rs.getString(7));
		docGia.setMaLDG(rs.getString(8));
		return docGia;
	}
	
	public static void editDocGia(DocGia docGia) throws SQLException {
		String maDG = docGia.getMaDG();
		String hoDG = docGia.getHoDG();
		String tenDG = docGia.getTenDG();
		String ngaySinh = docGia.getNgaySinh();
		String gioiTinh = docGia.getGioiTinh();
		String email = docGia.getEmail();
		String anhDG = docGia.getAnhDG();
		String maLDG = docGia.getMaLDG();
		
		String query = "update DOCGIA set HoDG=N'" + hoDG + "', TenDG=N'" + tenDG + "', NgaySinh='" + ngaySinh + 
				"', GioiTinh='" + gioiTinh + "', Email='" + email + "', AnhDG='" + anhDG + "', MaLDG='" + maLDG + 
				"' where MaDG='" + maDG + "'";
		currentCon = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Thi60CNTT2_60137363;user=sa;password=sa");
		stmt = currentCon.createStatement();
		stmt.executeUpdate(query);
	}
	
	public static void deleteDocGia(DocGia docGia) throws SQLException {
		String maDG = docGia.getMaDG();
		String query = "delete from DOCGIA where MaDG='" + maDG + "'";
		currentCon = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Thi60CNTT2_60137363;user=sa;password=sa");
		stmt = currentCon.createStatement();
		stmt.executeUpdate(query);
	}
	
	public static List<DocGia> searchDocGia(DocGia docGiaSearch) throws SQLException {
		List<DocGia> list = new ArrayList<DocGia>();
		String maDG = docGiaSearch.getMaDG();
		String hoDG = docGiaSearch.getHoDG();
		String tenDG = docGiaSearch.getTenDG();
		String query = "select a.*, b.TenLDG from DOCGIA a, LOAIDOCGIA b where (a.MaDG='" + maDG + "' or a.HoDG=N'" + hoDG + 
				"' or a.TenDG=N'" + tenDG + "') and a.MaLDG=b.MaLDG";
		
		currentCon = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Thi60CNTT2_60137363;user=sa;password=sa");
		stmt = currentCon.createStatement();
		rs = stmt.executeQuery(query);
		while(rs.next()) {
			DocGia docGia = new DocGia();
			docGia.setMaDG(rs.getString(1));
			docGia.setHoDG(rs.getString(2));
			docGia.setTenDG(rs.getString(3));
			docGia.setNgaySinh(rs.getString(4));
			docGia.setGioiTinh(rs.getString(5));
			docGia.setEmail(rs.getString(6));
			docGia.setAnhDG(rs.getString(7));
			docGia.setMaLDG(rs.getString(8));
			docGia.setTenLDG(rs.getString(9));
			
			list.add(docGia);
		}
		return list;
	}
}
