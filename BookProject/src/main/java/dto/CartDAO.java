
package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import util.DBManager;

public class CartDAO {

	private CartDAO() {
	}

	private static CartDAO instance = new CartDAO();

	public static CartDAO getInstance() {
		return instance;
	}

	// 커넥션을 얻어오는 메소드
	public Connection getConnection() throws SQLException, NamingException {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}

	// 장바구니 리스트
	public List<CartVO> selectAllCarts() {
		String sql = "select * from cart where id = ? "; // 책에 저장된 전체 데이터들을 오름차순으로 정렬

		List<CartVO> list = new ArrayList<CartVO>(); 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection(); 
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); 
			pstmt.setString(1, "id");

			while (rs.next()) { 
				CartVO cVo = new CartVO(); 

				cVo.setCartnum(rs.getInt("cartnum"));
				cVo.setNum(rs.getInt("num")); 
				cVo.setId(rs.getString("id"));
				cVo.setPrice(rs.getInt("price"));
				cVo.setTitle(rs.getString("title"));
				cVo.setPictureurl(rs.getString("pictureurl"));

				list.add(cVo); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs); 
		}
		return list;
	}

	// id 조건 = cart리스트
	public CartVO selectBooksById(String id) {

		String sql = "SELECT * FROM cart WHERE id = ?";

		CartVO cVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection(); // 쿼리문을 실행하기 전에 커넥션 객체를 얻기 위해 DBManager클래스의 정적 메소드(getConnection())를 호출
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cVo = new CartVO();
				cVo.setCartnum(rs.getInt("cartnum"));
				cVo.setNum(rs.getInt("num")); // rs로 컬럼 값을 얻어온다. set()메소드를 호출해서 VO객체의 각 필드를 채운다
				cVo.setId(rs.getString("id"));
				cVo.setPrice(rs.getInt("price"));
				cVo.setTitle(rs.getString("title"));
				cVo.setPictureurl(rs.getString("pictureurl"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return cVo;
	}

//카트 추가
	public void insertCart(CartVO cVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into Cart values(cart_seq.nextval, ?, ?, ?, ?, ?) ";
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cVo.getNum());
			pstmt.setString(2,cVo.getId());
			pstmt.setInt(3,cVo.getPrice());
			pstmt.setString(4, cVo.getTitle());
			pstmt.setString(5, cVo.getPictureurl());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

}