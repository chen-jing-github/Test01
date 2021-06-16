package demo;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.ModuleConfig;
import org.apache.dubbo.config.MonitorConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.alibaba.nacos.spring.context.annotation.EnableNacos;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import com.gugusong.sqlmapper.springboot.EnableSqlHelp;

@EnableAutoConfiguration
@EnableSqlHelp
//@EnableDubboConfig
@EnableNacosDiscovery
public class SpringbootDubboPermApplication 
{
    public static void main(String[] args) {
    	ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringbootDubboPermApplication.class)
                .run(args);
        
        // application
        ApplicationConfig applicationConfig = context.getBean("dubboPermApplicationBean", ApplicationConfig.class);
        System.out.printf("applicationBean.name = %s \n", applicationConfig.getName());

        // module
        ModuleConfig moduleConfig = context.getBean("dubboPermModuleBean", ModuleConfig.class);
        System.out.printf("moduleBean.name = %s \n", moduleConfig.getName());

        // registry
        RegistryConfig registryConfig = context.getBean(RegistryConfig.class);
        System.out.printf("registryConfig.name = %s \n", registryConfig.getAddress());

        // protocol
        ProtocolConfig protocolConfig = context.getBean(ProtocolConfig.class);
        System.out.printf("protocolConfig.name = %s \n", protocolConfig.getName());
        System.out.printf("protocolConfig.port = %s \n", protocolConfig.getPort());

        /*
        // monitor
        MonitorConfig monitorConfig = context.getBean(MonitorConfig.class);
        System.out.printf("monitorConfig.name = %s \n", monitorConfig.getAddress());

        // provider
        ProviderConfig providerConfig = context.getBean(ProviderConfig.class);
        System.out.printf("providerConfig.name = %s \n", providerConfig.getHost());

        // consumer
        ConsumerConfig consumerConfig = context.getBean(ConsumerConfig.class);
        System.out.printf("consumerConfig.name = %s \n", consumerConfig.getClient());
        */
        
        
    }
    
    public static void main11( String[] args )
    {
    	ConfigurableApplicationContext context = SpringApplication.run(SpringbootDubboPermApplication.class, args);
		String[] beanDefinitionNames =                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              context.getBeanDefinitionNames();
		System.out.println("-------------------------遍历已经注入的bean-----------------------");
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
		System.out.println("-------------------------已经注入的bean遍历结束-----------------------");
		System.out.println("##########  启动完成   ##########");
    }
}
