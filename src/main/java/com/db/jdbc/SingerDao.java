package com.db.jdbc;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingerDao {
    private static Logger logger = LoggerFactory.getLogger(SingerDao.class);

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("Problem with db driver");
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres?currentSchema=musicdb",
                "postgres",
                "1");
    }

    public static List<Singer> findAll() {
        List<Singer> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = SingerDao.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from singer");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Singer singer = new Singer();
                singer.setId(resultSet.getLong("id"));
                singer.setFirstName(resultSet.getString("first_name"));
                singer.setLastName(resultSet.getString("last_name"));
                singer.setBirthDate(resultSet.getDate("birth_date"));
                result.add(singer);
            }
            statement.close();
        } catch (SQLException ex) {
            logger.error("Problem executing SELECT", ex);
        } finally {
            SingerDao.closeConnection(connection);
        }
        return result;
    }

    public static void insert(Singer singer) {
        Connection connection = null;
        try {
            connection = SingerDao.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "insert into singer "
                            + "(first_name, last_name, birth_date) "
                            + "values (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, singer.getFirstName());
            statement.setString(2, singer.getLastName());
            statement.setDate(3, singer.getBirthDate());
            statement.execute();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                singer.setId(result.getLong("id"));
            }
            statement.close();
        } catch (SQLException ex) {
            logger.error("Problem executing INSERT", ex);
        } finally {
            SingerDao.closeConnection(connection);
        }
    }

    public static void delete(Long id) {
        Connection connection = null;
        try {
            connection = SingerDao.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "delete from singer where id=?");
            statement.setLong(1, id);
            statement.execute();
            connection.close();
        } catch (SQLException ex) {
            logger.error("Problem executing DELETE");
        } finally {
            closeConnection(connection);
        }
    }

    private static void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException ex) {
            logger.error("Could not close db connection");
        }
    }

    public static void main(String[] args) throws SQLException {
        List<Singer> singers = findAll();

        Singer damonAlbarn = new Singer();
        damonAlbarn.setBirthDate(Date.valueOf("1968-03-23"));
        damonAlbarn.setLastName("Albarn");
        damonAlbarn.setFirstName("Damon");
        insert(damonAlbarn);

        SingerDao.delete(4L);
    }
}
