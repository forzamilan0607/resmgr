package com.chris.modules.oss.cloud;

import com.chris.common.utils.Constant;
import com.chris.common.utils.ValidateUtils;

import java.io.Serializable;

public class FileSizeConfig implements Serializable{
    private static final long serialVersionUID = 1L;

    public int getImageMaxSize() {
        return imageMaxSize;
    }

    public void setImageMaxSize(int imageMaxSize) {
        this.imageMaxSize = imageMaxSize;
    }

    public int getVideoMaxSize() {
        return videoMaxSize;
    }

    public void setVideoMaxSize(int videoMaxSize) {
        this.videoMaxSize = videoMaxSize;
    }

    public int getDocMaxSize() {
        return docMaxSize;
    }

    public void setDocMaxSize(int docMaxSize) {
        this.docMaxSize = docMaxSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    private int imageMaxSize;

    private int videoMaxSize;

    private int docMaxSize;

    private int maxSize;

    public boolean isFileSizeOK(long fileSize, String fileType) {
        if (ValidateUtils.equals(Constant.FileType.DOCUMENT.getValue(), fileType)) {
            maxSize = this.docMaxSize;
            return fileSize <= this.docMaxSize;
        } else if (ValidateUtils.equals(Constant.FileType.IMAGE.getValue(), fileType)) {
            maxSize = this.imageMaxSize;
            return fileSize <= imageMaxSize;
        } else if (ValidateUtils.equals(Constant.FileType.VIDEO.getValue(), fileType)) {
            maxSize = this.videoMaxSize;
            return fileSize <= videoMaxSize;
        }
        return true;
    }
}
