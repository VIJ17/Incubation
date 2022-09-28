package beginnersTask;

import java.util.HashMap;
import java.util.Map;

import exceptions.WrongEntryException;

public class HashMaps
{
	public<K, V> void nullCheck(Map<K, V> map) throws WrongEntryException
	{
		if(map == null)
		{
			throw new WrongEntryException("Map is null.");
		}
	}
	public<K, V> Map<K, V> getHashMap(K key, V value)
	{
		Map<K, V> hashmap = new HashMap<K, V>();
		return hashmap;
	}
	public<K, V> int getMapSize(Map<K, V> map) throws WrongEntryException
	{
		nullCheck(map);
		return map.size();
	}
	public<K, V> boolean checkThePresenceOfKey(Map<K,V> map, K key) throws WrongEntryException
	{
		nullCheck(map);
		return map.containsKey(key);
	}
	public<K, V> boolean checkThePresenceOfValue(Map<K,V> map, V value) throws WrongEntryException
	{
		nullCheck(map);
		return map.containsValue(value);
	}
	public<K, V> V getValueOfExistingKey(Map<K,V> map, K key) throws WrongEntryException
	{
		nullCheck(map);
		return map.get(key);
	}
	public<K, V> V getValueForNonExistingKey(Map<K,V> map, K key, V defaultValue) throws WrongEntryException
	{
		nullCheck(map);
		return map.getOrDefault(key, defaultValue);
	}
	@SuppressWarnings("unchecked")
	public<K, V> V getValueOfExistingKeyWithDefault(Map<K,V> map, K key) throws WrongEntryException
	{
		nullCheck(map);
		return map.getOrDefault(key, (V) "Zoho");
	}
	public<K, V> void removeExistingKey(Map<K,V> map, K key) throws WrongEntryException
	{
		nullCheck(map);
		map.remove(key);
	}
	public<K, V> void removeExistingKeyWithValue(Map<K,V> map, K key, V value) throws WrongEntryException
	{
		nullCheck(map);
		map.remove(key, value);
	}
	public<K, V> void replaceExistingKey(Map<K,V> map, K key, V newValue) throws WrongEntryException
	{
		nullCheck(map);
		map.replace(key, newValue);
	}
	public<K, V> void replaceExistingKeyWithValue(Map<K,V> map, K key, V oldValue, V newValue) throws WrongEntryException
	{
		nullCheck(map);
		map.replace(key, oldValue, newValue);
	}
	public<K, V> void joinMaps(Map<K,V> map, Map<K,V> map1) throws WrongEntryException
	{
		nullCheck(map);
		map.putAll(map1);
	}
	public<K, V> void removeAllEntries(Map<K,V> map) throws WrongEntryException
	{
		nullCheck(map);
		map.clear();
	}
}