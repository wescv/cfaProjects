package org.academiadecodigo.javabank.persistence.daos.jdbc;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.daos.AccountDao;
import org.academiadecodigo.javabank.persistence.jdbc.SessionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcAccountsDao implements AccountDao {

    private SessionManager sessionManager;

    public void setSessionManager(SessionManager sessionManager) {this.sessionManager = sessionManager;}

    @Override
    public ResultSet findById(Integer id) {

        ResultSet resultSet = null;
        try {

            String query = "SELECT id, account_type, customer_id, balance FROM account WHERE id=?";
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
        return null;
    }

    @Override
    public Account saveOrUpdate(Account account) {

        try {

            String query = "INSERT INTO account(account_type, balance, customer_id) " +
                    "VALUES (?, ?, ?)";

            PreparedStatement statement = sessionManager.getCurretnConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, account.getAccountType().name());
            statement.setDouble(2, account.getBalance());
            statement.setInt(3, account.getCustomerId());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if(generatedKeys.next()) {
                account.setId(generatedKeys.getInt(1));
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void updateBalance(int id, double amount) {
        
    }
}
