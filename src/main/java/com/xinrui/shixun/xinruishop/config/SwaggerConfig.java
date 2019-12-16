package com.xinrui.shixun.xinruishop.config;

import com.google.common.base.Predicate;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
// 开启 swagger2 功能
@EnableSwagger2
// 指定扫描的包路径
@ComponentScan(basePackages = {"com.xinrui.shixun.xinruishop.web"})
public class SwaggerConfig {

	private final String	name	= "auther";
	private final String	url		= "×××××";
	private final String	email	= "you@163.com";
	// 是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
	@Value(value = "${swagger.enabled}")
	private Boolean	swaggerEnabled;

	@Bean
	public Docket restApiDocket() {

		Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
			@Override
			public boolean apply(RequestHandler input) {
				//只有添加了ApiOperation注解的method才在API中显示
				if (input.isAnnotatedWith(ApiOperation.class))
					return true;
				return false;
			}
		};

		return new Docket(DocumentationType.SWAGGER_2) //
				.apiInfo(apiInfo()) // 用来创建该Api的基本信息（这些基本信息会展现在文档页面中）
				.enable(swaggerEnabled)// 是否开启
				.select()
				.apis(predicate)
				.paths(PathSelectors.any())// 指定路径处理PathSelectors.any()代表所有的路径
				.build();// 创建
	}

	/**
	 * @方法描述:构建 api文档的详细信息函数
	 * @return
	 */
	private ApiInfo apiInfo() {
		// 联系人信息：联系人名字、联系人URL、联系人email
		Contact contact = new Contact(name, url, email);
		return new ApiInfoBuilder().title("xinruisho API") // 标题
				.description("前端对接接口查看") // 描述
				.contact(contact)// 作者信息
				.version("0.0.1")// 版本
				// .extensions(null) //在basePath 基础上需要排除的url规则
				// .termsOfServiceUrl("") // 服务条款url
				// .license("") //许可证
				// .licenseUrl("") //许可证url
				.build();
	}
}