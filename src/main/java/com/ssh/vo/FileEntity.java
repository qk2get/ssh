package com.ssh.vo;

import java.io.File;

public class FileEntity {
    private File _file;
    private String _fileFileName;
    private String _fileContentType;
    private String error;

    public File get_file() {
        return _file;
    }

    public void set_file(File _file) {
        this._file = _file;
    }

    public String get_fileFileName() {
        return _fileFileName;
    }

    public void set_fileFileName(String _fileFileName) {
        this._fileFileName = _fileFileName;
    }

    public String get_fileContentType() {
        return _fileContentType;
    }

    public void set_fileContentType(String _fileContentType) {
        this._fileContentType = _fileContentType;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "_file=" + _file +
                ", _fileFileName='" + _fileFileName + '\'' +
                ", _fileContentType='" + _fileContentType + '\'' +
                ", error='" + error + '\'' +
                '}';
    }

}
