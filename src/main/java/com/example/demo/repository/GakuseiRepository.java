package com.example.demo.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.GakuseiHyou;
 
@Repository
public interface GakuseiRepository  extends JpaRepository<GakuseiHyou, Long>{
 
}