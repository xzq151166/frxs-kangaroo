package com.frxs.kangaroo.platform.frxskangaroo.common.dto;

import com.frxs.kangaroo.platform.frxskangaroo.common.base.BaseDto;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TagMainDto extends BaseDto {

	@NotNull(message = "name不能为空.")
	private String name;

	private String code;

}
