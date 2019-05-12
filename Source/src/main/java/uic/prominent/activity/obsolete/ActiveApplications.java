package uic.prominent.activity.obsolete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ActiveApplications {

	private Map<Integer, Application> aliveApps;
	
	public ActiveApplications(){	
		this.aliveApps = new HashMap<Integer, Application>();
	}
	
	public List<String> update(List<String[]> list, long timestamp){
		List<String> events = new ArrayList<String>();
		
		// check if an application has been closed
		Iterator<Integer> keyIter = aliveApps.keySet().iterator();
		while(keyIter.hasNext()){
			Integer key = keyIter.next();
			boolean found = false;
			for(String[] elem : list){
				if(elem[0].equals(key.toString())){
					found = true;
					if(!aliveApps.get(key).getMainwindowtitle().equals(elem[2])){
						events.add(timestamp + "\t Window title changed to " + elem[2]);
						aliveApps.get(key).setMainwindowtitle(elem[2]);
					}
					break;
				}
			}
			if(!found){
				events.add(timestamp + "\t" + key.intValue() + " " + aliveApps.get(key).getName() + " closed");
				aliveApps.remove(aliveApps.get(key));
			}
		}
		
		
		// Add new applications
		for(String[] elem : list){
			if(!aliveApps.containsKey(Integer.parseInt(elem[0]))){
				events.add(timestamp + "\t" + elem[0] + " " + elem[1] + " opened " + elem[2]);
				aliveApps.put(Integer.parseInt(elem[0]), new Application(Integer.parseInt(elem[0]), elem[1], elem[2]));
			}
		}
		
		return events;
	}
	
	public List<String> updateWindows(Map<Integer, String[]> map, long timestamp){
		List<String> events = new ArrayList<String>();
		try{
			Iterator<Application> iter = aliveApps.values().iterator();
			Application app;
			String[] str;
			while(iter.hasNext()){
				app = iter.next();
				if(map.containsKey(app.getPid())){
					str = map.get(app.getPid());
					
					if(app.getWidth() != Integer.parseInt(str[0]) || app.getHeight() != Integer.parseInt(str[1])){
						app.setWidth(Integer.parseInt(str[0]));
						app.setHeight(Integer.parseInt(str[1]));
						events.add(timestamp + "\t App " + app.getPid() + " " + app.getName() + " changed size to " + app.getWidth() + "," + app.getHeight());
					}
					
					if(app.getTop_left_x() != Integer.parseInt(str[2]) || app.getTop_left_y() != Integer.parseInt(str[3])){
						app.setTop_left_x(Integer.parseInt(str[2]));
						app.setTop_left_y(Integer.parseInt(str[3]));
						events.add(timestamp + "\t App " + app.getPid() + " " + app.getName() + " changed position to " + app.getTop_left_x() + "," + app.getTop_left_y());
					}
				}
				
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return events;
	}
	
	public String getWindowCommand(){
		String ids = "";

		Iterator<Integer> iter = aliveApps.keySet().iterator();
		boolean first = true;
		while(iter.hasNext()){
			if(first){
				ids += iter.next().toString();
				first = false;
			}else{
				ids += "," + iter.next().toString();
			}
		}
		return "get-process -Id " + ids + " | Get-Window";
	}
}