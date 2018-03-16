package com.xy.test;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;
public class TestApp {
	@Test
	public void test1() {
		//我们只要知道apache有一个处理文件名的工具类就行，到时候具体使用试一下
		String filename="d:/目录/yezi/xiaoyezi.txt";
		System.out.println(FilenameUtils.getBaseName(filename));//xiaoyezi
		System.out.println(FilenameUtils.getFullPath(filename));//d:/目录/yezi/
		System.out.println(FilenameUtils.getPrefix(filename));//d:/
		System.out.println(FilenameUtils.getPathNoEndSeparator(filename));//目录/yezi
		System.out.println(FilenameUtils.getExtension(filename));//txt
	}

}
