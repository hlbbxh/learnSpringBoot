package com.bao.learnSpringBoot.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileUplode {
	/**
	 * 返回上传的页面
	 * @return
	 */
	@RequestMapping("/fileup")
	public String yemian() {
		return "freemarker/fileuplode";
	}
	
	/**
	 * 这是点击确定后具体的  接收文件的方法
	 * @param req
	 * @param file
	 * @param m
	 * @return
	 */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest req, @RequestParam("file") MultipartFile file,Model m) {
            try {
            	//获取当前时间  并且 名称为时间戳加上文件名称  System.currentTimeMillis()
                String fileName = file.getOriginalFilename();
                
                //文件保存路径
                // File.separator 根据系统判断文件的斜杠  
                String destFileName="G:\\Learning_software\\EclipseWebWork\\hlbbxhWork\\mblog\\learnSpringBoot\\src\\main\\resources\\static\\temp\\uploaded"+File.separator+fileName;
                 
                //生成文件
                File destFile = new File(destFileName);
                destFile.getParentFile().mkdirs();
                file.transferTo(destFile);
                //放入文件路径
                m.addAttribute("fileName",fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
             
            return "freemarker/showimg";
    } 
}
