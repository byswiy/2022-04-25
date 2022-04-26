package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.MemberDTO;

// DAO는 데이터베이스와 커뮤니케이션
// 쿼리를 실행하고 결과를 받아오는 것이 핵심
// 그 이상을 해도 되지만 
// 좀 더 완벽한 객체 지향적으로 개발하려면
// 쿼리를 실행하고 결과만 받아오도록 해야함

public class MemberDAO {
	public MemberDTO selectMemberInfo(MemberDTO memberDto) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM usrinfo WHERE id = ? AND pw = ? ";
		
		// try 밖에 생성한 이유 :  쿼리를 실행하다 문제가 생겨 예외가 발생할 경우 생기는 문제를 막기위해
		MemberDTO returnMemberInfo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(1, memberDto.getPw());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");

				String name = rs.getString("name");
				returnMemberInfo = new MemberDTO(id, pw, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closeResultSet(rs);
			Database.closePstmt(pstmt);
			Database.closeConn(conn);
		}
		return returnMemberInfo;
	}
	
	public boolean insertMemberInfo(MemberDTO memberInfo) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO userinfo(`id`, `pw`, `name`) VALUES(?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberInfo.getId());
			pstmt.setString(2, memberInfo.getPw());
			pstmt.setString(3, memberInfo.getName());
			
			int count = pstmt.executeUpdate();
			
			return count == 1;
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
			
			return false;
		} finally {
			Database.closePstmt(pstmt);
			Database.closeConn(conn);
		}
		
		
	}
}
