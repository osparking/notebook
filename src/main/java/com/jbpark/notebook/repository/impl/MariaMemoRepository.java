package com.jbpark.notebook.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jbpark.notebook.domain.Memo;
import com.jbpark.notebook.repository.MemoRepository;

@Repository
public class MariaMemoRepository implements MemoRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public void addMemo(Memo memo) {
		String SQL = "INSERT INTO memo (content) "
				+ "values (:content)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("content", memo.getContent());
		int result = jdbcTemplate.update(SQL, params);
		System.out.println(result);
	}
}
