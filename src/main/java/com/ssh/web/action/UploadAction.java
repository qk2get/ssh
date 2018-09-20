package com.ssh.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.vo.FileEntity;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller("uploadAction")
@Scope("prototype")
public class UploadAction extends ActionSupport {
    private FileEntity fileEntity;
    private InputStream is;
    private String fileName;

    public void upload() throws IOException {
        String path = ServletActionContext.getServletContext().getRealPath("/file");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileUtils.copyFile(fileEntity.get_file(), new File(file, fileEntity.get_fileFileName()));
    }

    public void download() throws Exception {
        String path = ServletActionContext.getServletContext().getRealPath("/file/log.txt");
        File file = new File(path);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("Content-Disposition","attachment;filename=1233.txt");
        response.setContentType(MediaType.TEXT_PLAIN_VALUE);
        byte[] bytes = FileUtils.readFileToByteArray(file);
        response.getOutputStream().write(bytes);
    }

    public String download2() throws Exception{
        is = ServletActionContext.getServletContext().getResourceAsStream("/file/log.txt");
        fileName = "nimabi.txt";
        return SUCCESS;
    }

    public FileEntity getFileEntity() {
        return fileEntity;
    }

    public void setFileEntity(FileEntity fileEntity) {
        this.fileEntity = fileEntity;
    }

    public InputStream getIs() {
        return is;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
