package com.dc.studenttab.dao.repository;

import com.dc.studenttab.dao.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
