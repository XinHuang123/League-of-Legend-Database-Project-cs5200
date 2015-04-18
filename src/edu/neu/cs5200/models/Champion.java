package edu.neu.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Champion {	
		@Id
		private Integer id;
		private String title;
		private String name;
		private String championkey;
		private String blurb;
		private String lore;
		
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getChampionkey() {
			return championkey;
		}
		public void setChampionkey(String championkey) {
			this.championkey = championkey;
		}
		
		public String getBlurb() {
			return blurb;
		}
		public void setBlurb(String blurb) {
			this.blurb = blurb;
		}
		
		public String getLore() {
			return lore;
		}
		public void setLore(String lore) {
			this.lore = lore;
		}
		
		public Champion() {
			super();
		}
		
		public Champion(Integer id, String title, String name , String championkey ,String blurb , String lore ) {
			super();
			this.id = id;
			this.title = title;
			this.name=name;
			this.championkey=championkey;
			this.blurb=blurb;
			this.lore=lore;
			
		}
		
}
