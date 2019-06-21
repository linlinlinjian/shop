package com.ssm.shop.controller;

import com.ssm.shop.config.UserParams;
import com.ssm.shop.pojo.basePojo.JsonEntity;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/file")
@RestController
public class FileController {

    @Autowired
    private UserParams userParams;

    /**
     * 上传文件
     * @param file
     * @return
     * @throws SocketException
     * @throws IOException
     */
    @RequestMapping(value = "/uploadFile")
    public String upload(MultipartFile file) throws SocketException, IOException {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 在file文件夹中创建名为fileName的文件
        OutputStreamWriter op = new OutputStreamWriter(new FileOutputStream("src/main/resources/file/" + fileName), "UTF-8");
        // 获取文件输入流
        InputStreamReader inputStreamReader = new InputStreamReader(file.getInputStream());
        char[] bytes = new char[12];
        // 如果这里的bytes不是数组，则每次只会读取一个字节，例如test会变成 t   e     s    t
        while (inputStreamReader.read(bytes) != -1){
            op.write(bytes);
        }
        // 关闭输出流
        op.close();
        // 关闭输入流
        inputStreamReader.close();
        return "上传成功";
    }

    @RequestMapping(value = "/uploadImg")
    public String addOneFile(MultipartFile file, HttpServletRequest request) throws IOException {
        // 构建上传文件的存放 "文件夹" 路径
        String path= userParams.getUploadPath();
        System.out.println(path);
        String fileDirPath = new String(path );

        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        // 拿到文件名
        String fileName = file.getOriginalFilename();
        // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
        System.out.println(fileDir.getAbsolutePath());

        try {
            // 构建真实的文件路径
            File newFile = new File(fileDir.getAbsolutePath() + File.separator + fileName);
            System.out.println(newFile.getAbsolutePath());

            // 上传图片到 -》 “绝对路径”
            file.transferTo(newFile);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "http://localhost:8080/img/"+fileName;
    }

    @RequestMapping(value = "/uploadProImg")
    public Map<String,String> uploadProImg(MultipartFile file, HttpServletRequest request) throws IOException {
        // 构建上传文件的存放 "文件夹" 路径
        String path= userParams.getUploadProPath();
        System.out.println(path);
        String fileDirPath = new String(path );

        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        // 拿到文件名
        String fileName = file.getOriginalFilename();
        // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
        System.out.println(fileDir.getAbsolutePath());

        try {
            // 构建真实的文件路径
            File newFile = new File(fileDir.getAbsolutePath() + File.separator + fileName);
            System.out.println(newFile.getAbsolutePath());

            // 上传图片到 -》 “绝对路径”
            file.transferTo(newFile);


        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("name",fileName);
        map.put("url","http://localhost:8080/img/product/"+fileName);
        return map;
    }
}
