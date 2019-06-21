package com.code.dao;

import com.code.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;


public class TrainDao {
    /**
     * sql语句
     */
    private String sql = "";


    private QueryRunner queryRunner = JdbcUtils.getQueryRunnner();

    public boolean addNewTrainRecord(String userId, String duration) {
        try {
            sql = "INSERT INTO training (userId, duration) VALUES (?, ?);";
            return queryRunner.update(sql, userId, duration) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
