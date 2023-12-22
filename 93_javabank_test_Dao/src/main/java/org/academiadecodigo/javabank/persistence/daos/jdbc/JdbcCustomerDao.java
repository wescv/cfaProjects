package org.academiadecodigo.javabank.persistence.daos.jdbc;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.persistence.daos.CustomerDao;
import org.academiadecodigo.javabank.persistence.jdbc.SessionManager;
import org.academiadecodigo.javabank.persistence.jdbc.exceptions.TransactionException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCustomerDao implements CustomerDao {
    SessionManager sessionManager = new SessionManager();

    @Override
    public ResultSet findById(Integer id) {

        ResultSet resultSet = null;

        try {
            String query = "SELECT customer.id AS cid, first_name, last_name, phone, email, account.id AS aid " +
                    "FROM customer " +
                    "LEFT JOIN account " +
                    "ON customer.id = account.customer_id " +
                    "WHERE customer.id = ?";

            PreparedStatement statement = sessionManager.getCurretnConnection().prepareStatement(query);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    @Override
    public ResultSet findAll() {

        ResultSet resultSet = null;

        try {
            String query = "SELECT customer.id AS cid, first_name, last_name, phone, email, account.id AS aid " +
                    "FROM customer " +
                    "LEFT JOIN account " +
                    "ON customer.id = account.customer_id";

            PreparedStatement statement = sessionManager.getCurretnConnection().prepareStatement(query);
            resultSet = statement.executeQuery();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        try {

            String query = "INSERT INTO customer(first_name, last_name, email, phone) " +
                    "VALUES(?, ?, ?, ?)";

            PreparedStatement statement = sessionManager.getCurretnConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhone());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                customer.setId(generatedKeys.getInt(1));
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public void delete(Integer id) {

    }
}
