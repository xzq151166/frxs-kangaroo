/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.kangaroo.platform.frxskangaroo.common.generator;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author xzq
 * @version $Id: CodeUtil.java,v 0.1 2020年12月27日 20:40 $Exp
 */
public enum CodeOrIdGenerator {
	/**
	 * @Author: lgz
	 * @Date: 2020/5/24 23:44
	 */
		//有年月日的时间id
		DATE_TIME_ID {
			public long generateId() {
				return Long.parseLong(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")
						.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(super.generateId()), ZoneId.systemDefault())));
			}
		},
		//直接返回时间戳
		TIMESTAMP_ID {
			public long generateId() {
				return super.generateId();
			}
		},
		//时间戳左移10
		SHIFT_ID {
			public long generateId() {
				return super.generateId() << 10;
			}
		};


		//上一次的时间戳
		//在集群环境中，可以使用redis存储上一次时间
		private long lastTimestamp = -1L;

		//在集群环境中，可以使用分布式锁
		private Lock lock = new ReentrantLock();

		private long nowTimestamp;

		public long generateId() {
			lock.lock();
			nowTimestamp = 0;
			try {
				nowTimestamp = Instant.now().toEpochMilli();
				if (lastTimestamp == nowTimestamp) {
					lastTimestamp = waitNextMilli();
				} else if (lastTimestamp > nowTimestamp) {
					throw new RuntimeException("time error when generated the id.");
				} else {
					lastTimestamp = nowTimestamp;
				}
			} finally {
				lock.unlock();
			}
			if (nowTimestamp == 0) {
				throw new RuntimeException("unknown error when generated the id.");
			}

			return nowTimestamp;
		}

		private long waitNextMilli() {
			//判断是否进入下一毫秒
			//如果并发量特别高，会给cpu带来额外负荷
			do {
				nowTimestamp = Instant.now().toEpochMilli();
			} while (nowTimestamp == lastTimestamp);
			return nowTimestamp;

		}
}