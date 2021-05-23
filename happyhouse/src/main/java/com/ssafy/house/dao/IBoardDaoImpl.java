package com.ssafy.house.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.house.dto.BoardDto;

@Repository
public class IBoardDaoImpl implements IBoardDao {
	
	private String ns="com.ssafy.house.dao.BoardMapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardDto> findAllBoard() throws Exception {
		return sqlSession.selectList(ns+"findAllBoard");
	}

	@Override
	public BoardDto detailBoard(int bid) throws Exception {
		return sqlSession.selectOne(ns+"detailBoard", bid);
	}

	@Override
	public void addBoard(BoardDto board) throws Exception {
		sqlSession.insert(ns+"addBoard", board);
	}

	@Override
	public boolean updateBoard(BoardDto board) throws Exception {
		sqlSession.update(ns+"updateBoard", board);
		return true;
	}

	@Override
	public boolean deleteBoard(int bid) throws Exception {
		sqlSession.delete(ns+"deleteBoard", bid);
		return true;
	}

	@Override
	public List<BoardDto> searchBoard(BoardDto board) throws Exception {
		return sqlSession.selectList(ns+"searchBoard", board);
	}

}
