package com.jbpark.notebook.repository.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jbpark.notebook.domain.Memo;
import com.jbpark.notebook.mybatis.MemoMapper;
import com.jbpark.notebook.repository.MemoRepository;

@Repository
public class MariaMemoRepository implements MemoRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private static SqlSession getSqlSession() {
		// @formatter:off
		String resource = "java-mybatis-config.xml";
		InputStream inputStream;
		SqlSession session = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory 
				= new SqlSessionFactoryBuilder().build(inputStream);
			sqlSessionFactory.getConfiguration().addMapper(MemoMapper.class);
			session = sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
		// @formatter:on
	}
	
	// @formatter:off
	@Override
	public void addMemo(Memo memo) {
		String SQL = "INSERT INTO memo (content) " 
				+ "values (:content)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("content", memo.getContent());
		int result = jdbcTemplate.update(SQL, params);
	}

	@Override
	public List<Memo> getMemoLines(int maxMemos) { 
		MemoMapper memoMapper 
			= getSqlSession().getMapper(MemoMapper.class);
		return memoMapper.getMemoLines(maxMemos);
	}
	// @formatter:on

	public int deleteMemo(int seqNo) {
		String SQL = "delete from memo where seqNo = :seqNo";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("seqNo", seqNo);
		return jdbcTemplate.update(SQL, paramMap);
	}
}
