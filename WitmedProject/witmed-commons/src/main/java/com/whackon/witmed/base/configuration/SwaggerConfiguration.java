package com.whackon.witmed.base.configuration;

import com.whackon.witmed.base.util.BaseConstants;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * <b>基础信息功能 - Swagger API 文档框架配置文件类</b>
 *
 * @author Arthur
 * @date 2021/12/29
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
public class SwaggerConfiguration {

	/**
	 * <b>创建 Swagger 核心 对象</b>
	 * @return
	 */
	@Bean
	public Docket createRestAPI() {
		DocumentationType documentationType;
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				// 使用 Swagger 扫描所有方法级别的注解，加入到文档中
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}

	/**
	 * <b>生成文档接口信息</b>
	 * @return
	 */
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder()
				// 标题
				.title(BaseConstants.SWAGGER_TITLE)
				// 描述
				.description(BaseConstants.SWAGGER_DESCRIPTION)
				// 版本
				.version(BaseConstants.SWAGGER_VERSION)
				// 联系人
				.contact(new Contact(BaseConstants.SWAGGER_CONTACT_NAME
						, BaseConstants.SWAGGER_CONTACT_URL
						, BaseConstants.SWAGGER_CONTACT_EMAIL))
				.build();
		return apiInfo;
	}
}
