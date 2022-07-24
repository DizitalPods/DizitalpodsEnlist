package com.project.ems.jobdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ems.jobdetails.domain.ClientsDomain;

public interface ClientsRepository extends JpaRepository<ClientsDomain, Long>{

	public ClientsDomain findBycname(String clientname);
}
