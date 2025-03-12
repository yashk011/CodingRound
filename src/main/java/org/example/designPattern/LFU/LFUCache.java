package org.example.designPattern.LFU;

//capacity = 3
//
//Requests
//=======
//
//1,2
//1,2
//1,2
//1,2
//3,2
//3,2
//4,1
//4,1
//4,1
//6,1
//
//1->3
//3->2
//4->3
//
//6,1 ==> Remove 3
//
//Cache ?
//
//KeyToValueFreqMap
//
//1->(2,4)
//3->(2,2)
//4->(1,3)
//========
//Add - 6-> (1,1)
//Remove - LFU Key i.e 3
//
//freqToKeyMap
//============
//4-> 1
//2-> 3
//3-> 4

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    int capacity;
    HashMap<Integer, int[]> keyToValueFreqMap;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeyMap;
    int minFreq;

    public LFUCache() {
        keyToValueFreqMap = new HashMap<>();
        freqToKeyMap = new HashMap<>();
        capacity = 3;
        minFreq = 0;
    }

    public int get(int key) {
        if(!keyToValueFreqMap.containsKey(key))
            return -1;

        int[] currentNode = keyToValueFreqMap.get(key);
        int val = currentNode[0];
        int freq = currentNode[1];

        // Update key map
        keyToValueFreqMap.put(key,new int[]{val, freq+1});

        // Update freq map
        freqToKeyMap.get(freq).remove(key);

        if(freqToKeyMap.get(freq).isEmpty()) {
            freqToKeyMap.remove(freq);
            if(minFreq == freq) {
                minFreq++;
            }
        }

        freqToKeyMap.computeIfAbsent(freq+1 , k -> new LinkedHashSet<>()).add(key);
        return val;
    }

    public void put(int key, int val) {
        if(keyToValueFreqMap.containsKey(key)) {
            int[] node = keyToValueFreqMap.get(key);
            node[0] = val;
            get(key);
            return;
        }

        if(keyToValueFreqMap.size() >= capacity) {
            System.out.println("Maximum Capacity Reached !!!");
            int lfKey = freqToKeyMap.get(minFreq).iterator().next();
            System.out.println("Removing - " + lfKey);

            freqToKeyMap.get(minFreq).remove(lfKey);

            if(freqToKeyMap.get(minFreq).isEmpty())
                freqToKeyMap.remove(minFreq);

            keyToValueFreqMap.remove(lfKey);
        }

        keyToValueFreqMap.put(key , new int[] {val, 1});
        freqToKeyMap.computeIfAbsent(1, k-> new LinkedHashSet<>()).add(key);
        minFreq = 1;

    }
}


