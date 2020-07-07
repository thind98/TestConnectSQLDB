package vn.itsol.apiviettel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.itsol.apiviettel.entity.Customer;

import java.util.List;

public interface CustomerDao
{
    List<Customer> findAll();

    Customer findById(int cus_id);

    void save(Customer customer);

    void delete(int cus_id);
}
