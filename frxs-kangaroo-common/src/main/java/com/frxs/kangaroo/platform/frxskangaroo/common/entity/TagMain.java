package com.frxs.kangaroo.platform.frxskangaroo.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagMain {
    private String name;

    private String code;

	private String id;

	private Long createUserId;

	private String createUserName;

	private Long modifyUserId;

	private String modifyUserName;

	private Date tmCreate;

	private Date tmSmp;

}