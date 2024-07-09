package com.theatre.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.theatre.util.DatabaseUtil;

public class DatabaseUtilTest {

	@Test
	public void testGetConnection() {
		try (Connection connection = DatabaseUtil.getConnection()) {
			assertNotNull(connection, "Connection should not be null");
			assertFalse(connection.isClosed(), "Connection should be open");
		} catch (SQLException e) {
			fail("SQL exception: " + e.getMessage());
		}
	}
}
