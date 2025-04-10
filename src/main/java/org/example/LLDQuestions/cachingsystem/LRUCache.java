package org.example.LLDQuestions.cachingsystem;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {

    public class CacheEntry<K ,V> {
        K key;
        V value;

        public CacheEntry(K key , V value) {
            this.key = key;
            this.value = value;
        }
    }


    HashMap<K, CacheEntry<K,V>> cache;
    HashMap<K, Long> accessMap;
    public final int capacity;

    LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        accessMap = new HashMap<>();
    }

    public V get(K key) {
        if(!cache.containsKey(key)) {
            System.out.println("Key not available");
            return null;
        }

        CacheEntry<K,V> c = cache.get(key);
        accessMap.put(key, System.nanoTime());
        return c.value;
    }

    public void put(K key , V value) {
        if(cache.containsKey(key)) {
          cache.put(key, new CacheEntry<>(key, value));
          accessMap.put(key , System.nanoTime());
          return;
        }

        System.out.println("=========================");
        if(cache.size() >= capacity) {
            K lruKey = findLRUKey();
            System.out.println("Capacity Not available ");
            System.out.println("Removing LRU cache entry");
            System.out.println("Key removed " + lruKey);
            cache.remove(lruKey);
            cache.put(key, new CacheEntry<>(key, value));
            System.out.println("key - " + cache.get(key).key + " val - " + cache.get(key).value);
        }
        else {
            System.out.println("Capacity available ");
            System.out.println("Inserting into cache");
            cache.put(key, new CacheEntry<>(key, value));
            System.out.println("key - " + cache.get(key).key + " val - " + cache.get(key).value);
            accessMap.put(key, System.nanoTime());
        }
        System.out.println("=========================");
    }

    public void getCacheDetails() {
        for(CacheEntry<K,V> entry : cache.values()) {
            System.out.println("Key ==>" + entry.key + " Value ===>" + entry.value);
        }
    }

    private K findLRUKey() {
        Long min_value = Long.MAX_VALUE;
        K minKey = null;
        for(Map.Entry<K,Long> entry : accessMap.entrySet()) {
            if(entry.getValue() < min_value) {
                min_value = entry.getValue();
                minKey = entry.getKey();
            }
        }
        return minKey;
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(5);
        lruCache.put(1, 11);
        lruCache.put(2, 12);
        lruCache.put(3, 13);
        lruCache.put(4, 14);

        lruCache.getCacheDetails();

        System.out.println("Value ===> " + lruCache.get(3));

        lruCache.getCacheDetails();

        lruCache.put(9, 19);
        lruCache.getCacheDetails();

        lruCache.put(8, 18);
        lruCache.getCacheDetails();

    }
}
