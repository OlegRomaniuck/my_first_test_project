package com.invest.core.web.databasePostgresSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tester3 on 28.10.2015.
 */
public class MyJdbc {

    public static Connection start() {

        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            // return;

        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://", "",
                    "");
            return connection;

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            if (connection != null) {
                System.out.println("You made it, take control your database now!");

            } else {
                System.out.println("Failed to make connection!");
            }
        }
        return connection;
    }


    public Double select_currency(String id) throws SQLException {
        Double curs_val = 1.0;
        Connection dbConnection = null;
        Statement statement = null;
        String selectCurrnecySQL = "SELECT  course FROM currency WHERE id=" + id;

        try {
            dbConnection = start();
            statement = dbConnection.createStatement();

            System.out.println(selectCurrnecySQL);

            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectCurrnecySQL);

            while (rs.next()) {

                curs_val = rs.getDouble("course");

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
            return curs_val;
        }
    }


    public List<Double> get_max_inv_and_trader_capital() throws SQLException {
        List<Double> list_max_capital = new ArrayList<Double>();
        Double max_capitalInv = 1.0;
        Double max_capitalTrader = 1.0;
        Connection dbConnection = null;
        Statement statement = null;
        String selectMAXCapitalSQL = "SELECT max(investor_capital*currency.course) as investor_capital, max(trader_capital*currency.course) as trader_capital" +
                "from trader LEFT JOIN currency on trader.currency_id = currency.id WHERE enabled and stock_id != 1";

        try {
            dbConnection = start();
            statement = dbConnection.createStatement();

            System.out.println(selectMAXCapitalSQL);

            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectMAXCapitalSQL);

            while (rs.next()) {

                max_capitalInv = rs.getDouble("investor_capital");
                max_capitalTrader = rs.getDouble("trader_capital");

                // return curs_val;
                list_max_capital.add(max_capitalInv);
                list_max_capital.add(max_capitalTrader);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
            return list_max_capital;
        }

    }

    public void insertRecordIntoTraderExcept(String id, String mess, String type) throws SQLException {

        Integer id_trader = Integer.parseInt(id);
        Connection dbConnection = null;
        PreparedStatement statement = null;

        String insertTableSQL = "INSERT INTO TRADER_EXCEPT"
                + "(TRADER_ID, MESS,EXCEPTION_TYPE) VALUES" + "(?,?,?)";

        try {
            dbConnection = start();

            statement = dbConnection.prepareStatement(insertTableSQL);
            System.out.println(insertTableSQL + " " + id_trader + " " + mess + " " + type);
            statement.setInt(1, id_trader);
            statement.setString(2, mess);
            statement.setString(3, type);
            statement.executeUpdate();

            System.out.println("Record is inserted into  table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    public void insertIntoQueue(String id, String task) throws SQLException {
        Connection dbConnection = null;

        PreparedStatement statement = null;

        String insertTableSQL = "INSERT INTO QUEUE"
                + "(MESSAGE, TASK) VALUES" + "(?,?)";

        try {
            dbConnection = start();
            statement = dbConnection.prepareStatement(insertTableSQL);
            System.out.println(insertTableSQL);
            statement.setString(1, id);
            statement.setString(2, task);
            statement.executeUpdate();
            System.out.println("Record is inserted into  table!  " + id + " +++ " + task);

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

}


