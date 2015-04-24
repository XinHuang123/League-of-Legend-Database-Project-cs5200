package edu.neu.cs5200.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.models.Champion;
import edu.neu.cs5200.models.*;

public class admin_UserDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LolDatabaseProject") ;
	EntityManager em = factory.createEntityManager();
	
	static admin_UserDAO instance = null;
	public static admin_UserDAO getInstance() {
		if(instance == null) {
			instance = new admin_UserDAO();
		}
		return instance;
	}
	
public Boolean findUserByUsernamePassword(String username, String password) {
		
		try {
			admin_User user = em.find(admin_User.class, username);
			if (user.getPassword().equals(password)) {
				return true;
			}
			return false; 
		}
		catch (Exception e) {
			System.out.println("Invalid username");
		}
		
		return false;
}

public int findUserByRole(String username) {
	

	admin_User user = em.find(admin_User.class, username);
		if (user.getRole().equals("normal")) {
			return 1;
		}
		else if(user.getRole().equals("admin"))
		{
			return 2;
		}
		else
			{
			return 0;
			}
}

	
	//createUser
	public admin_User createUser(admin_User user)
	{
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		return user;
	}
	
	//readUserByUsername
	public admin_User readUserByUsername(String username)
	{
		return em.find(admin_User.class, username);
	}
	
	// readAllUsers
		public List<admin_User> readAllUsers()
		{
			Query query = em.createQuery("select user from admin_User user");
			return (List<admin_User>)query.getResultList();
		}
		
		// updateUser
		public admin_User UpdateUser(admin_User user)
		{
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
			return user;
		}
		// deleteChampion
		public void deleteUser(String username) {
			em.getTransaction().begin();
			User user = em.find(User.class, username);
			em.remove(user);
			em.getTransaction().commit();
		}

	public static void main(String[] args) {
		admin_UserDAO dao=new admin_UserDAO();
		admin_User user=new admin_User("123","123","admin", null);
		dao.createUser(user);
		//boolean a=dao.findUserByUsernamePassword("hello", "123");
		//User user1=new User(null,"Annie");
		//user=dao.readUserByUserid(1);
		//List<User> user=dao.readAllUsers();
		//for(User users:user)
		//{
		//	System.out.println(a);
		//}
	

	}
	
	

}

