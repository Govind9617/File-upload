package com.grt.fileupload.service;

import com.grt.fileupload.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachment(String fieldId) throws Exception;
}
