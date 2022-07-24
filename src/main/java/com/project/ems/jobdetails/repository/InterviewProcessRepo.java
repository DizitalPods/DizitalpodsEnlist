package com.project.ems.jobdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ems.jobdetails.domain.InterviewProcessDomain;

@Repository
public interface InterviewProcessRepo extends JpaRepository<InterviewProcessDomain, Long> {

}
