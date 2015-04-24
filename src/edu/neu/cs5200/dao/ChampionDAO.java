 package edu.neu.cs5200.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import edu.neu.cs5200.models.*;


public class ChampionDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LolDatabaseProject") ;
	EntityManager em = factory.createEntityManager();
	
	//createChampion
	public Champion createChampion(Champion champion) {
		em.getTransaction().begin();		
		em.persist(champion);
		em.getTransaction().commit();
		return champion;
	}
	
	
//	public Champion readChampionByName(String name)
//	{
//		return em.find(Champion.class, name);
//	}
	
	
	
	public Champion readChampionById(Integer id)
	{
		return em.find(Champion.class, id);
	}
	
	// readAllChampions
	public List<Champion> readAllChampions()
	{
		Query query = em.createQuery("select champion from Champion champion");
		return (List<Champion>)query.getResultList();
	}
	
	// updateChampion
	public Champion updateChampion(Champion champion)
	{
		em.getTransaction().begin();
		em.merge(champion);
		em.getTransaction().commit();
		return champion;
	}
	// deleteChampion
	public void deleteChampion(int id) {
		em.getTransaction().begin();
		Champion champion = em.find(Champion.class, id);
		em.remove(champion);
		em.getTransaction().commit();
	}
	
	public void addUser(Integer id, User user)  //user like that champion
	{
		em.getTransaction().begin();
		Champion champion = em.find(Champion.class, id);
		user.setChampionid(champion);
		champion.getUsers().add(user);
		em.merge(champion);
		em.getTransaction().commit();
	}
	
	

	public static void main(String[] args) {
		MyApiChampionsClient client=new MyApiChampionsClient();
		//for(int i=74;i<77;i++)
		//{
		ChampionDAO dao=new ChampionDAO();
		//User user=new User("messi","luck","hello",null);
		//dao.addUser(1,user);
		Champion champion=dao.readChampionById(2);			

		//Champion champion=dao.readChampionByName("Annie");
		//Champion champion=dao.readChampionById(1);
		//	Champion champions=new Champion(champion.getId(),champion.getTitle(),champion.getName(),champion.getKey(),champion.getBlurb(),champion.getLore());
		//	dao.createChampion(champions);
		//}
		
		//champion=dao.createChampion(champion);
		//System.out.println(champions.getTitle());		
	    //dao.deleteChampion(1);				
		//List<Champion> champion=dao.readAllChampions();
		//for(Champion champions:champion)
		//{
		
			System.out.println(champion.getComments().size());
		//}
		

	}

	

}
