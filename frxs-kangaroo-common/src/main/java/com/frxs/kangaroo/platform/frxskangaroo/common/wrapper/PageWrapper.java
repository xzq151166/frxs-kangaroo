/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.kangaroo.platform.frxskangaroo.common.wrapper;

import com.frxs.kangaroo.platform.frxskangaroo.common.base.BaseDto;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author xzq
 * @version $Id: PageWrapper.java,v 0.1 2020年12月27日 21:30 $Exp
 */
@Data
public class PageWrapper<T extends BaseDto> implements Serializable {
	/**
	 * 页码
	 */
	private Integer page = 1;
	/**
	 * 每页显示的数量
	 */
	private Integer rows = 10;
	/**
	 * 每页显示的数量
	 */
	private Integer offset = 0;
	/**
	 * 筛选条件
	 */
	private T filter;
}