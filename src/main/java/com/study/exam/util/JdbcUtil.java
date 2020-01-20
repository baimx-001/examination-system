package com.study.exam.util;
import org.apache.commons.dbcp.BasicDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
/**
 * ；连接池版本的数据库连接管理工具类。适合于并发场合
 */
public class JdbcUtil {
    private  static String driver;
    private  static String url;
    private  static String username;
    private  static String password;
    private  static int initSize;
    private  static int maxActive;
    private  static BasicDataSource ds;//连接池
    static {
        ds=new BasicDataSource();
        Properties cfg=new Properties();//抛出异常
        try{
            InputStream in=JdbcUtil.class.//统一用法
                    getClassLoader().
                    getResourceAsStream("conf/jdbc.properties");
            cfg.load(in);
            //初始化参数
            driver=cfg.getProperty("jdbc.driver");
            url=cfg.getProperty("jdbc.url");
            username=cfg.getProperty("jdbc.username");
            password=cfg.getProperty("jdbc.password");
            initSize=Integer.parseInt(cfg.getProperty("initSize"));
            maxActive=Integer.parseInt(cfg.getProperty("maxActive"));
            in.close();
            //初始化连接池
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);
            ds.setInitialSize(initSize);
            ds.setMaxActive(maxActive);

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public static Connection getConnection(){
        try{
            //getConnection()从连接池中获取重用的连接，
            //如果连接池满了。则等待。
            //如果有连接归还，则获取重用的连接
            Connection conn=ds.getConnection();
            return conn;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static void close(Connection conn){
        if(conn!=null){
            try{
                //将用过的连接归还到连接池
                conn.close();
            }catch (Exception e){
                e.printStackTrace();;
            }
        }
    }
    public static void rollback(Connection conn){
        if(conn!=null){
            try {
                conn.rollback();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection connection = JdbcUtil.getConnection();
        System.out.println("conn:"+connection);

    }
}
