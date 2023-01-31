package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class BookDAO {

	private BookDAO() {
	}

	public static BookDAO instance = new BookDAO();

	public static BookDAO getInstance() {

		return instance;
	}

	public BookVO selectOneBookByNum(int num) {
		String sql = "select * from book where num = ?";

		BookVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bVo = new BookVO();

				bVo.setNum(rs.getInt("num"));
				bVo.setCategory(rs.getString("category"));
				bVo.setTitle(rs.getString("title"));
				bVo.setPrice(rs.getInt("price"));
				bVo.setSummary(rs.getString("summary"));
				bVo.setAuthor(rs.getString("author"));
				bVo.setPub(rs.getString("pub"));
				bVo.setGrade(rs.getString("grade"));
				bVo.setPictureurl(rs.getString("pictureurl"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}

	public void updateBook(BookVO bVo) {
		String sql = "update book set category=?, title=?, price=?, "
				+ "summary=?, author=?, pub=?, grade=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getCategory());
			pstmt.setString(2, bVo.getTitle());
			pstmt.setInt(3, bVo.getPrice());
			pstmt.setString(4, bVo.getSummary());
			pstmt.setString(5, bVo.getAuthor());
			pstmt.setString(6, bVo.getPub());
			pstmt.setString(7, bVo.getGrade());
			pstmt.setInt(8, bVo.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public List<BookVO> selectAllBooks() {
		String sql = "select * from book order by num asc";

		List<BookVO> list = new ArrayList<BookVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BookVO bVo = new BookVO();

				bVo.setNum(rs.getInt("num"));
				bVo.setCategory(rs.getString("category"));
				bVo.setTitle(rs.getString("title"));
				bVo.setPrice(rs.getInt("price"));
				bVo.setSummary(rs.getString("summary"));
				bVo.setAuthor(rs.getString("author"));
				bVo.setPub(rs.getString("pub"));
				bVo.setGrade(rs.getString("grade"));
				bVo.setPictureurl(rs.getString("pictureurl"));
				list.add(bVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	public void deleteBook(int num) {
		String sql = "delete book where num = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	public void insertBook(BookVO bVo) {
		String sql = "insert into book values(Book_seq.nextval,?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getCategory());
			pstmt.setString(2, bVo.getTitle());
			pstmt.setInt(3, bVo.getPrice());
			pstmt.setString(4, bVo.getSummary());
			pstmt.setString(5, bVo.getAuthor());
			pstmt.setString(6, bVo.getPub());
			pstmt.setString(7, bVo.getGrade());
			pstmt.setString(8, bVo.getPictureurl());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}


	public List<BookVO> searchBook(String searchCategory, String keyWord) {

		List<BookVO> list = new ArrayList<>();
		BookVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from book where " + searchCategory.trim() + " like ?";
		sql += " order by num";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyWord.trim() + "%"); // '%keyWord%'
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bVo = new BookVO();

				bVo.setNum(rs.getInt("num"));
				bVo.setCategory(rs.getString("category"));
				bVo.setTitle(rs.getString("title"));
				bVo.setPrice(rs.getInt("price"));
				bVo.setSummary(rs.getString("summary"));
				bVo.setAuthor(rs.getString("author"));
				bVo.setPub(rs.getString("pub"));
				bVo.setGrade(rs.getString("grade"));

				list.add(bVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public int bookCount(String searchCategory, String keyWord) {

		int count = 0;
		String sql = "select count(*) as count  from book where " + searchCategory.trim() + " like ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyWord.trim() + "%");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("count");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
		
	}
	public List<BookVO> selectAllCategory() {
		String sql = "select distinct category from book";
	      
	      List<BookVO> list = new ArrayList<BookVO>();
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      
	      try {
	         conn = DBManager.getConnection();
	         stmt = conn.createStatement();
	         
	         rs = stmt.executeQuery(sql);
	         
	         while (rs.next()) {
	            BookVO bVo = new BookVO();
	            
	            bVo.setCategory(rs.getString("category"));
	            
	            list.add(bVo);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         DBManager.close(conn, stmt, rs);
	      }
	      return list;
	}
	
	public List<BookVO> selectBooksByCategory(String category) {
		String sql = "select * from book where category = ?";
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				bVo = new BookVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setCategory(rs.getString("category"));
				bVo.setTitle(rs.getString("title"));
				bVo.setPrice(rs.getInt("price"));
				bVo.setSummary(rs.getString("summary"));
				bVo.setAuthor(rs.getString("author"));
				bVo.setPub(rs.getString("pub"));
				bVo.setGrade(rs.getString("grade"));
				bVo.setPictureurl(rs.getString("pictureurl"));
				
				list.add(bVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<CartVO> getCartList(String id){
		List<CartVO> cartList = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select * " + " from cart " + " where id = ? ";
		
		
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			
			while(rs.next()) {
				cnt ++;
				if(cnt ==1) {
					cartList = new ArrayList<CartVO>();
				}
				CartVO cVo = new CartVO();
				cVo.setCartnum(rs.getInt("cartnum"));
				cVo.setNum(rs.getInt("num"));
				cVo.setId(rs.getString("id"));
				cVo.setPrice(rs.getInt("price"));
				cVo.setTitle(rs.getString("title"));
				cVo.setPictureurl(rs.getString("pictureurl"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return cartList;
	}
	

}
