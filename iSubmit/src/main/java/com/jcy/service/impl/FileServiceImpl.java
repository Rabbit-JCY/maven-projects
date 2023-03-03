package com.jcy.service.impl;

import com.jcy.dao.FileDao;
import com.jcy.domain.File;
import com.jcy.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;

    @Override
    public boolean insert(File file) {
        fileDao.insert(file);
        return true;
    }

    @Override
    public boolean update(File file) {
        fileDao.update(file);
        return false;
    }

    @Override
    public boolean delete(String name) {
        fileDao.delete(name);
        return false;
    }

    @Override
    public File getFile(String name) {
        return fileDao.getFile(name);
    }

    public File getByURL(String url){return fileDao.getByURL(url);}

    @Override
    public List<File> getFiles() {
        return fileDao.getFiles();
    }
}
