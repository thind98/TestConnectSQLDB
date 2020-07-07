package vn.itsol.apiviettel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.itsol.apiviettel.entity.Customer;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao
{
    private static final Logger log = LoggerFactory.getLogger(CustomerDaoImpl.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll()
    {
        String sql = "from Customer";
        Session currentsession = entityManager.unwrap(Session.class);
        Query<Customer> query = currentsession.createQuery(sql, Customer.class);
        List<Customer> list = query.getResultList();
        return list;
    }

    @Override
    public Customer findById(int cus_id)
    {
        String sql = "from Customer as cus where cus.cus_id= " + cus_id;
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Customer> customer = currentSession.createQuery(sql, Customer.class);
//        customer.setParameter("id", cus_id);
        return customer.getSingleResult();
    }
//    Session session = SessionFactory
    @Override
    public void save(Customer customer)
    {
        String sql = "";
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(customer);
//        try
//        {
//            //insert into api_customer (address, dob, email, isdn, name, organization, password, sex, status, username) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
//            sql = "insert into api_customer (address, dob, email, isdn, name, organization, password, sex, status, username) " +
//                    "values (" + "\'" + customer.getAddress()+ "\'" + ", " + "\'" + customer.getDob() + "\'" + ", " + "\'" + customer.getEmail() + "\'"+ ", "
//                    + customer.getIsdn() + ", " + "\'" + customer.getName() + "\'" + ", " + "\'" + customer.getOrganization() + "\'" + ", "
//                    + "\'" + customer.getPassword() + "\'" + ", " + customer.getSex() + ", " + customer.getStatus() + ", "
//                    + "\'" + customer.getUsername() + "\'" + ");";
////            String hql = "insert into api_customer (cus_id, address, dob, email, isdn, name, organization, password, sex, status, username) \n" +
////                         "values ("\'" + Hưng Yên +"\', \'"1998-05-26\', \'"thithi123@gmail.com', 964858867, 'Đình Thi', 'Itsol', 'thiabc123', 1, 0, 'dinhthi2626');";
//            log.info("CustomerDaoImpl.59: " + customer.getCus_id() + "|" + customer.getAddress()+ "|" + customer.getDob() + "|" + customer.getEmail() + "|" + customer.getName() + "|" + customer.getOrganization() + "|" + customer.getUsername() + "|" + customer.getIsdn() + "|" + customer.getPassword() + "|" + customer.getSex() + "|" + customer.getSex());
//            Query<Customer> queryCustomer = currentSession.createSQLQuery(sql);
//            log.info("queryCustomer.getSingleResult(): "+queryCustomer.getSingleResult());
//            currentSession.save(queryCustomer.getSingleResult());
//        } catch (Exception e)
//        {
//            log.error("error: " + e.toString());
//        }
    }

    @Override
    public void delete(int cus_id)
    {
        String sql = "from Customer as cus where cus.cus_id= " + cus_id;
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Customer> customer = currentSession.createQuery(sql, Customer.class);
        currentSession.delete(customer.getSingleResult());
    }
}
