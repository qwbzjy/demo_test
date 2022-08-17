package com.example.demo_test.typehandlers;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * @author qiwenbo
 * @date 2022/8/17 17:17
 * @Description
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(List.class)
@Slf4j
public class ListTypeHandler implements TypeHandler<List<String>> {
    @Override
    public void setParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, dealListToOneString(parameter));
    }

    private String dealListToOneString(List<String> parameter) {
        if (CollectionUtil.isEmpty(parameter)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        parameter.forEach(item -> sb.append(item).append(","));
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    @Override
    public List<String> getResult(ResultSet rs, String columnName) throws SQLException {
        return Arrays.asList(rs.getString(columnName).split(","));
    }

    @Override
    public List<String> getResult(ResultSet rs, int columnIndex) throws SQLException {
        return Arrays.asList(rs.getString(columnIndex).split(","));
    }

    @Override
    public List<String> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Arrays.asList(cs.getString(columnIndex).split(","));
    }
}
