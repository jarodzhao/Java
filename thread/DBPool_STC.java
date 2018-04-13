package org.fh.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

public class DBPool_STC {
	//Logger
	public static Logger log = Logger. getLogger(DBPool_STC.class.getName());
	//public static LinkedList<Connection> list = new LinkedList<Connection>();
	private static ComboPooledDataSource dss = null;
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

		try {
			dss = new ComboPooledDataSource();
			// 设置JDBC的Driver类
			dss.setDriverClass(driver);  // 参数由 Config 类根据配置文件读取
			// 设置JDBC的URL
			dss.setJdbcUrl(url);
			// 设置数据库的登录用户名
			dss.setUser(username);
			// 设置数据库的登录用户密码
			dss.setPassword(userpwd);
			// 设s置连接池的最大连接数
			dss.setMaxPoolSize(MAXSIZE);
			// 设置连接池的最小连接数
			dss.setMinPoolSize(MINSIZE);
			//当连接池连接耗尽时，客户端调用getConnection()后等待获取新连接的时间，超时后将抛出SQLException，如设为0则无限期等待。单位毫秒。默认: 0
			dss.setCheckoutTimeout(3000);
			//定义在从数据库获取新连接失败后重复尝试的次数。默认值: 30 ；小于等于0表示无限次
			dss.setAcquireRetryAttempts(0);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public DBPool_STC() {
		
	}
	public static Connection getConnection() throws SQLException {
		//System.out.println(pool.size());
		Connection conn = dss.getConnection();
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
