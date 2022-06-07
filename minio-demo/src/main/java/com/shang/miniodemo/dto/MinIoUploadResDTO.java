package com.shang.miniodemo.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class MinIoUploadResDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 475040120689218785L;
    private String minFileName;
    private String minFileUrl;

    public MinIoUploadResDTO(String minFileName, String minFileUrl) {
        this.minFileName = minFileName;
        this.minFileUrl = minFileUrl;
    }

}
