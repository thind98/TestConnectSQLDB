package vn.itsol.apiviettel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.itsol.apiviettel.dao.CustomerDao;
import vn.itsol.apiviettel.entity.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerDao customerDao;

    @Transactional
    @Override
    public List<Customer> findAll()
    {
        return customerDao.findAll();
    }

    @Transactional
    @Override
    public Customer findById(int cus_id)
    {
        return customerDao.findById(cus_id);
    }

    @Transactional
    @Override
    public void save(Customer customer)
    {
        customerDao.save(customer);
    }

    @Transactional
    @Override
    public void delete(int cus_id)
    {
        customerDao.delete(cus_id);
    }
}
