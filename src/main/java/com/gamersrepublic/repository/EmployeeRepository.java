package com.gamersrepublic.repository;

import com.gamersrepublic.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonathan Kok
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{  
}
