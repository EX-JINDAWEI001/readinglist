package com.example.readinglist.util;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.text.MessageFormat;
import java.util.Locale;

public class BeanFactoryTest {

	@Test
	public void testSimpleLoad(){
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
		MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
		System.out.println(bean);
	}

	@Test
	public void test1() {
		MessageFormat messageFormat = new MessageFormat("{0},你好，今天花了{1}元！", Locale.UK);
		String msg1 = messageFormat.format(new String[]{"金大为","56"});
		System.out.println(msg1);

		ApplicationContext aContext = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
		Object bean = aContext.getBean("myTestBean");
		System.out.println(bean);
	}
}
