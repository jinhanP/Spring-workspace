package com.mire.biz.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {
    private static SqlSessionFactory sessionFactory = null;
    static {
        try {
            if (sessionFactory == null) {
            	//Mybatis 메인 설정 파일인 sql-map-config.xml 파일로부터 설정 정보를 읽어 들이기
                Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
                //입력 스트림을 통해 sql-map-config.xml 파일을 읽어 SqlSessionFactory 객체를 생성
                sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //getSqlSessionInstance() 메소드는 SqlSessionFactory 객체로부터 SqlSession 객체를 얻어내어리턴하는 메소드
    //메소드를 이용하여 SqlSession 객체가 필요한 DAO 클래스를 구현
    public static SqlSession getSqlSessionInstance() {
        return sessionFactory.openSession();

    }
}