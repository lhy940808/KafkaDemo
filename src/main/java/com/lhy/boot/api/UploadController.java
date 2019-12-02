package com.lhy.boot.api;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
/**
 * @author liuhaiyan
 * @date 2019-11-08 13:51
 */
@RestController
public class UploadController {


    /**实现上传，但上传路径定了*/
    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request) throws Exception{
        /*
         定义文件的存储路径,如下，是在linux和mac上定义的文件路径
        /private/var/folders/8x/4zvnbqmj1w33cqmzrpygzbth0000gn/T/tomcat-docbase.5206733816001100271.8080/uploadFile
         */

        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        File path1 = new File(ResourceUtils.getURL("classpath:").getPath());

        File dir = new File(realPath);
        if (!dir.isDirectory()) {//文件目录不存在，就创建一个
            dir.mkdirs();
        }

        try {
            String filename = uploadFile.getOriginalFilename();
            //服务端保存的文件对象
            File dirs = new File("");
            File fileServer = new File(dir, filename);
            System.out.println("file文件真实路径:" + fileServer.getAbsolutePath());
            //2，实现上传
            uploadFile.transferTo(fileServer);
            String filePath = request.getScheme() + "://" +
                    request.getServerName() + ":"
                    + request.getServerPort()
                    + "/uploadFile/" + filename;
            //3，返回可供访问的网络路径
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    public final static String UPLOAD_PATH_PREFIX = "static/uploadFile/";

    private static  final Logger logger = LoggerFactory.getLogger(UploadController.class);

    /**
     * @Description : 能够在特定的位置保存文件
     * 此中方式文件上传后不能立即访问，需要项目重启才能访问上传的文件
     * @params [uploadFile, request]
     * @return java.lang.String
     * @author liuhaiyan
     * @date 2019-11-08 16:37
     */
    @PostMapping("/upload2")
    public String upload2(MultipartFile uploadFile, HttpServletRequest request){
        if(uploadFile.isEmpty()){
            //返回选择文件提示
            return "请选择上传文件";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
        String realPath = new String("src/main/resources/" + UPLOAD_PATH_PREFIX);
        logger.info("-----------上传文件保存的路径【"+ realPath +"】-----------");
        String format = sdf.format(new Date());
        //存放上传文件的文件夹
        File file = new File(realPath + format);
        logger.info("-----------存放上传文件的文件夹【"+ file +"】-----------");
        logger.info("-----------输出文件夹绝对路径 -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径【"+ file.getAbsolutePath() +"】-----------");
        if(!file.isDirectory()){
            //递归生成文件夹
            file.mkdirs();
        }
        //获取原始的名字  original:最初的，起始的  方法是得到原来的文件名在客户机的文件系统名称
        String oldName = uploadFile.getOriginalFilename();
        logger.info("-----------文件原始的名字【"+ oldName +"】-----------");
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());
        logger.info("-----------文件要保存后的新名字【"+ newName +"】-----------");
        try {
            //构建真实的文件路径
            File newFile = new File(file.getAbsolutePath() + File.separator + newName);
            //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
            uploadFile.transferTo(newFile);
            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format + newName;
            logger.info("-----------【"+ filePath +"】-----------");
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败!";
    }
    private static final String FileLocation = "/Users/liuhaiyan05/uploadLocation/";

    @PostMapping("/upload3")
    public String upload3(MultipartFile uploadFile, HttpServletRequest request){
        if(uploadFile.isEmpty()){
            //返回选择文件提示
            return "请选择上传文件";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/");
        //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
        String realPath = FileLocation;
        logger.info("-----------上传文件保存的路径【"+ realPath +"】-----------");
        String format = sdf.format(new Date());
        //存放上传文件的文件夹
        File file = new File(realPath + format);
        logger.info("-----------存放上传文件的文件夹【"+ file +"】-----------");
        logger.info("-----------输出文件夹绝对路径 -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径【"+ file.getAbsolutePath() +"】-----------");
        if(!file.isDirectory()){
            //递归生成文件夹
            file.mkdirs();
        }
        //获取原始的名字  original:最初的，起始的  方法是得到原来的文件名在客户机的文件系统名称
        String oldName = uploadFile.getOriginalFilename();
        logger.info("-----------文件原始的名字【"+ oldName +"】-----------");
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());
        logger.info("-----------文件要保存后的新名字【"+ newName +"】-----------");
        try {
           // 这里使用Apache的FileUtils方法来进行保存
            FileUtils.copyInputStreamToFile(uploadFile.getInputStream(), new File(file, newName));
            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/upload_file/" + format + newName;
            logger.info("-----------【"+ filePath +"】-----------");
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败!";
    }


}

