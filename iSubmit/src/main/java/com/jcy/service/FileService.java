package com.jcy.service;

import com.jcy.domain.File;

import java.net.URL;
import java.util.List;

public interface FileService {

    public boolean insert(File file);

    public boolean update(File file);

    public boolean delete(String name);

    public File getFile(String name);

    public File getByURL(String url);

    public List<File> getFiles();
}
