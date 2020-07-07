package vn.itsol.apiviettel.service;

import vn.itsol.apiviettel.entity.Customer;

import java.util.List;

public interface CustomerService
{
    List<Customer> findAll();

    Customer findById(int cus_id);

    void save(Customer customer);

    void delete(int cus_id);
}
