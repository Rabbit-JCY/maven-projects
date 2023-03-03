package com.jcy.controller;

import com.jcy.domain.File;
import com.jcy.service.FileService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Controller
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping()
    @ResponseBody
    private String insert(@RequestBody File file) throws MalformedURLException {
        File file0 = fileService.getFile(file.getName());
        if (file0 != null){
            return "name already exists!";
        }else {
            file.setUrl(file.getName() + "_url");
            fileService.insert(file);
            return file.getUrl();
        }
    }

    @DeleteMapping("/{name}")
    @ResponseBody
    private String delete(@PathVariable String name){
        File file = fileService.getFile(name);
        if (file == null){
            return "file doesn't exist!";
        }else{
            fileService.delete(name);
            return "delete successfully!";
        }
    }

    @PutMapping()
    @ResponseBody
    private String update(@RequestBody File file){
        File file0 = fileService.getFile(file.getName());
        if(file0 == null){
            return "filename doesn't exist!";
        }else{
            fileService.update(file);
            return "update successfully!";
        }
    }

    @GetMapping("/{name}")
    @ResponseBody
    private File getFile(@PathVariable String name){
        return fileService.getFile(name);
    }


    @ResponseBody
    @GetMapping()
    private List<File> getFiles(){
        return fileService.getFiles();
    }

    @GetMapping("/download/{url}")
    @ResponseBody
    private File getByURL(@PathVariable String url){
        return fileService.getByURL(url);
    }




}
