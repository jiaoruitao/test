package com.ibeifeng;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MyList {

	public static void main(String[] args) {
		Map<String,String> map =new HashMap<String,String>();
		map.put("1", "hello1");
		map.put("2", "hello2");
		map.put("3", "hello3");
		map.put("4", "hello4");
		
		Set<Entry<String,String>> entrySet=map.entrySet();
		for (Entry<String,String> entry:entrySet) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		Set<String> KeySet=map.keySet();
		for (String s :KeySet) {
			System.out.println(s);
			System.out.println(map.get(s));
		}
		
	}
}
