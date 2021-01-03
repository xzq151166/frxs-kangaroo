/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.kangaroo.platform.frxskangaroo.service.core.service;

import com.frxs.kangaroo.platform.frxskangaroo.common.dto.TagMainDto;
import com.frxs.kangaroo.platform.frxskangaroo.common.wrapper.PageWrapper;

import java.util.List;

/**
 *
 * @author xzq
 * @version $Id: TagMainService.java,v 0.1 2020年12月27日 20:46 $Exp
 */
public interface TagMainService {
	void create(TagMainDto record);
	List<TagMainDto> getList(PageWrapper<TagMainDto> pageWrapper);
}