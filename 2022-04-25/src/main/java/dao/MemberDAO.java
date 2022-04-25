package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.MemberDTO;

public class MemberDAO {
	public boolean insertMemberInfo(MemberDTO memberInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO usrinfo(id, pw, name) VALUES(?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberInfo.getId());
			pstmt.setString(2, memberInfo.getPw());
			pstmt.setString(3, memberInfo.getName());
			
			int count = pstmt.executeUpdate();
			
			return count == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		
		
	}
}
