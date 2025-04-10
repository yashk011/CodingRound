package org.example.LLDQuestions.cachingsystem;

public class CacheEntry<K ,V> {
    K key;
    V value;

    public CacheEntry(K key , V value) {
        this.key = key;
        this.value = value;
    }
}
