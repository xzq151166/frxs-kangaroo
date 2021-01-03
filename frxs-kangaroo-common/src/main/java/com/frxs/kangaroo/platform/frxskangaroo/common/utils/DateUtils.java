package com.frxs.kangaroo.platform.frxskangaroo.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/***
 * @author sh
 */
@Slf4j
public class DateUtils {

	private static final String START = "00:00:00";
	public static final String MIN_START = "1900-01-01";
	public static final String MAX_END = "3000-01-01";
	private static final String END = "23:59:59";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String YYYY = "yyyy";
	public static final String UTC_FORMAT = "yyyy-MM-dd HH:mm:ss:SSS";

	private static SimpleDateFormat getSdfInstance() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}



	/**
	 * 获取当天日期 String
	 * @param format
	 *            日期格式
	 * @return
	 *            当天日期
	 */
	public static String getToday(String format) {
		return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
	}

	/**
	 * 获取明天日期 String
	 * @param format
	 *            日期格式
	 * @return
	 *            明天日期
	 */
	public static String getSecondDay(String format) {
		return LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern(format));
	}


	public static String getDateStr(Date date) {
		if (date == null) {
			return null;
		}
		return getSdfInstance().format(date);
	}

	public static String getStrByDate(Date date, String sdfstr) {
		SimpleDateFormat sf = new SimpleDateFormat(sdfstr);
		return sf.format(date);
	}

	public static String getNowString(){
		SimpleDateFormat sf = new SimpleDateFormat(YYYYMMDD);
		//获取今天的日期
		return sf.format(new Date());
	}




}
