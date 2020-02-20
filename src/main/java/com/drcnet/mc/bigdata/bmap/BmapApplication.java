package com.drcnet.mc.bigdata.bmap;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = "com.drcnet.mc.bigdata.bmap.dao")
@EnableSwagger2
@ServletComponentScan
@EnableAsync
@EnableTransactionManagement
public class BmapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmapApplication.class, args);
    }

    /**
     * 前后端 分离时 解决跨域问题
     * 
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 允许cookies跨域
        config.addAllowedOrigin("*");// 允许向该服务器提交请求的URI，*表示全部允许。这里尽量限制来源域比如http://xxxx:8080，以降低安全风险。
        config.addAllowedHeader("*");// 允许访问的头信息,*表示全部
        config.setMaxAge(18000L);// 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        config.addAllowedMethod("*");// 允许提交请求的方法，*表示全部允许，也可以单独设置GET、PUT等

//        config.addAllowedMethod("HEAD");
//        config.addAllowedMethod("GET");
//        config.addAllowedMethod("PUT");
//        config.addAllowedMethod("POST");
//        config.addAllowedMethod("DELETE");
//        config.addAllowedMethod("PATCH");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    private List<Parameter> globalOperationParameters() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        Parameter parameter = ticketPar.name("Authorization")
            .description("登录校验").modelRef(new ModelRef("string"))
            .parameterType("header").required(false).defaultValue("").build();
        List<Parameter> parameters = new ArrayList<Parameter>();
        parameters.add(parameter);
        return parameters;
    }

    @Bean
    public Docket swagger() {
        ApiInfo apiInfo = new ApiInfoBuilder().version("1.0").title("平台数据接口API")
            .description("平台数据接口API").build();
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors
                .withMethodAnnotation(ApiOperation.class))
            .paths(PathSelectors.any()).build().apiInfo(apiInfo)
            .globalOperationParameters(globalOperationParameters());
    }

}
