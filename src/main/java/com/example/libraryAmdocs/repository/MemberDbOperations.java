package com.example.libraryAmdocs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.libraryAmdocs.model.MemberTabStruct;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberDbOperations {
	
	@Autowired
	MemberTabStruct memberRec;
	
	public Connection connect() {
		
		Connection conn = null ;
		
		try {
			String url = "jdbc:sqlite:C:/SQLite/lib.db";
			conn = DriverManager.getConnection(url);
			conn.setAutoCommit(true);
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("Not Connected to database");
		}
		
		return conn ;
	}
	
	public List<MemberTabStruct> getAllMembers() throws IOException {
		
		System.out.println("Inside getAllMembers");
		List<MemberTabStruct> memberList = new ArrayList<MemberTabStruct>();
		String memberListQuery = "SELECT * FROM MEMBER";
		try(Connection conn = this.connect();
			PreparedStatement pstmt = conn.prepareStatement(memberListQuery)) {
			
			System.out.println(pstmt);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("Member id = " + rs.getInt("member_Id"));
				System.out.println("Member name = " + rs.getString("member_name"));
				System.out.println("Email id = " + rs.getString("email"));
				System.out.println("Contact Number = " + rs.getString("phoneNo"));
				
				MemberTabStruct memberResult = new MemberTabStruct();
				
				memberResult.setMemberId(rs.getString("member_Id"));
				memberResult.setMemberName(rs.getString("member_name"));
				memberResult.setEmailId(rs.getString("email"));
				memberResult.setContactNum(rs.getString("phoneNo"));
				memberResult.setIssuedFlag(rs.getString("IssuedFlag"));
				
				memberList.add(memberResult);
				
			} 
			System.out.println("Activity logged") ;
			conn.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return(memberList);
	}
	
	public void insertMember(MemberTabStruct objInpData) throws IOException {
		
		System.out.println("Inside insertMember");
		
		String memberInsertQuery = "INSERT INTO MEMBER (member_id , member_name , email , phoneNo , issuedFlag) VALUES (?, ?, ?, ?, ?) ";
		String memberIdGetQuery = "SELECT MAX(member_id) max_member_id from MEMBER";
		int newMemberId = 0 ;
		
		try( Connection conn = this.connect() ;
			 PreparedStatement pstmt = conn.prepareStatement(memberIdGetQuery) ;) {
			
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Max Member id" + rs.getInt("max_member_id"));
			
			newMemberId = rs.getInt("max_member_id") + 1 ;
			System.out.println("New Member id" + newMemberId );
			
			System.out.println("Input Member Name - " + objInpData.getMemberName());
			System.out.println("Input Member Email - " + objInpData.getEmailId());
			System.out.println("Input Contact Number - " + objInpData.getContactNum());
			System.out.println("Input issued flag - " + objInpData.getIssuedFlag());
			
			PreparedStatement memInsStmt = conn.prepareStatement(memberInsertQuery) ;
			memInsStmt.setInt(1, newMemberId );
			memInsStmt.setString(2, objInpData.getMemberName());
			memInsStmt.setString(3, objInpData.getEmailId());
			memInsStmt.setString(4, objInpData.getContactNum());
			memInsStmt.setString(5, String.valueOf(objInpData.getIssuedFlag()));
			
			System.out.println(memInsStmt);
		    memInsStmt.executeUpdate();
		    
		    System.out.println("Insert Executed");		
		} catch ( SQLException e ) {
			System.out.println(e.getMessage());	
		}
	
	}
	
}
