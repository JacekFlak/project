package com.jacek.projekt.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("requestRepository")
public interface RequestRepository extends JpaRepository<Request, Integer> {


}