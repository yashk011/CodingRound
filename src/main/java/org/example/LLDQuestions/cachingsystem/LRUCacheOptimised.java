package org.example.LLDQuestions.cachingsystem;

import java.util.HashMap;

public class LRUCacheOptimised<K,V> {
    public class CacheEntry<K ,V> {
        K key;
        V value;
        CacheEntry next, prev;

        public CacheEntry(K key , V value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    HashMap<K, CacheEntry<K,V>> cache = new HashMap<>();
    int capacity;
    CacheEntry head, tail;

    public LRUCacheOptimised(int capacity) {
        this.capacity = capacity;
        head = new CacheEntry(null, null);
        tail = new CacheEntry(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K k) {
        if(cache.containsKey(k)) {
            V ans = cache.get(k).value;
            CacheEntry entry = removeNode(cache.get(k));
            insertToHead(entry);
            System.out.println("Key == " + k + " Value == " + ans);
            return ans;
        }
        return null;
    }

    private CacheEntry removeNode(CacheEntry<K,V> kvCacheEntry) {
        kvCacheEntry.prev.next = kvCacheEntry.next;
        kvCacheEntry.next.prev = kvCacheEntry.prev;

        cache.remove(kvCacheEntry.key);

        return kvCacheEntry;
    }

    private void insertToHead(CacheEntry<K,V> kvCacheEntry) {
        head.next.prev = kvCacheEntry;
        kvCacheEntry.next = head.next;
        head.next = kvCacheEntry;
    }

    public void put(K key , V value) {
        if(!cache.containsKey(key)) {
            CacheEntry cacheEntry = new CacheEntry<>(key,value);
            if(cache.size() < capacity) {
                insertToHead(cacheEntry);
            }
            else {
                removeNode(tail.prev);
                insertToHead(cacheEntry);
            }
            cache.put(key ,cacheEntry);
        }
        else {
            CacheEntry cacheEntry = cache.get(key);
            removeNode(cacheEntry);
            insertToHead(cacheEntry);
            cache.put(key ,cacheEntry);
        }
    }

    public static void main(String[] args) {
        LRUCacheOptimised<Integer, Integer> lruCache = new LRUCacheOptimised<>(5);
        lruCache.put(1, 11);
        lruCache.put(2, 12);
        lruCache.put(3, 13);
        lruCache.put(4, 14);

        lruCache.getCacheDetails();

        System.out.println("====================");

        lruCache.put(9, 19);
        lruCache.getCacheDetails();

        System.out.println("====================");

        lruCache.put(8, 18);
        lruCache.getCacheDetails();

        System.out.println("====================");

        lruCache.put(80, 180);
        lruCache.getCacheDetails();

        System.out.println("====================");

        lruCache.get(4);
        lruCache.getCacheDetails();

    }

    private void getCacheDetails() {
        for(CacheEntry cacheEntry : cache.values()) {
            System.out.println("Key ==> " + cacheEntry.key + " Value ==>" + cacheEntry.value);
        }
    }

}
