package com.gamersrepublic.repository;

import com.gamersrepublic.domain.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonathan Kok
 */

@Repository
public interface PaperRepository extends JpaRepository<Paper, Long>{  
}
