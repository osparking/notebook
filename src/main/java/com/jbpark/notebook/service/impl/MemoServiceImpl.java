package com.jbpark.notebook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbpark.notebook.domain.Memo;
import com.jbpark.notebook.repository.impl.MariaMemoRepository;
import com.jbpark.notebook.service.MemoService;

@Service
public class MemoServiceImpl implements MemoService {
	@Autowired
	MariaMemoRepository mariaMemoRepository;
	
	@Override
	public void addMemo(Memo memo) {
		mariaMemoRepository.addMemo(memo);
	}

	@Override
	public List<Memo> getMemoLines(int maxMemos) {
		return mariaMemoRepository.getMemoLines(maxMemos);
	}

	@Override
	public int deleteMemo(int seqNo) {
		return mariaMemoRepository.deleteMemo(seqNo);
	}
}
