package demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import com.gugusong.sqlmapper.springboot.EnableSqlHelp;

import demo.springboot.dubbo.entity.dto.TestDto;
import demo.springboot.dubbo.entity.pojo.BookDetail;

@SpringBootApplication
@ComponentScan(value = {"com.*", "demo.*"})
@EnableSqlHelp
@EnableDubbo
@EnableNacosDiscovery
public class SpringbootDubboApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootDubboApplication.class, args);
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		System.out.println("-------------------------遍历已经注入的bean-----------------------");
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
		System.out.println("-------------------------已经注入的bean遍历结束-----------------------");
		System.out.println("##########  启动完成   ##########");
	}

	public static void main3(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i< 10; i++) {
			if (i > 6) {
				System.out.println("put次数大于6了。。。。" + i);
			}
			map.put(String.valueOf(i), String.valueOf(i));
		}

		for (int i = 0; i< 10; i++) {
			if (i > 2) {
				System.out.println("remove次数大于2了。。。。" + i);
			}
			map.remove(String.valueOf(i));
		}
	}
	
	public static void main1(String[] args) throws ClassNotFoundException, IOException {
		// 开启热部署
//		System.setProperty("spring.devtools.restart.enabled", "false");

		ArrayList<BookDetail> oldArray = new ArrayList<BookDetail>();
		BookDetail bDetail = new BookDetail();
		bDetail.setBookId(10L);
		bDetail.setDetail("书本10");

		TestDto testDto = new TestDto();
		testDto.setId("testId=1");
		testDto.setBookDetail(
				new BookDetail(40L, "testDto.bookDetail=40L", null, new TestDto("testDto.bookDetail.testDto=60L",
						new BookDetail(70L, "testDto.bookDetail.testDto.bookDetail=70L", ""))));

		bDetail.setTestDto(testDto);
		oldArray.add(bDetail);

		ArrayList<BookDetail> deepCopyArrayList = (ArrayList<BookDetail>) deepCopy(oldArray);

		ArrayList<BookDetail> collCopyArrayList = new ArrayList<BookDetail>();
		collCopyArrayList.add(null);
		Collections.copy(collCopyArrayList, oldArray);

		ArrayList<BookDetail> myObject = new ArrayList<BookDetail>(oldArray);

		ArrayList<BookDetail> newArray = (ArrayList<BookDetail>) oldArray.clone();

		newArray.get(0).setImgUrl("newArray中增加的图片地址");
		BookDetail bDetail2 = new BookDetail();
		bDetail2.setBookId(20L);
		bDetail2.setDetail("书本20");
		newArray.add(bDetail2);

		System.out.println(oldArray.toString());
		System.out.println(myObject.toString());
		System.out.println(newArray.toString());
		System.out.println(collCopyArrayList.toString());
		System.out.println(deepCopyArrayList.toString());
	}

	public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteOut);
		out.writeObject(src);

		ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
		ObjectInputStream in = new ObjectInputStream(byteIn);

		List<T> copy_list = (List<T>) in.readObject();
		return copy_list;
	}
}
