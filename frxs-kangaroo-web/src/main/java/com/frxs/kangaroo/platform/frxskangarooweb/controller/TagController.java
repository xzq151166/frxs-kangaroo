package com.frxs.kangaroo.platform.frxskangarooweb.controller;

import com.frxs.kangaroo.platform.frxskangaroo.common.dto.TagMainDto;
import com.frxs.kangaroo.platform.frxskangaroo.common.wrapper.PageWrapper;
import com.frxs.kangaroo.platform.frxskangaroo.common.wrapper.annotation.ResponseWrapper;
import com.frxs.kangaroo.platform.frxskangaroo.service.core.service.TagMainService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tag")
@ResponseWrapper
public class TagController {
	@Resource
	private TagMainService tagMainService;

	@PostMapping("/create")
	public void create(@Validated @RequestBody TagMainDto record){
		tagMainService.create(record);
	}

	@PostMapping("/list/get")
	public List<TagMainDto> list(@RequestBody PageWrapper<TagMainDto> pageWrapper) {
		return tagMainService.getList(pageWrapper);
	}
}
