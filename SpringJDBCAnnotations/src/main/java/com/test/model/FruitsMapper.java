package com.test.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FruitsMapper implements RowMapper<Fruits> {

	@Override
	public Fruits mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Fruits f=new Fruits();
		f.setId(rs.getInt("id"));
		f.setName(rs.getString("f_name"));
		f.setPrice(rs.getInt("f_price"));
		f.setQuantity(rs.getInt("f_quantity"));
		
		return f;
	}
	
	
	
}
