package com.jbpark.notebook.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
		String SQL = "INSERT INTO memo (content) " + "values (:content)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("content", memo.getContent());
		int result = jdbcTemplate.update(SQL, params);
		System.out.println(result);
	}

	// @formatter:off
	public List<Memo> getMemoLines(int maxMemos) {
		String SQL = "select seqNo, "
				+ "substring(content, 1, 20) as content "
				+ "from memo "
				+ "order by seqNo desc "
				+ "LIMIT :maxMemos";
		List<Memo> memoLines = jdbcTemplate.query(SQL, 
				new MapSqlParameterSource("maxMemos", maxMemos),
				new MemoRowMapper());
		return memoLines;
	}
	// @formatter:on
}

class MemoRowMapper implements RowMapper<Memo> {
	public Memo mapRow(ResultSet rs, int index) throws SQLException {
		Memo memo = new Memo();
		memo.setSeqNo(rs.getInt("seqNo"));
		memo.setContent(rs.getString("content"));
		return memo;
	}
}