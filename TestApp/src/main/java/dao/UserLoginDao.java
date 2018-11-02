package dao;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.Hibernate.HibernateUtil;
import model.UserLogin;

public class UserLoginDao {

 public static void saveUser(UserLogin user) {
   Session session = HibernateUtil.getSessionFactory().openSession();
   session.beginTransaction();

   session.save(user);

   session.getTransaction().commit();
  }

  public static void updateUser(UserLogin user) {
   Session session = HibernateUtil.getSessionFactory().openSession();
   session.beginTransaction();

   session.merge(user);

   session.getTransaction().commit();
  }

  public static void deleteUser(UserLogin user) {
   Session session = HibernateUtil.getSessionFactory().openSession();
   session.beginTransaction();

   session.delete(user);

   session.getTransaction().commit();
  }

  public static ArrayList<?> getUser() {
   Session session = HibernateUtil.getSessionFactory().openSession();
   session.beginTransaction();

   @SuppressWarnings("unchecked")
ArrayList<UserLogin> list = ((ArrayList<UserLogin>) session.createQuery("from userlogin").list());
   ArrayList<String> dataList = new ArrayList<String>();
   if (list != null) {
    for (int i = 0; i < list.size(); i++) {
    	dataList.add(list.get(i).getUserName());
    	dataList.add(list.get(i).getPassword());    
   }
   }
   		session.getTransaction().commit();
   		return dataList;
  }

}

