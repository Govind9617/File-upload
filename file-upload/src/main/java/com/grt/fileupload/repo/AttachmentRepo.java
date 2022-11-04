package com.grt.fileupload.repo;

import com.grt.fileupload.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepo  extends JpaRepository<Attachment,String> {


}
