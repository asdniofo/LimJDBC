package com.elon.jdbc.day03.pstmt.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.elon.jdbc.day03.pstmt.member.common.JDBCTemplate;
import com.elon.jdbc.day03.pstmt.member.model.dao.MemberDAO;
import com.elon.jdbc.day03.pstmt.member.model.vo.Member;

public class MemberService {
	private JDBCTemplate jdbcTemplate;
	private MemberDAO mDao;

	public MemberService() {
		jdbcTemplate = JDBCTemplate.getInstance();
		mDao = new MemberDAO();
	}

	public List<Member> selectList() {
		Connection conn = jdbcTemplate.getConnection();
		List<Member> mList = null;
		try {
			mList = mDao.selectList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}

	public Member selectOneById(String memberId) {
		Connection conn = jdbcTemplate.getConnection();
		Member member = null;
		try {
			member = mDao.selectOneById(memberId, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}

	public int insertMember(Member member) {
		Connection conn = jdbcTemplate.getConnection();
		int result = 0;
		try {
			result = mDao.insertMember(member, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int updateMember(Member member) {
		Connection conn = jdbcTemplate.getConnection();
		int result = 0;
		try {
			result = mDao.updateMember(member, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int deleteMember(String memberId) {
		Connection conn = jdbcTemplate.getConnection();
		int result = 0;
		try {
			result = mDao.deleteMember(memberId, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
