package kz.iitu.reservation.dao.mapper;

import kz.iitu.reservation.model.ReservedRooms;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservedMapper implements RowMapper<ReservedRooms> {

    @Nullable
    @Override
    public ReservedRooms mapRow(ResultSet resultSet, int i) throws SQLException {
        return new ReservedRooms(
                resultSet.getInt("employeeid"),
                resultSet.getString("roomnumber"),
                resultSet.getTimestamp("date"),
                resultSet.getTimestamp("todate")
        );
    }}
