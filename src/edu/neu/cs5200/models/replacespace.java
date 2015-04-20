package edu.neu.cs5200.models;

public class replacespace {
	

	public static void main(String[] args) {
		String s="abc d";
		s=s.replaceAll("\\s+", "");
		System.out.println(s);
	}

}
