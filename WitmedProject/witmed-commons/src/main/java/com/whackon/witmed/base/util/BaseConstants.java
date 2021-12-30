package com.whackon.witmed.base.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Properties;

/**
 * <b>基础信息功能 - 基础常量类</b>
 *
 * @author Arthur
 * @date 2021/12/30
 * @version 1.0.0
 * @since 1.0.0
 */
public class BaseConstants {
	private static Properties props = new Properties();
	// 创建日志对象
	private static Logger logger = LoggerFactory.getLogger(BaseConstants.class);

	static {
		try {
			props.load(BaseConstants.class.getClassLoader().getResourceAsStream("props/base/base.properties"));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage() + " : " + new Date(), e);
		}
	}

	/**
	 * <b>Swagger 配置信息：文档标题</b>
	 */
	public static final String SWAGGER_TITLE = props.getProperty("swagger.title");

	/**
	 * <b>Swagger 配置信息：文档描述</b>
	 */
	public static final String SWAGGER_DESCRIPTION = props.getProperty("swagger.description");

	/**
	 * <b>Swagger 配置信息：文档版本</b>
	 */
	public static final String SWAGGER_VERSION = props.getProperty("swagger.version");

	/**
	 * <b>Swagger 配置信息：联系人姓名</b>
	 */
	public static final String SWAGGER_CONTACT_NAME = props.getProperty("swagger.contact.name");

	/**
	 * <b>Swagger 配置信息：联系人 URL 地址</b>
	 */
	public static final String SWAGGER_CONTACT_URL = props.getProperty("swagger.contact.url");

	/**
	 * <b>Swagger 配置信息：联系人电子邮件</b>
	 */
	public static final String SWAGGER_CONTACT_EMAIL = props.getProperty("swagger.contact.email");
}
