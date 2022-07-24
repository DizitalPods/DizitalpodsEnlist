package com.project.ems.jobdetails.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.project.ems.jobdetails.domain.FileDB;
import com.project.ems.jobdetails.repository.FileDBRepository;

@Service
public class FileStorageService {
	int i=0;
  @Autowired
  private FileDBRepository fileDBRepository;
  public FileDB store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
    
     i++;
    
     if(i==1) 
     {
        return fileDBRepository.save(FileDB);
     }

     else
     {
    	 
    	 List<FileDB> l = fileDBRepository.findAll();
    	 FileDB fd = l.get(l.size()-1);
    	 fd.setType(file.getContentType());
    	 fd.setName(fileName);
    	 fd.setData(file.getBytes());
    	 return fileDBRepository.save(fd);
     
     }



  }
  public FileDB getFile(String id) {
	  
     Optional<FileDB> op = fileDBRepository.findById(id);
     if(op.isPresent())
     {
    	 return op.get();
     }
     else 
     {
    	 return null;
     }
  }
  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
}
