/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.kangaroo.platform.frxskangaroo.common.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author xzq
 * @version $Id: BaseDto.java,v 0.1 2020年12月27日 20:56 $Exp
 */
@Data
public class BaseDto  implements Serializable {

	private String id;

	private Long createUserId;

	private String createUserName;

	private Long modifyUserId;

	private String modifyUserName;

	private Date tmCreate;

	private Date tmSmp;

}