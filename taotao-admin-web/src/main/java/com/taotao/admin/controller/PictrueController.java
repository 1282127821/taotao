package com.taotao.admin.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@PropertySource(value="classpath:env.properties")
public class PictrueController {
	//读取配置文件
	@Value("${fastdfsUrl}")
	private String fastdfsUrl;
	//文件上传
	@PostMapping(path="/pic/upload")//MultipartFile用来封装上传的信息的
	@ResponseBody
	public Map<String,Object>  upload(@RequestParam("pic") MultipartFile multipartFile) {
		//由于前台需要一个错误代码以及一个url所以这里要提供
		Map<String, Object> data=new HashMap<>();
		data.put("error", 1);//1表示 失败
		try {
			//文件上传
			String filename = multipartFile.getOriginalFilename();
			//FilenameUtils用来操作文件名的工具了apache提供
			String extension = FilenameUtils.getExtension(filename);
			//获取配置文件路径
			String path = this.getClass().getResource("/fastdfs_client.conf").getPath();
			//初始化
			ClientGlobal.init(path);
			//进行存储
			StorageClient sc=new StorageClient();
			String[] file = sc.upload_file(multipartFile.getBytes(),extension, null);
			//file里面保存的是组名 以及上传到图片服务器的名称 。现在我要将她保存到数据库
			StringBuilder url=new StringBuilder();
			url.append(fastdfsUrl);
			/** 
			 * 定义图片访问的URL
			 * http://res.taotao.com/ group1 /  M00/00/00/wKgMgFqonv2AV5FiAAHyfqgXAuQ502.jpg
			 */
			for (String f : file) {
				url.append("/"+f);
			}
			System.out.println(url);
			data.put("url", url.toString());
			data.put("error", 0);//0表示成功
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
		return data;
	}

}
