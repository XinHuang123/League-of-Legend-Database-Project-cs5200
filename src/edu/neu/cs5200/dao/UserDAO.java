package edu.neu.cs5200.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.models.Champion;
import edu.neu.cs5200.models.User;
public class UserDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LolDatabaseProject") ;
	EntityManager em = factory.createEntityManager();
	
	//createUser
	public User createUser(User user)
	{
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		return user;
	}
	
	//readUserByName
	public User readUserByName(String name)
	{
		return em.find(User.class, name);
	}
	
	// readAllUsers
		public List<User> readAllUsers()
		{
			Query query = em.createQuery("select user from User user");
			return (List<User>)query.getResultList();
		}
		
		// updateUser
		public User updateUser(User user)
		{
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
			return user;
		}
		// deleteChampion
		public void deleteUser(int id) {
			em.getTransaction().begin();
			User user = em.find(User.class, id);
			em.remove(user);
			em.getTransaction().commit();
		}

	public static void main(String[] args) {
		UserDAO dao=new UserDAO();
		//User user=new User(1,"Xin");
		//User user1=new User(null,"Annie");
		dao.deleteUser(2);
		//List<User> user=dao.readAllUsers();
		//for(User users:user)
		//{
		//	System.out.println(users.getName());
		//}
	

	}

}
