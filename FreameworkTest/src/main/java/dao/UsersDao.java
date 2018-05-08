package dao;

import java.util.ArrayList;

import org.hibernate.*;

import dao.Hibernate.HibernateUtil;
import model.Users;

public class UsersDao {

 public static void saveUser(Users user) {
   Session session = HibernateUtil.getSessionFactory().openSession();
   session.beginTransaction();

   session.save(user);

   session.getTransaction().commit();
  }

  public static void updateUser(Users user) {
   Session session = HibernateUtil.getSessionFactory().openSession();
   session.beginTransaction();

   session.merge(user);

   session.getTransaction().commit();
  }

  public static void deleteUser(Users user) {
   Session session = HibernateUtil.getSessionFactory().openSession();
   session.beginTransaction();

   session.delete(user);

   session.getTransaction().commit();
  }

public static ArrayList<?> getUser() {
   Session session = HibernateUtil.getSessionFactory().openSession();
   session.beginTransaction();
   
   @SuppressWarnings("unchecked")
   ArrayList<Users> list = (ArrayList<Users>) session.createQuery("from users").list();
   ArrayList<String> dataList = new ArrayList<String>();
   if (list != null) {
    for (int i = 0; i < list.size(); i++) {
    	dataList.add(list.get(i).getUserName());
    	dataList.add(list.get(i).getName());
    	dataList.add(list.get(i).getDob());
    	dataList.add(list.get(i).getGender());    
   }
   }
   		session.getTransaction().commit();
   		return dataList;
  }

}
