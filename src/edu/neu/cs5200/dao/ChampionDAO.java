package edu.neu.cs5200.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.models.Champion;



public class ChampionDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LolDatabaseProject") ;
	EntityManager em = factory.createEntityManager();
	
	//createChampion
	private Champion createChampion(Champion champion) {
		em.getTransaction().begin();		
		em.persist(champion);
		em.getTransaction().commit();
		return champion;
	}
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ChampionDAO dao=new ChampionDAO();
		//Champion champion=new Champion(1, "456","123","123","123","123");
		//champion=dao.createChampion(champion);
		//System.out.println(champion.getId());
		//dao.updateChampion(champion);
		//List<Champion> champion=dao.readAllChampions();
		//for(Champion champions:champion)
		//{
		//	System.out.println(champions.getName());
		//}

	}

	

}
