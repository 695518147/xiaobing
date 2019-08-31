package com.zpy.zpyupload.controller;

import com.alibaba.fastjson.JSONObject;
import com.zpy.zpyupload.bean.UploadResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(value = "/zpy")
public class UploadController {

    @Value(value = "${web.upload-path}")
    private String uploadPath;
    @Value(value = "${web.upload-url}")
    private String uploadUrl;

    @PostMapping("/upload")
    public Object upload(HttpServletRequest request,@RequestParam("upfile") MultipartFile file) {
        String action = request.getParameter("action");
        switch (action) {
            case "uploadimage":
            case "uploadvideo":
            case "uploadfile":
                UploadResult uploadResult = uploadFile(file);
                return uploadResult;
            case "catchimage":
//                catcherRemoteImage();
                break;
            case "listimage":
            case "listfile":
//                listFiles();
                break;
            default:

        }
        return action;
    }

    private UploadResult uploadFile(MultipartFile file) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = format.format(new Date()) + UUID.randomUUID().toString().substring(32);
        UploadResult result = new UploadResult();
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            result.setSize(file.getSize());
            result.setOriginal(fileName);
            result.setType(fileName.substring(fileName.lastIndexOf(".")));

            try {
                // 文件存放服务端的位置
                File dir = new File(uploadPath);
                if (!dir.exists())
                    dir.mkdirs();
                // 写文件到服务器
                String newFileName = fileName.substring(0,fileName.lastIndexOf(".")) + time + fileName.substring(fileName.lastIndexOf("."));
                File serverFile = new File(dir.getAbsolutePath() + File.separator + newFileName);
                file.transferTo(serverFile);
                result.setUrl(uploadUrl + newFileName);
                result.setState("SUCCESS");
                return result;
            } catch (Exception e) {
                return result;
            }
        } else {
            return result;
        }

    }


    @GetMapping("/upload")
    public String config(HttpServletRequest request) {
        String action = request.getParameter("action");
        String callback = request.getParameter("callback");

        String str = "{\n" +
                "  \"imageActionName\": \"uploadimage\",\n" +
                "  \"imageFieldName\": \"upfile\",\n" +
                "  \"imageMaxSize\": 2048000,\n" +
                "  \"imageAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\n" +
                "  \"imageCompressEnable\": true,\n" +
                "  \"imageCompressBorder\": 1600,\n" +
                "  \"imageInsertAlign\": \"none\",\n" +
                "  \"imageUrlPrefix\": \"\",\n" +
                "  \"imagePathFormat\": \"/upload/ueditor/pic/\",\n" +
                "  \"scrawlActionName\": \"uploadscrawl\",\n" +
                "  \"scrawlFieldName\": \"upfile\",\n" +
                "  \"scrawlPathFormat\": \"/ueditor/php/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
                "  \"scrawlMaxSize\": 2048000,\n" +
                "  \"scrawlUrlPrefix\": \"\",\n" +
                "  \"scrawlInsertAlign\": \"none\",\n" +
                "  \"snapscreenActionName\": \"uploadimage\",\n" +
                "  \"snapscreenPathFormat\": \"/ueditor/php/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
                "  \"snapscreenUrlPrefix\": \"\",\n" +
                "  \"snapscreenInsertAlign\": \"none\",\n" +
                "  \"catcherLocalDomain\": [\"127.0.0.1\", \"localhost\", \"img.baidu.com\"],\n" +
                "  \"catcherActionName\": \"catchimage\",\n" +
                "  \"catcherFieldName\": \"source\",\n" +
                "  \"catcherPathFormat\": \"/ueditor/php/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
                "  \"catcherUrlPrefix\": \"\",\n" +
                "  \"catcherMaxSize\": 2048000,\n" +
                "  \"catcherAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\n" +
                "  \"videoActionName\": \"uploadvideo\",\n" +
                "  \"videoFieldName\": \"upfile\",\n" +
                "  \"videoPathFormat\": \"/ueditor/php/upload/video/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
                "  \"videoUrlPrefix\": \"\",\n" +
                "  \"videoMaxSize\": 102400000,\n" +
                "  \"videoAllowFiles\": [\n" +
                "    \".flv\", \".swf\", \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", \".mpg\",\n" +
                "    \".ogg\", \".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", \".mid\"],\n" +
                "  \"fileActionName\": \"uploadfile\",\n" +
                "  \"fileFieldName\": \"upfile\",\n" +
                "  \"filePathFormat\": \"/ueditor/php/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
                "  \"fileUrlPrefix\": \"\",\n" +
                "  \"fileMaxSize\": 51200000,\n" +
                "  \"fileAllowFiles\": [\n" +
                "    \".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\",\n" +
                "    \".flv\", \".swf\", \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", \".mpg\",\n" +
                "    \".ogg\", \".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", \".mid\",\n" +
                "    \".rar\", \".zip\", \".tar\", \".gz\", \".7z\", \".bz2\", \".cab\", \".iso\",\n" +
                "    \".doc\", \".docx\", \".xls\", \".xlsx\", \".ppt\", \".pptx\", \".pdf\", \".txt\", \".md\", \".xml\"\n" +
                "  ],\n" +
                "  \"imageManagerActionName\": \"listimage\",\n" +
                "  \"imageManagerListPath\": \"/ueditor/php/upload/image/\",\n" +
                "  \"imageManagerListSize\": 20,\n" +
                "  \"imageManagerUrlPrefix\": \"\",\n" +
                "  \"imageManagerInsertAlign\": \"none\",\n" +
                "  \"imageManagerAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\n" +
                "  \"fileManagerActionName\": \"listfile\",\n" +
                "  \"fileManagerListPath\": \"/ueditor/php/upload/file/\",\n" +
                "  \"fileManagerUrlPrefix\": \"\",\n" +
                "  \"fileManagerListSize\": 20,\n" +
                "  \"fileManagerAllowFiles\": [\n" +
                "    \".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\",\n" +
                "    \".flv\", \".swf\", \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", \".mpg\",\n" +
                "    \".ogg\", \".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", \".mid\",\n" +
                "    \".rar\", \".zip\", \".tar\", \".gz\", \".7z\", \".bz2\", \".cab\", \".iso\",\n" +
                "    \".doc\", \".docx\", \".xls\", \".xlsx\", \".ppt\", \".pptx\", \".pdf\", \".txt\", \".md\", \".xml\"\n" +
                "  ]\n" +
                "}\n";
        return callback + "(" + JSONObject.parse(str).toString() + ")";
    }
}
