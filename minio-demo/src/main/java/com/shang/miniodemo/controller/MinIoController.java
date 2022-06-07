package com.shang.miniodemo.controller;

import com.shang.miniodemo.common.Result;
import com.shang.miniodemo.config.MinIoConfig;
import com.shang.miniodemo.utils.MinIoUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/minio")
public class MinIoController {

    @Resource
    private MinIoUtils minIoUtils;
    @Resource
    private MinIoConfig minIoConfig;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result upload(@RequestParam(value = "file") MultipartFile file){
        try {
            return Result.ok(minIoUtils.upload(file,minIoConfig.getBucketName(),null));
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("/download")
    public void download(@RequestParam("minFileName")String minFileName,HttpServletResponse response){
        minIoUtils.download(response,minIoConfig.getBucketName(),minFileName);
    }

    /**
     * 根据文件名获取文件的访问url
     * @param minFileName
     */
    @GetMapping("/minFileUrl")
    public Result<String> minFileUrl(@RequestParam("minFileName")String minFileName){
        return Result.ok(minIoUtils.getObjectUrl(minIoConfig.getBucketName(),minFileName,1));
    }
}

