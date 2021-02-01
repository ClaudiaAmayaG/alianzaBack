package com.co.alianza.alianzaservices.repository;

import com.co.alianza.alianzaservices.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Repository CustomerRepository.
 *
 * @author camaya@asesoftware.com
 * @version 1.0.0
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("SELECT c" +
            " FROM Customer c" +
            " WHERE (:sharedKey IS NULL OR c.sharedKey IN (:sharedKey))" +
            " AND (:name IS NULL OR c.name LIKE %:name%)" +
            " AND (:phone IS NULL OR c.phone LIKE %:phone%)" +
            " AND (:email IS NULL OR c.email LIKE %:email%)" +
            " AND (:startDate IS NULL OR c.startDate >= :startDate)" +
            " AND (:endDate IS NULL OR c.endDate <= :endDate)")
    List<Customer> searchForFilters(@Param("sharedKey") String sharedKey,
                                    @Param("name") String name,
                                    @Param("phone") String phone,
                                    @Param("email") String email,
                                    @Param("startDate") Date startDate,
                                    @Param("endDate") Date endDate);

}
