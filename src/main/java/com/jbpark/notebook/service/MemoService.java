package com.jbpark.notebook.service;

import java.util.List;

import com.jbpark.notebook.domain.Memo;

public interface MemoService {
	void addMemo(Memo memo);

	/**
	 * Memo 테이블에서 메모를 제한적으로 읽어온다.
	 * @param maxMemos 최대 읽을 메모 건수
	 * @return
	 */
	List<Memo> getMemoLines(int maxMemos);

	int deleteMemo(int seqNo);
}
