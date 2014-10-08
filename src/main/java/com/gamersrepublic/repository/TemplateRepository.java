package com.gamersrepublic.repository;

import com.gamersrepublic.domain.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonathan Kok
 */
@Repository
public interface TemplateRepository extends JpaRepository<Template, Long>{  
}
