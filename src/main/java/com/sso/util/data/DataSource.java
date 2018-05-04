package com.sso.util.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * RUNTIME ����������ע�ͼ�¼�����ļ��У�������ʱ VM ������ע�ͣ���˿��Է����Եض�ȡ��
 * 
 * @author yangGuang
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface DataSource {
	String value();
}
