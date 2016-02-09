package com.javap.common.commandmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CommandMap {
	Map<String, Object> map = new HashMap<String, Object>();
	
	public Object get(String key){
		return map.get(key);
	}
	
	public void put(String key, Object value){
		map.put(key, value);
	}
	
	public Object remove(String key){
		return map.remove(key);
	}
	
	public boolean containsKey(String key){
		return map.containsKey(key);
	}
	
	public boolean containsValue(Object value){
		return map.containsValue(value);
	}
	
	public void clear(){
		map.clear();
	}
	
	public Set<Entry<String,Object>> entrySet(){
		return map.entrySet();
	}
	
	public Set<String> keySet(){
		return map.keySet();
	}
	
	public boolean isEmpty(){
		return map.isEmpty();
	}
	
	public void putAll(Map<? extends String, ?extends Object> m){
		map.putAll(m);
	}
	
	public Map<String, Object> getMap(){
		return map;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if(!map.isEmpty()) {
			Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
			Entry<String, Object> entry = null;
			while(iterator.hasNext()){
				entry = iterator.next();
				
				sb.append("key : " + entry.getKey() + ", value : " + entry.getValue());
			}
		}
		return sb.toString();
	}
}
