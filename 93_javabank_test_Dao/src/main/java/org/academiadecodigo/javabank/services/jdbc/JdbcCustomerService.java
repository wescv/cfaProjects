package org.academiadecodigo.javabank.services.jdbc;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.daos.Dao;
import org.academiadecodigo.javabank.persistence.daos.jdbc.JdbcCustomerDao;
import org.academiadecodigo.javabank.persistence.jdbc.JdbcTransactionManager;
import org.academiadecodigo.javabank.persistence.jdbc.SessionManager;
import org.academiadecodigo.javabank.persistence.jdbc.exceptions.TransactionException;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.CustomerService;

import java.sql.*;
import java.util.*;

public class JdbcCustomerService implements CustomerService {

    private AccountService accountService;
    private SessionManager sessionManager;
    private Dao jdbcCustomerDao;
    private JdbcTransactionManager jdbcTransactionManager;

    public JdbcCustomerService(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setJdbcCustomerDao(JdbcCustomerDao jdbcCustomerDao) {
        this.jdbcCustomerDao = jdbcCustomerDao;
    }

    @Override
    public Customer get(Integer id) {

        Customer customer = null;

        try {
            ResultSet resultSet = jdbcCustomerDao.findById(id);

            while (resultSet.next()) {

                if (customer == null) {
                    customer = buildCustomer(resultSet);
                }

                int accountId = resultSet.getInt("aid");
                Account account = accountService.get(accountId);

                if (account == null) {
                    break;
                }

                customer.addAccount(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> list() {

        Map<Integer, Customer> customers = new HashMap<>();

        try {

            ResultSet resultSet = jdbcCustomerDao.findAll();

            while (resultSet.next()) {
                if (!customers.containsKey(resultSet.getInt("cid"))) {
                    Customer customer = buildCustomer(resultSet);
                    customers.put(customer.getId(), customer);
                }

                Account account = accountService.get(resultSet.getInt("aid"));
                if (account != null) {
                    customers.get(resultSet.getInt("cid")).addAccount(account);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new LinkedList<>(customers.values());
    }

    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {

        Customer customer = get(id);

        if (customer == null) {
            throw new IllegalArgumentException("Customer does not exist");
        }

        List<Account> accounts = customer.getAccounts();

        if (accounts.size() == 0) {
            return Collections.emptySet();
        }

        Set<Integer> customerAccountIds = new HashSet<>();

        for (Account account : accounts) {
            customerAccountIds.add(account.getId());
        }

        return customerAccountIds;
    }

    @Override
    public double getBalance(int id) {

        Customer customer = get(id);

        if (customer == null) {
            throw new IllegalArgumentException("Customer does not exist");
        }

        List<Account> accounts = customer.getAccounts();

        double balance = 0;
        for (Account account : accounts) {
            balance += account.getBalance();
        }

        return balance;
    }

    @Override
    public void add(Customer customer) {

        if (customer.getId() != null && get(customer.getId()) != null) {
            return;
        }

        try {

            jdbcTransactionManager.beginWrite();
            jdbcCustomerDao.saveOrUpdate(customer);
            jdbcTransactionManager.commit();

        } catch (TransactionException e) {
            jdbcTransactionManager.rollBack();
        }

    }

    private Customer buildCustomer(ResultSet resultSet) throws SQLException {

        Customer customer = new Customer();

        customer.setId(resultSet.getInt("cid"));
        customer.setFirstName(resultSet.getString("first_name"));
        customer.setLastName(resultSet.getString("last_name"));
        customer.setPhone(resultSet.getString("phone"));
        customer.setEmail(resultSet.getString("email"));

        return customer;
    }
}
