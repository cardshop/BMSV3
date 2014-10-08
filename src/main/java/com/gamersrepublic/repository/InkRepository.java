package com.gamersrepublic.repository;

import com.gamersrepublic.domain.InkCardridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonathan Kok
 */
@Repository
public interface InkRepository extends JpaRepository<InkCardridge, Long>{  
}
