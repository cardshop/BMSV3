package com.gamersrepublic.repository;

import com.gamersrepublic.domain.Decoration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jonathan
 */

@Repository
public interface DecorationRepository extends JpaRepository<Decoration, Long>{
}
