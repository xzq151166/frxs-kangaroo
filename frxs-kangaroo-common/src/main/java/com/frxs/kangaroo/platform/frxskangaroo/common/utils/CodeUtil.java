/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.kangaroo.platform.frxskangaroo.common.utils;

import com.frxs.kangaroo.platform.frxskangaroo.common.generator.CodeOrIdGenerator;

/**
 *
 * @author xzq
 * @version $Id: CodeUtil.java,v 0.1 2020年12月27日 20:40 $Exp
 */
public class CodeUtil {
	public static String getCodeByType(String type) {
		return type + CodeOrIdGenerator.DATE_TIME_ID.generateId();
	}
}