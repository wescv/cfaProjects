package org.academiadecodigo.javabank.persistence.jdbc;

import org.academiadecodigo.javabank.persistence.jdbc.exceptions.TransactionException;

import java.sql.SQLException;

public class JdbcTransactionManager {
    private SessionManager sessionManager;

    public void setSessionManager(SessionManager sessionManager) {this.sessionManager = sessionManager;}

    public void beginRead() {
        sessionManager.startConnection();
    }

    public void beginWrite() {
        try {
            sessionManager.getCurretnConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        try {
            if (!sessionManager.getCurretnConnection().getAutoCommit()) {
                sessionManager.getCurretnConnection().commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sessionManager.close();
    }

    public void rollBack() {
        try {
            if (!sessionManager.getCurretnConnection().getAutoCommit()) {
                sessionManager.getCurretnConnection().rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sessionManager.close();
    }
}
