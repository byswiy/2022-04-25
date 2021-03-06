package service;

import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

// POJO (Plain Old Java Object)
// 순수 자바 코드로만 이루어진 소스 파일
public class MemberService {
	public boolean login(MemberDTO memberDto) {
		// 로그인 처리
		MemberDAO dao = new MemberDAO();
		
		MemberDTO selectedMemberDTO = dao.selectMemberInfo(memberDto);
		
		if(selectedMemberDTO == null) {
			// 로그인 실패 처리
			return false;
		} else {
			// 로그인 성공 처리
			return true;
		}
	}
	
	public int join(MemberDTO newMemberInfo) {
		// 회원 가입 처리
		MemberDAO dao = new MemberDAO();
		
		boolean result = dao.insertMemberInfo(newMemberInfo);
		
		// 회원 가입 처리 결과 반환
		// 회원 가입 성공 : ~~ 반환 / 상태코드 201 반환
		// 회원 가입 실패
		// 1. 이미 사용중인 아이디 : ~~ 반환 / 409 반환
		// 결과가 성공 / 실패 두 가지 경우이기 때문에 boolean 타입으로 return result를 해줘도 된다
		// 결과를 boolean이 아닌 상태코드를 전달해줄 수 있다
		
		if(result) {
			return HttpServletResponse.SC_CREATED;
		} else {
			return HttpServletResponse.SC_CONFLICT;
		}
//		return result;
	}
}
