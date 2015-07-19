
 
package com.ge.sample.buffet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 212304931
 */
@Repository
abstract interface BuffetRepository extends JpaRepository<Customer, Long>
{
  public abstract Customer findByCustomerId(String paramString);
}
