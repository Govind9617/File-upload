package com.grt.fileupload.service;

import com.grt.fileupload.entity.Attachment;
import com.grt.fileupload.repo.AttachmentRepo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService{

    private AttachmentRepo attachmentRepo;

    public AttachmentServiceImpl(AttachmentRepo attachmentRepo) {
        this.attachmentRepo = attachmentRepo;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
       String fileName= StringUtils.cleanPath(file.getOriginalFilename());

       try{
           if(fileName.contains("..")){
               throw new Exception("File name contains invalid path reference"+ fileName);
           }
           Attachment attachment
                   =new Attachment(fileName, file.getContentType(),file.getBytes());
           return attachmentRepo.save(attachment);

       }catch (Exception e){
           throw new Exception("could not save file"+ fileName);

       }
    }

    @Override
    public Attachment getAttachment(String fieldId) throws Exception {
        return attachmentRepo.findById(fieldId).orElseThrow(()-> new Exception("file not found with ID"+fieldId ));
    }
}
