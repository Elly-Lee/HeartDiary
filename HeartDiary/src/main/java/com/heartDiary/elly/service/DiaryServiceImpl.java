package com.heartDiary.elly.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heartDiary.elly.dao.DiaryDao;
import com.heartDiary.elly.dto.Diary;
import com.heartDiary.elly.util.CUtil;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	private DiaryDao diaryDao;

	@Override
	public List<Diary> getDiaries() {
		return diaryDao.getDiaries();
	}

	@Override
	public Diary getDiary(int id) {
		return diaryDao.getDiary(id);
	}

	@Override
	public Map<String, Object> write(Map<String, Object> param) {
		diaryDao.writeDiary(param);
		int id = CUtil.getAsInt(param.get("id"));
		Map<String,Object> data = new HashMap<>();
		
		data.put("resultCode", "S-1");
		data.put("msg", "일기 업데이트 완료 :)");
		
		return data;
	}

	@Override
	public Map<String, Object> deleteDiary(int id) {
		diaryDao.deleteDiary(id);
		
		Map<String,Object> data = new HashMap<>();
		
		data.put("resultCode", "S-1");
		data.put("msg", "삭제완료. 리스트로 돌아갑니다.");
		
		return data;
	}

	@Override
	public Map<String, Object> modifyDiary(Map<String, Object> param) {
		diaryDao.modifyDiary(param);
		int id = CUtil.getAsInt(param.get("id"));
		Map<String,Object> data = new HashMap<>();
		
		data.put("resultCode", "S-1");
		data.put("msg", "일기장 수정. 리스트로 돌아갑니다.");
		
		return data;
	}
	
}
