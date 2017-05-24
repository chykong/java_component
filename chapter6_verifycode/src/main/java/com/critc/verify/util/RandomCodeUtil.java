package com.critc.verify.util;

import java.util.Random;

/**
 * 
 * 功能描述:随机数生成工具
 * 
 * @version 1.0.0
 * @author 孔垂云
 * @2015年3月4日
 */
public class RandomCodeUtil {
	private static final char[] codeSequenceRandom = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4',
			'5', '6', '7', '8', '9', '0' };
	private static final char[] numberSequenceRandom = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

	/**
	 * 
	 * 功能描述:生成字符串随机数
	 * 
	 * @return String
	 * @version 1.0.0
	 * @author 孔垂云
	 */
	public static String createRandomCode(int count) {
		String serialNum = "";
		Random random = new Random();
		for (int i = 0; i < count; i++) {
			String strRand = String.valueOf(codeSequenceRandom[random.nextInt(codeSequenceRandom.length)]);
			serialNum += strRand;
		}
		return serialNum;
	}

	/**
	 * 生成数字随机数
	 * @param count
	 * @return
	 */
	public static String createRandomNum(int count) {
		String serialNum = "";
		Random random = new Random();
		for (int i = 0; i < count; i++) {
			String strRand = String.valueOf(numberSequenceRandom[random.nextInt(numberSequenceRandom.length)]);
			serialNum += strRand;
		}
		return serialNum;
	}

}
