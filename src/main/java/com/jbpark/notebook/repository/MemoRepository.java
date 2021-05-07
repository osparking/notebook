package com.jbpark.notebook.repository;

import java.util.List;

import com.jbpark.notebook.domain.Memo;

public interface MemoRepository {
	void addMemo(Memo memo);
	int deleteMemo(int seqNo);
	List<Memo> getMemoLines(int maxMemos) throws Exception;
}
