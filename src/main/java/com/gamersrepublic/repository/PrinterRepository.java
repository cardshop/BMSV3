package com.gamersrepublic.repository;

import com.gamersrepublic.domain.InkPrinter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonathan Kok
 */
@Repository
public interface PrinterRepository extends JpaRepository<InkPrinter, Long>{
    
}
