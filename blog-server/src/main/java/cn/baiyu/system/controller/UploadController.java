package cn.baiyu.system.controller;

import cn.baiyu.common.utils.UploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther baiyu
 * @date 2019/11/11
 */
@RestController
@Api(tags = "上传")
@RequestMapping("/api/upload")
@Slf4j
public class UploadController {

    @PostMapping(value = "/fileUpload")
    public Map fileUpload(@ApiParam(value = "图片文件，最大2MB", required = true)@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            log.error("文件上传失败，文件为空");
        }
        String fileName = UploadUtil.updateFile(request, file);
        HashMap<String, Object> map = new HashMap<>();
        map.put("fileNo", fileName);
        return map;
    }


    @GetMapping("/getUserLogo")
    public void getUserLogo(HttpServletResponse response, String path) {
        response.setContentType("image/jpeg"); // 设置返回内容格式
        path = System.getProperty("user.dir") + "/upload/" + path;
        File file = new File(path); // 括号里参数为文件图片路径
        if (file.exists()) { // 如果文件存在
            InputStream in;
            try {
                in = new FileInputStream(file);
                OutputStream os = response.getOutputStream(); // 创建输出流
                byte[] b = new byte[1024];
                while (in.read(b) != -1) {
                    os.write(b);
                }
                in.close();
                os.flush();
                os.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                log.error("该文件不存在，path：" + path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            log.error("该文件不存在，path：" + path);
        }
    }
}
