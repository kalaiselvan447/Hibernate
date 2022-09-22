package com.masterpiece.Demohibernate;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
    	// 1. OneToOne,OneToMany,ManyToOne
    	/*AlineName aname = new AlineName();
    	aname.setFirstName("Rajendiran");
    	aname.setLastName("kalai");    	
    	aname.setMiddleName("selevan");
    	
    	Alien a = new Alien();
    	a.setAid(101);
    	a.setAname(aname);
    	a.setTech("Sql");
    	
    	Laptop lap = new Laptop();
    	lap.setLid(1);
    	lap.setLname("Dell");
    	
    	lap.getAlien().add(a);
    	a.getLaptop().add(lap);
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
    	SessionFactory sf = con.buildSessionFactory();
    	Session session = sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	session.save(a); // used to store the data in database
    	
    	session.save(lap);
//    	Alien aline = session.get(Alien.class, 101);
    	
    	tx.commit();
//    	System.out.println(aline);
*/    	
    	
    	//2. Cacheing Concepts(1.using get method, 2. using Query Method)
    	/*Alien a = null;
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
    	
    	SessionFactory sf = con.buildSessionFactory();
 
    	// 1st level Cacheing
    	Session session1 = sf.openSession();
    	session1.beginTransaction();
    	
		@SuppressWarnings("unchecked")
		Query<Alien> query = session1.createQuery("from Alien where aid = 1");
		query.setCacheable(true);  // here we are setting cacheable is true that we are using query cache method
		a = (Alien) query.uniqueResult();
    	
//    	a = session1.get(Alien.class, 1);
    	System.out.println(a);
    	
//    	a = session1.get(Alien.class, 1); // by default 1st level casing will be enabled for the 1st session if user asking for same rest it will not build another query it will return result from cache 
//    	System.out.println(a);
    	
    	session1.getTransaction().commit();
    	session1.close();
    	
    	
    	// 2nd Level Caching // by default it will be disabled we need to enable it if we want 
    	Session session2 = sf.openSession();
    	session2.beginTransaction();
    	
    	@SuppressWarnings("unchecked")
		Query<Alien> query2 = session2.createQuery("from Alien where aid = 1");
    	query2.setCacheable(true);
    	a = (Alien) query2.uniqueResult();
    	
    	
//    	a = session2.get(Alien.class, 1); // after enabling 2nd level cache it will not build another query. it uses session1 result 
    	System.out.println(a);
    	
    	session2.getTransaction().commit();
    	session2.close();*/
    	
//    	3.Hql(Hibernate Query language)
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
    	SessionFactory sf = con.buildSessionFactory();
    	Session session = sf.openSession();
    	session.beginTransaction();
    	
//    	Random random = new Random();
//    	for(int i=1; i<=50; i++) {
//    		Student s = new Student();
//    		s.setRollno(i);
//    		s.setName("Name"+i);
//    		s.setMark(random.nextInt(100));
//    		
//    		session.save(s);
//    	}
//    	
    	
    	/*@SuppressWarnings("unchecked")
//    	 1.
    	Query<Student> query1 = session.createQuery("from Student where rollno =10 ");
    	Student s = (Student)query1.uniqueResult(); // if query will not return more than one row the we can use uniqueResult function. it will return only one object 
    	System.out.println(s);
    	
//    	2.
    	@SuppressWarnings("unchecked")
		Query<Student> query = session.createQuery("from Student where mark <50 "); // in hql mention class name as table name and property name as column name
    	
    	List<Student> students = query.list();
    	
    	for(Student student: students) {
    		System.out.println(student);
    	}*/
    	
    	// using select statement by mentioning column name for single row result
    	/*
    	@SuppressWarnings("unchecked")
    	Query<Object> query3 = session.createQuery("select rollno,name,mark from Student where rollno =10 "); // when you use select statement it will return objects. it has to be type casted as objects
    	Object[] student = (Object[]) query3.uniqueResult();  
    	
//    	1.
    	for(Object s:student) 
    		System.out.println(s);
    	
//    	2.
    	System.out.println(student[0] + " : " + student[1] + " : " + student[2]);
    	*/
    	
    	/*// using select statement by mentioning column name for single row result
    	
    	@SuppressWarnings("unchecked")
		Query<Object[]> query = session.createQuery("select rollno,name,mark from Student where mark <50 "); // in hql mention class name as table name and property name as column name
    	
    	List<Object[]> students = (List<Object[]>)query.list();
    	
    	for(Object[] student: students) {
    		System.out.println(student[0] + " : " + student[1] + " : " + student[2]);
    	}*/
    	
    	//4. SqlQuery method (this is called as Native query). here in select statement we should mention column name instead of property name
    	
    	@SuppressWarnings("unchecked")
		SQLQuery<Object[]> query = session.createSQLQuery("select roll_no as rollno,student_name as name,student_mark as mark from Student where student_mark <50 ");
//    	query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    	List<Object[]> list = query.list();
    	
    	//1. without using ALIAS_TO_ENTITY_MAP 
//    	for(Object obj : list) {
//    		Map m = (Map)obj;
//    		
//    		System.out.println(m.get("name")+" : "+ m.get("mark"));
//    	}
    	
    	//2. without using ALIAS_TO_ENTITY_MAP 
    	for(Object objs : list) {
    		
    		Object[] obj = (Object[]) objs;
    		
    		System.out.println((String) obj[1] + " : "+ (Integer) obj[2]);
    	}
    	
    	session.getTransaction().commit();
    	session.close();
    }
}
