package service;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberService {
	
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
			return 200;
		} else {
			return 409;
		}
//		return result;
	}
}
