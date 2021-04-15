package com.jbpark.notebook.service.impl;

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
}
