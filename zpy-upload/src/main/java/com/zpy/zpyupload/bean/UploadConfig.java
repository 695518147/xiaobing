package com.zpy.zpyupload.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
public class UploadConfig {
     private String imageActionName = "uploadimage";
     private int imageMaxSize = 10485760;
     private String imageFieldName = "upfile";
     private String imageUrlPrefix = "";
     private String imagePathFormat = "image/%(basename)s_%(datetime)s_%(rnd)s.%(extname)s";
     private Set<String> imageAllowFiles = new HashSet<String>(){{
         add(".png");
         add(".jpg");
         add(".jpeg");
         add(".gif");
         add(".bmp");
     }};
     private String scrawlActionName = "uploadscrawl";
     private String scrawlFieldName = "upfile";
     private int scrawlMaxSize = 10485760;
     private String scrawlUrlPrefix = "";
     private String scrawlPathFormat = "";
     private String snapscreenActionName = "uploadimage";
     private String snapscreenPathFormat = "";
     private String snapscreenUrlPrefix = "";
     private Set<String> catcherLocalDomain = new HashSet<String>(){{
         add(".127.0.0.1");
         add("localhost");
         add("img.baidu.com");
     }};
     private String catcherPathFormat = "";
     private String catcherActionName = "catchimage";
     private String catcherFieldName = "source";
     private int catcherMaxSize = 10485760;
     private Set<String> catcherAllowFiles = new HashSet<String>(){{
         add(".png");
         add(".jpg");
         add(".jpeg");
         add(".gif");
         add(".bmp");
     }};
     private String catcherUrlPrefix = "";
     private String videoActionName = "uploadvideo";
     private String videoPathFormat = "video/%(basename)s_%(datetime)s_%(rnd)s.%(extname)s";
     private String videoFieldName = "upfile";
     private int videoMaxSize = 102400000;
     private String videoUrlPrefix = "";
     private Set<String> videoAllowFiles = new HashSet<String>(){{add(".flv");add(".swf");add(".mkv");add(".avi");add(".rm");add(".rmvb");add(".mpeg");add(".mpg");add(".ogg");add(".ogv");add(".mov");add(".wmv");add(".mp4");add(".webm");add(".mp3");add(".wav");add(".mid");}};
     private String fileActionName = "uploadfile";
     private String filePathFormat = "file/%(basename)s_%(datetime)s_%(rnd)s.%(extname)s";
     private String fileFieldName = "upfile";
     private int fileMaxSize = 204800000;
     private String fileUrlPrefix = "";
     private Set<String> fileAllowFiles = new HashSet<String>(){{add(".flv");add(".swf");add(".mkv");add(".avi");add(".rm");add(".rmvb");add(".mpeg");add(".mpg");add(".ogg");add(".ogv");add(".mov");add(".wmv");add(".mp4");add(".webm");add(".mp3");add(".wav");add(".mid");}};
    private String imageManagerActionName = "listimage";
     private String imageManagerListPath = "";
     private int imageManagerListSize = 30;
     private Set<String> imageManagerAllowFiles = new HashSet<String>(){{
         add(".png");
         add(".jpg");
         add(".jpeg");
         add(".gif");
         add(".bmp");
     }};
     private String imageManagerUrlPrefix = "";
     private String fileManagerActionName = "listfile";
     private String fileManagerListPath = "";
     private String fileManagerUrlPrefix = "";
     private int fileManagerListSize = 30;
     private Set<String > fileManagerAllowFiles = new HashSet<String>(){{add(".flv");add(".swf");add(".mkv");add(".avi");add(".rm");add(".rmvb");add(".mpeg");add(".mpg");add(".ogg");add(".ogv");add(".mov");add(".wmv");add(".mp4");add(".webm");add(".mp3");add(".wav");add(".mid");}};
}
