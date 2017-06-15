package sample.restproject.messenger.database;

import java.util.HashMap;
import java.util.Map;

import sample.restproject.messenger.model.Messeges;
import sample.restproject.messenger.model.Profile;



public class DatabaseClass {
	
	private static Map<Long, Messeges> messeges = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Messeges> getMesseges(){
		return messeges;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
	

}
