package com.project.ems.jobdetails.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	@RequestMapping("/JobDisplay")
	   public String display()
	   {
		   return "JobDisplay";
	  }

	   @RequestMapping("/JobCreate")
	   public String insert()
	   {
		   return "JobCreate";
	  }
	   @RequestMapping("/JobUpdate")
	   public String update()
	   {
		   return "JobUpdate";
	  }
	   
	   @RequestMapping("/JobDelete")
	   public String delete()
	   {
		   return "JobDelete";
	  }
		@RequestMapping("/CandidateDisplay")
		   public String candiadateDisplay()
		   {
			   return "CandidateDisplay";
		  }

		   @RequestMapping("/CandidateCreate")
		   public String candidateInsert()
		   {
			   return "CandidateCreate";
		  }
		   @RequestMapping("/CandidateUpdate")
		   public String candidateUpdate()
		   {
			   return "CandidateUpdate";
		  }

		   @RequestMapping("/CandidateDelete")
		   public String candidateDelete()
		   {
			   return "CandidateDelete";
		  }
		   @RequestMapping("/LockCandidateDisplay")
		   public String lockDisplay()
		   {
			   return "LockCandidateDisplay";
		   }
		   @RequestMapping("/LockCandidateCreate")
		   public String lockCreate()
		   {
			   return "LockCandidateCreate";
		   }
		   @RequestMapping("/LockCandidateUpdate")
		   public String lockUpdate()
		   {
			   return "LockCandidateUpdate";
		   }
		   @RequestMapping("/LockCandidateDelete")
		   public String lockDelete()
		   {
			   return "LockCandidateDelete";
		   }
		   @RequestMapping("/InterviewProcessDisplay")
		   public String interviewDisplay()
		   {
			   return "InterviewProcessDisplay";
		   }
		   @RequestMapping("/InterviewProcessCreate")
		   public String interviewCreate()
		   {
			   return "InterviewProcessCreate";
		   }
		   @RequestMapping("/InterviewProcessUpdate")
		   public String interviewUpdate()
		   {
			   return "InterviewProcessUpdate";
		   }
		   @RequestMapping("/InterviewProcessDelete")
		   public String interviewDelete()
		   {
			   return "InterviewProcessDelete";
		   }
}
