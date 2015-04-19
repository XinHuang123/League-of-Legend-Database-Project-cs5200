package edu.neu.cs5200.dao;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;//json->object

import edu.neu.cs5200.models.Champion;
// how to get information form API



public class MyApiChampionsClient {
	
	private final String FIND_CHAMPION_BY_ID="https://global.api.pvp.net/api/lol/static-data/na/v1.2/champion/champion_id?champData=blurb,lore&api_key=31955fd7-6220-496d-8620-9d4716c152f9";	
	private final String FIND_ALL_CHAMPIONS="https://global.api.pvp.net/api/lol/static-data/na/v1.2/champion?champData=all&api_key=31955fd7-6220-496d-8620-9d4716c152f9";              
	
	public List<Champion> findallChampions(String name)
	{
		
		String url=FIND_ALL_CHAMPIONS.replace("champion", name);
		
		System.out.println();
		
		String json=getJsonStringForUrl(url); 
		ObjectMapper mapper=new ObjectMapper();
		try {
			return (List<Champion>)mapper.readValue(json, Champion.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Champion findChampionById(int id)
	{
		String Id=String.valueOf(id);
		String url=FIND_CHAMPION_BY_ID.replace("champion_id", Id);
		
		System.out.println();
		
		String json=getJsonStringForUrl(url); 
		ObjectMapper mapper=new ObjectMapper();
		try {
			return mapper.readValue(json, Champion.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	private String getJsonStringForUrl(String urlStr) {
		try {
			URL url=new URL(urlStr);
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();// have a connection
			connection.setRequestMethod("GET");
			InputStream in = connection.getInputStream();
			InputStreamReader isr=new InputStreamReader(in); //wrap with InputStreamReader
			BufferedReader reader=new BufferedReader(isr);   //wrap with BufferedReader
			String out;
			StringBuffer json=new StringBuffer();
			
			while((out=reader.readLine())!=null)
			{
				json.append(out);
			}
			return json.toString();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	public static void main(String[] args) {
		
		MyApiChampionsClient client=new MyApiChampionsClient();
		//Movie movie=client.findMovieById("tt0499549");
		//System.out.println(movie.getPlot());
		//Champion movies=client.findallChampions("champion");
		Champion champion=client.findChampionById(35);
		//for(Champion movie:movies)
		//{
		//List<Champion> champions=client.findallChampions("champion");
		//for(Champion champion:champions)
			System.out.println(champion.getName());
			
		//}
	}

}
