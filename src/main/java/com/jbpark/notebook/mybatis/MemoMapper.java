package com.jbpark.notebook.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.jbpark.notebook.domain.Memo;

public interface MemoMapper {
	/**
	* 메모 한 건 맵퍼
	*/
	
	// @formatter:off
	@Select("select seqNo, substring(content, 1, 20) "
			+ "as content from memo " 
			+ "order by seqNo desc "
			+ "LIMIT #{maxMemos}")
	public List<Memo> getMemoLines(int maxMemos); 
	// @formatter:on
}
