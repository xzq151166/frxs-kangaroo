/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.kangaroo.platform.frxskangaroo.service.core.service.impl;

import com.frxs.kangaroo.platform.frxskangaroo.common.Enum.CodeType;
import com.frxs.kangaroo.platform.frxskangaroo.common.dto.TagMainDto;
import com.frxs.kangaroo.platform.frxskangaroo.common.entity.TagMain;
import com.frxs.kangaroo.platform.frxskangaroo.common.utils.CodeUtil;
import com.frxs.kangaroo.platform.frxskangaroo.common.wrapper.PageWrapper;
import com.frxs.kangaroo.platform.frxskangaroo.service.core.mapperStruts.TagmainMapperStruts;
import com.frxs.kangaroo.platform.frxskangaroo.service.core.service.TagMainService;
import com.frxs.kangaroo.platform.frxskangaroodal.mapper.TagMainMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author xzq
 * @version $Id: TagMainServiceImpl.java,v 0.1 2020年12月27日 20:52 $Exp
 */
@Slf4j
@Service
public class TagMainServiceImpl implements TagMainService {

	@Resource
	private TagMainMapper tagMainMapper;

	@Override
	public void create(TagMainDto record) {
		TagMain tagMain = TagmainMapperStruts.MAPPER.TagMainDto2TagMain(record);
		tagMain.setCode(CodeUtil.getCodeByType(CodeType.TAG.getCode()));
		tagMainMapper.insert(tagMain);
	}

	@Override
	public List<TagMainDto> getList(PageWrapper<TagMainDto> pageWrapper) {
		TagMainDto filter = pageWrapper.getFilter();
		if (filter == null) {
			pageWrapper.setFilter(new TagMainDto());
		}
		return tagMainMapper.getList(pageWrapper);
	}
}