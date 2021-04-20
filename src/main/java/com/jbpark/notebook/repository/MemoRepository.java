package com.jbpark.notebook.repository;

import com.jbpark.notebook.domain.Memo;

public interface MemoRepository {
	void addMemo(Memo memo);
	int deleteMemo(int seqNo);
}
