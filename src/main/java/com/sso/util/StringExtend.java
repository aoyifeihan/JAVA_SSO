package com.sso.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class StringExtend {
	/**
	 * ��ȡ���з������ֲ�ͬϵͳ /r Mac��/n Unix/Linux��/r/n Windows
	 * 
	 * @return
	 * @author
	 */
	public static String getEnterMark() {
		return System.getProperty("line.separator");
	}

	/**
	 * �����λ�ո�
	 * 
	 * @return
	 */
	public static String trim(String msg) {
		if (msg == null)
			return null;
		return msg.trim();
	}

	/**
	 * �ַ������ݸ�ʽ��������ڲ�ʹ��{0}\{1}\{2}...Ϊ����ռλ��</br>
	 * ������ʽ��ArgumentIndex[,FormatType[,FormatStyle]] </br>
	 * FormatType ȡֵ:number,date��time��choice </br>
	 * FormatType ��ʽ���磺#.## </br>
	 * ע��'{' �����������(��д�����Żᱨ������д�һ����Ž��������)</br>
	 * 
	 * @param msg
	 *            ��ʽ��ģ��
	 * @param args
	 *            ���̶�����
	 * @return
	 */
	public static String format(String msg, Object... args) {
		return java.text.MessageFormat.format(msg, args);
	}

	/**
	 * ת���ַ�����
	 * 
	 * @param num
	 * @return
	 * @author xxj
	 */
	public static Integer getInt(String num) {
		if (num == null || num.trim().isEmpty())
			return 0;
		if (!num.matches("^(\\d|-)\\d{0,9}$"))
			return 0;
		try {
			return Integer.parseInt(num);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	public static String getString(Object obj) {
		return obj == null ? null : obj.toString();
	}

	public static String getString(Integer num) {
		return getString(num, "");
	}

	public static String getString(Integer num, String def) {
		if (num == null)
			return def;
		return num.toString();
	}

	/*
	 * public static String getString(Date date){ return
	 * DateExtend.getString(date); }
	 */
	/**
	 * �ַ����Ƿ�Ϊ��
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	/**
	 * �Ƚ������ַ����Ƿ���ȣ����Դ�Сд
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 * @author xxj
	 */
	public static boolean equalsIgnoreCase(String str1, String str2) {
		String tmp = str1 == null ? "" : str1;
		return tmp.equalsIgnoreCase(str2);
	}

	/**
	 * md5 ����
	 * 
	 * @param str
	 * @return
	 * @author xxj 2017��4��24��
	 */
	public static String getMd5(String... str) {
		if (str == null || str.length == 0)
			return "";
		StringBuffer sbr = new StringBuffer();
		for (String item : str) {
			sbr.append(item);
		}
		// ����һ��MD5���ܼ���ժҪ
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			// ����md5����
			md.update(sbr.toString().getBytes());
			// digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
			// BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
			return new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * ɾ����ʼ�ַ�
	 * 
	 * @param s
	 * @return
	 * @author xxj 2017��4��27��
	 */
	public static String trimStart(String str, String trim) {
		if (str == null)
			return null;
		return str.replaceAll("^(" + trim + ")+", "");
	}

	/**
	 * ɾ��ĩβ�ַ�
	 * 
	 * @param s
	 * @return
	 * @author xxj 2017��4��27��
	 */
	public static String trimEnd(String str, String trim) {
		if (str == null)
			return null;
		return str.replaceAll("(" + trim + ")+$", "");
	}

	/**
	 * ���ַ���ͷ
	 * 
	 * @param s
	 * @return
	 * @author xxj 2017��4��27��
	 */
	public static boolean startWith(String str, String s) {
		return str.startsWith(s);
	}

	/**
	 * ���ַ�ĩβ
	 * 
	 * @param s
	 * @return
	 * @author xxj 2017��4��27��
	 */
	public static boolean endWith(String str, String s) {
		return str.endsWith(s);
	}

	/**
	 * ��ȡ boolean ֵ��1=true��True=true����
	 * 
	 * @param str
	 * @return
	 * @author xxj 2017��5��2��
	 */
	public static boolean getBoolean(String str) {
		if (isNullOrEmpty(str))
			return false;

		Pattern pattern = Pattern.compile("(1)|(true)", Pattern.CASE_INSENSITIVE);
		if (pattern.matcher(str).matches())
			return true;

		return false;
	}

	/**
	 * ���������˺ź�6λ
	 * 
	 * @param str
	 * @return
	 */
	public static String bankAccount(String str) {
		if (isNullOrEmpty(str)) {
			return null;
		}

		if (str.length() > 6) {
			return str.substring(0, str.length() - 6) + "xxxxxx";
		}
		return str;
	}

	/**
	 * ����λ������ǰ�油0������num�ĳ���λ����
	 * 
	 * @param code
	 * @return
	 */
	public static String autoGenericCode(String code, int num) {
		String result = "";
		// ����num��λ��
		// 0 ����ǰ�油��0
		// num ������Ϊ4
		// d �������Ϊ������
		result = String.format("%0" + num + "d", Integer.parseInt(code));

		return result;
	}
}