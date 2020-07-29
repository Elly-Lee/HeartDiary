package com.heartDiary.elly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diary {
	private int id;
	private String regDate;
	private String loginId;
	private int memberId;
	private String title;
	private String body;
}
