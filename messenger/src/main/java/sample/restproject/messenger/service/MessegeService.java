package sample.restproject.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import sample.restproject.messenger.database.DatabaseClass;
import sample.restproject.messenger.model.Messeges;

public class MessegeService {
	
	private Map<Long, Messeges> messeges = DatabaseClass.getMesseges();
	
	public MessegeService(){
		messeges.put(1L, new Messeges(1,"Hello World!","Nikki"));
		messeges.put(2L, new Messeges(2,"Hello People!","Nikki"));
	}

	public List<Messeges> getAllMesseges(){
//		Messeges m1 = new Messeges(1L,"Hello World!","Nikki");
//		Messeges m2 = new Messeges(2L,"Hello People!","Nikki");
		
		return new ArrayList <Messeges>(messeges.values());
	}
	
	public List<Messeges> getAllMessegesForYear(int year){
		List<Messeges> msgForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Messeges messege : messeges.values()){
			cal.setTime(messege.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				msgForYear.add(messege);
			}
		}
		return msgForYear;
 	}
	
	public List<Messeges> getAllMessegesPaginated(int start, int size){
		ArrayList<Messeges> list = new ArrayList<Messeges>(messeges.values());
		if(start+size > list.size())
		{
			return new ArrayList<Messeges>();
		}
		return list.subList(start, start+size);
	}
	
	public Messeges getMesseges(long id){
		return messeges.get(id);
	}
	
	public Messeges addMesseges(Messeges messege){
		messege.setId(messeges.size() + 1);
		messeges.put(messege.getId(),messege);
		return messege;
	}
	
	public Messeges updateMessege(Messeges messege){
		if(messege.getId()<=0){
			return null;
		}
		messeges.put(messege.getId(), messege);
		return messege;
	}
	
	public Messeges removeMessege(long id){
		return messeges.remove(id);
	}
	
}
