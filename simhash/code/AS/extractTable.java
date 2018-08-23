package AS;

import java.sql.*;

public class extractTable {
	
	String dbIP;
	int dbPort;
	String userName;
	String passname;
	String tableName;
	Connection connection;
	Connection connection_database;
	FileOperation fi;

    static Statement sm=null;
	
	public extractTable(){
		
	}
	
	public extractTable(String dbIP1,int dbPort1,String userName1,String passname1,String tableName1){
		dbIP=dbIP1;
		dbPort=dbPort1;
		userName=userName1;
		passname=passname1;
		tableName=tableName1;
		fi=new FileOperation();
		
		
	}
	
	public boolean write() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		connection_database=(Connection) DriverManager.getConnection("jdbc:mysql://"+dbIP+":"+dbPort+"/mysql",userName,passname);
		System.out.println("数据库连接成功 ");//结束计算时间
		
		
		
		
		
		
		return true;
		
	}
	
	
	
}
