/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.kangaroo.platform.frxskangaroo.common.Enum;

/**
 * 统一包装的包装类型枚举
 * @author xzq
 * @version $Id: wrapperType.java,v 0.1 2020年12月27日 17:10 $Exp
 */
public enum WrapperType {NEED_WRAPPER("need_wrapper", "营销未知异常");
	/**
	 * 枚举编码
	 */
	private String code;

	/**
	 * 描述说明
	 */
	private String desc;

	WrapperType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}


	public String getDesc() {
		return desc;
	}

}