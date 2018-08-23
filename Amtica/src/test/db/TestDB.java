package test.db;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.entity.Admin;
import test.entity.Property;
import test.entity.RoomModel;
import test.entity.User;

public class TestDB {

	public static String getPassword(Admin u) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(test.entity.Admin.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		Admin admin = null;
		try {
			session.beginTransaction();
			admin = session.get(Admin.class, u.getEmail());
			//System.out.println(admin);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		if(admin!=null)
			return admin.getPassword();
		else return "";

	}

	public static String getName(User u) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(test.entity.User.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		User user = null;
		try {
			session.beginTransaction();
			user = session.get(User.class, u.getEmail());
			System.out.println(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		return user.getFirst_name();

	}

	public static String encryptedPwd(String pass) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

	public static void insertUser(User user) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(test.entity.User.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	public static boolean checkUser(String email) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(test.entity.User.class).buildSessionFactory();
		List<User> l = null;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from User u where u.email=?");
			query.setParameter(0, email);
			l = query.getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			factory.close();
		}

		if (l.isEmpty())
			return false;
		else
			return true;
	}

	public static int getNextRoomId() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(test.entity.RoomModel.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		int ind = 0;
		try {
			session.beginTransaction();
			Query query = session.createQuery("select r.id from RoomModel r");
			ArrayList<Integer> l = (ArrayList<Integer>) query.getResultList();
			Collections.sort(l);
			ind = l.get(l.size() - 1) + 1;
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			factory.close();
		}
		return ind;
	}

	public static void insertRoom(RoomModel room) throws Exception {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(test.entity.RoomModel.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(room);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

	public static ArrayList<Property> getProperty() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(test.entity.Property.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		ArrayList<Property> l = new ArrayList<Property>();
		try {
			session.beginTransaction();
			Query query = session.createQuery("select p.property_name from Property p");
			l = (ArrayList<Property>) query.getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		return l;
	}

	public static void insertProperty(Property property) throws Exception {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(test.entity.Property.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Property prop = session.get(Property.class, property.getProperty_name());
		if (prop == null)
			session.save(property);
		else
			throw new Exception();
		session.getTransaction().commit();
		factory.close();
	}

	public static void deleteProperty(Property property) throws Exception {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(test.entity.Property.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		Property prop = session.get(Property.class, property.getProperty_name());
		session.delete(prop);
		session.getTransaction().commit();
		factory.close();
	}

	public static boolean checkAdmin(Admin admin) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(test.entity.Admin.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		boolean result=true;
		try
		{
			session.beginTransaction();
			Query q=session.createQuery("select a.email from Admin a where a.email=?");
			q.setParameter(0, admin.getEmail());
			List l=q.getResultList();
			if(l.size()==0)
				result=false;
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
		return result;
	}
	
	public static void addAdmin(Admin admin)
	{
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Admin.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try
		{
			session.beginTransaction();
			session.save(admin);
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}
	
	public static void updateAdminPassword(Admin admin)
	{
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Admin.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try
		{
			session.beginTransaction();
			Admin a=session.get(Admin.class, admin.getEmail());
			a.setPassword(admin.getPassword());
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}
	
	public static ArrayList getTitle(String email)
	{
		ArrayList<String> al=new ArrayList<String>();
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RoomModel.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try
		{
			session.beginTransaction();
			Query query=session.createQuery("select r.title from room r where r.email=?");
			query.setParameter(0, email);
			al=(ArrayList)query.getResultList();
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
		return al;
	}
	
}
