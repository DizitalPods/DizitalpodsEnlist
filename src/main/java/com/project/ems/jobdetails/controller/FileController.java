package com.project.ems.jobdetails.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.ems.jobdetails.db.messages.ResponseFile;
import com.project.ems.jobdetails.db.messages.ResponseMessage;
import com.project.ems.jobdetails.domain.CandidateDetailsDomain;
import com.project.ems.jobdetails.domain.FileDB;
import com.project.ems.jobdetails.service.CandidateDetailsService;
import com.project.ems.jobdetails.service.FileStorageService;

@RestController
public class FileController {
  @Autowired
  private FileStorageService storageService;
  @Autowired
  CandidateDetailsService cs;
  @PostMapping("/upload")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("fi") MultipartFile file) {
    String message = "";
    try {
      storageService.store(file);
      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }
  @GetMapping("/files")
  public ResponseEntity<List<ResponseFile>> getListFiles() {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/files/")
          .path(dbFile.getId())
          .toUriString();
      return new ResponseFile(
          dbFile.getName(),
          fileDownloadUri,
          dbFile.getType(),
          dbFile.getData().length);
    }).collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(files);
  }

  
  @GetMapping("/files/{id}")
  public ResponseEntity<Object> getFile(@PathVariable Long id) {
	  
	  String msg="";
	  FileDB fileDB =null;
	  CandidateDetailsDomain cd = cs.get(id);
	  if(cd!=null)
	  {
		  String fid = cd.getFid();
		  
		  if(fid!=null)
		  {
	  
               fileDB = storageService.getFile(fid);
               return ResponseEntity.ok()
            	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
            	        .body(fileDB.getData());
		  }
		  else
		  {
			  msg="file not found";
			  return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(msg));
          	        
          	       
		  }
	  }
	  else
	  {
		  msg="candidate not found";
		  return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(msg));
		  
	  }
         
  }

}
