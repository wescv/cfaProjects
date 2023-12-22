package org.academiadecodigo.javabank.services.jdbc;

import org.academiadecodigo.javabank.factories.AccountFactory;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.persistence.daos.Dao;
import org.academiadecodigo.javabank.persistence.daos.jdbc.JdbcAccountsDao;
import org.academiadecodigo.javabank.persistence.jdbc.SessionManager;
import org.academiadecodigo.javabank.services.AccountService;

import java.sql.*;

public class JdbcAccountService implements AccountService {

    private SessionManager sessionManager;
    private AccountFactory accountFactory;
    private Dao jdbcAccountsDao;

    public JdbcAccountService(SessionManager sessionManager, AccountFactory accountFactory) {
        this.sessionManager = sessionManager;
        this.accountFactory = accountFactory;
    }

    public void setJdbcAccountsDao(JdbcAccountsDao jdbcAccountsDao) {this.jdbcAccountsDao = jdbcAccountsDao;}

    @Override
    public Account get(Integer id) {

        Account account = null;

        try {

            ResultSet resultSet = jdbcAccountsDao.findById(id);

            if (resultSet.next()) {

                AccountType accountType = AccountType.valueOf(resultSet.getString("account_type"));

                account = accountFactory.createAccount(accountType);
                account.setId(resultSet.getInt("id"));
                account.setCustomerId(resultSet.getInt("customer_id"));
                account.credit(resultSet.getInt("balance"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

    @Override
    public void add(Account account) {


    }

    @Override
    public void deposit(int id, double amount) {

        Account account = get(id);

        if (account == null) {
            throw new IllegalArgumentException("invalid account id");
        }

        try {

            account.credit(amount);
            updateBalance(account.getId(), account.getBalance());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void withdraw(int id, double amount) {

        Account account = get(id);

        if (account == null) {
            throw new IllegalArgumentException("invalid account id");
        }

        try {

            account.debit(amount);
            updateBalance(account.getId(), account.getBalance());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void transfer(int srcId, int dstId, double amount) {

        Account srcAccount = get(srcId);
        Account dstAccount = get(dstId);

        if (srcAccount == null || dstAccount == null) {
            throw new IllegalArgumentException("invalid account id");
        }

        try {
            if(srcAccount. canDebit(amount)){
                srcAccount.debit(amount);
                dstAccount.credit(amount);

                updateBalance(srcAccount.getId(), srcAccount.getBalance());
                updateBalance(dstAccount.getId(), dstAccount.getBalance());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateBalance(int id, double totalBalance) throws SQLException {

        String query = "UPDATE account SET balance = ? WHERE id = ?";

        PreparedStatement statement = sessionManager.getCurretnConnection().prepareStatement(query);

        statement.setDouble(1, totalBalance);
        statement.setInt(2, id);

        statement.executeUpdate();
        statement.close();
    }
}
