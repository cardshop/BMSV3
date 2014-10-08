package com.gamersrepublic.repository;

import com.gamersrepublic.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonathan Kok
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{  
}

