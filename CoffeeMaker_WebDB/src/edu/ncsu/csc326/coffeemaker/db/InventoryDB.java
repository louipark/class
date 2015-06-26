package edu.ncsu.csc326.coffeemaker.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class InventoryDB {

	public static boolean addInventory(int coffee,int milk, int sugar,int chocolate) {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean inventoryAdded = false;
		try {
			conn = db.getConnection();
			stmt = conn
					.prepareStatement("INSERT INTO inventory VALUES(?,?,?,?)");
			stmt.setInt(1, coffee);
			stmt.setInt(2, milk);
			stmt.setInt(3, sugar);
			stmt.setInt(4, chocolate);
			int updated = stmt.executeUpdate();
			if (updated == 1) {
				inventoryAdded = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
		return inventoryAdded;
	}

	public static int checkInventory(String name) {
		int reVal=0;
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = db.getConnection();
			stmt = conn
					.prepareStatement("SELECT sum(amt) AS total FROM inventory WHERE name=?");
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			// Only one result b/c name is primary key
			if (rs.next()) {
				reVal = rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
		return reVal;
	}

	public static boolean useInventory(int coffee,int milk, int sugar,int chocolate) {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean inventoryAdded = false;
		try {
			conn = db.getConnection();
			stmt = conn
					.prepareStatement("INSERT INTO inventory VALUES(?,?,?,?)");
			stmt.setInt(1, -coffee);
			stmt.setInt(2, -milk);
			stmt.setInt(3, -sugar);
			stmt.setInt(4, -chocolate);
			int updated = stmt.executeUpdate();
			if (updated == 1) {
				inventoryAdded = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
		return inventoryAdded;
	}
}
