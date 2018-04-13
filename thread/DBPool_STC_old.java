package org.fh.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

public class DBPool_STC {
	//Logger
	public static Logger log = Logger. getLogger(DBPool_STC.class.getName());
	//public static LinkedList<Connection> list = new LinkedList<Connection>();
	public static DataSource ds = null;
	public static String driver;
	public static String url;
	public static String username;
	public static String userpwd;
	public static final int MINSIZE = 5;
	public static final int MAXSIZE = 10;
	//public static ConnectionPool pools;
	public static int pageSize;
	static{
		Properties ps = new Properties();
		//log2.in
		try {
			ps.load(DBPool_STC.class.getResourceAsStream("/dbConection.properties"));
		} catch (IOException e) {
			//e.printStackTrace();
		}
		String dbname = ps.getProperty("STC_DB");
//		dbname = ps.getProperty("DEFUALT_DB");//MyConstant.DEFUALT_DB;
//		pageSize = Integer.parseInt(ps.getProperty("PAGE_SIZE"));

		if (dbname.equals("SYBASE")) {

			driver = ps.getProperty("DB_DRIVER");
			url = ps.getProperty("DB_URL");

		}else if (dbname.equals("ORACLE")) {

			driver = ps.getProperty("ORACLE_DB_DRIVER");
			url = ps.getProperty("ORACLE_DB_URL");

		}else if (dbname.equals("ACCESS")) {

			driver = ps.getProperty("ACCESS_DB_DRIVER");
			url = ps.getProperty("ACCESS_DB_URL");

		} else if (dbname.equals("MYSQL")) {

			driver = ps.getProperty("MYSQL_DB_DRIVER");
			url = ps.getProperty("MYSQL_DB_URL");

		} else if(dbname.equals("SQLSERVER")){
			driver = ps.getProperty("SQLSERVER_DB_DRIVER");
			url = ps.getProperty("SQLSERVER_DB_URL");
		}
		username = ps.getProperty("DB_USERNAME_stc");
		userpwd = ps.getProperty("DB_USERPWD_stc");



		//pools = new ConnectionPool(driver,url,username,userpwd);
		try {
			Class.forName(driver);
			DataSource unpooled = DataSources.unpooledDataSource(url,
				     username,
				     userpwd);
	        ds = DataSources.pooledDataSource( unpooled );

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*try {
			pools.createPool();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*Thread t = new Thread(new RefreshConnThread());
		t.setDaemon(true);
		t.start();*/
	}
	public DBPool_STC() {

	}
	public static Connection getConnection() throws SQLException {
		//System.out.println(pool.size());
		Connection conn = ds.getConnection();
		if(MyConstant.DEFUALT_DB.equals("SYBASE")){
			conn.setAutoCommit(true);
		}else{
			conn.setAutoCommit(false);
		}
		return conn;
	}
	public static void releaseConn(ResultSet rs,Statement stmt ,Connection conn) throws SQLException{
		if(null!=rs){
			rs.close();rs=null;
		}
		if(null!=stmt){
			stmt.close();stmt=null;
		}
		releaseConn(conn);
	}
	public static void releaseConn(Connection conn) throws SQLException {
		if (null != conn) {
			/*
			 * synchronized (list) { conn.commit(); if (list.size() < MAXSIZE) {
			 * //////System.out.print("将该连接放回到连接池�?,放回之前大小:"+list.size());
			 * list.add(conn); return; } }
			 */
			// System.out.print("关闭这个连接");
			if(MyConstant.DEFUALT_DB.equals("SYSBASE")){
//				conn.setAutoCommit(true);
			}else{
				conn.commit();
			}
			
			//pools.returnConnection(conn);
			conn.close();
		}
	}
	public static void destory(){
		
	}
	public static void main(String[] args) throws Exception{
		Connection conn =    getConnection();
		System.out.println("----"+conn);
	}
}
