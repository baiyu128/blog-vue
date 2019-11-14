package cn.baiyu.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * @author baiyu
 * @data 2019-11-06 14:22
 */
@Slf4j
public class UploadUtil {
    /**
     * 上传到服务器的方法
     */
    public static String updateFile(HttpServletRequest request, MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                //得到图片全名
                String originalFilename = file.getOriginalFilename();
                int i1 = originalFilename.lastIndexOf(".");
                String suffix = "";
                if (i1 != 0) {
                    suffix = originalFilename.substring(i1 + 1);
                } else {
                    suffix = "jpg";
                }
                String uName = UUID.randomUUID().toString().replaceAll("-", "");
                String newName = uName + "." + suffix;
                String filePath = System.getProperty("user.dir") + "/upload/" + newName;
                log.info("文件保存路径:"+filePath);
                // 保存的文件路径(如果用的是Tomcat服务器，文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中)
                File saveDir = new File(filePath);
                if (!saveDir.getParentFile().exists()) {
                    saveDir.getParentFile().mkdirs();
                }
                // 转存文件 保存到服务器地址上，路径在filePath
                file.transferTo(saveDir);
                return newName;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
