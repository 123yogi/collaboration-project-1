package com.niit.collaboration;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;



public class BlogDAOTest 
{
	@Autowired
	 static BlogDAO blogDAO;
	@Autowired
	 static Blog blog;	
	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		//context.register(com.niit.collaboration.config.AppConfig.class);
		context.refresh();
		
		blog=(Blog)context.getBean("blog");
		blogDAO=(BlogDAO)context.getBean("blogDAO");		
	}
	@Test
	public void testSave()
	{
		blog.setId(2212);
		blog.setDateTime(new Date());
		blog.setDescription("c language is a good language");
		blog.setTitle("c language is good");
		blog.setStatus("N");
		blog.setUserID("8181");
      	blog.setErrorCode("200");
        blog.setErrorMessage("this page not");
		Assert.assertEquals("save Test Case",true,blogDAO.save(blog));
	}
//	@Test
//	public void  getUserTestCase1()
	//{
//		blog=blogDAO.get(162);
//		Assert.assertNotNull("Get User Test Case",blog);
//		
//	}

}

