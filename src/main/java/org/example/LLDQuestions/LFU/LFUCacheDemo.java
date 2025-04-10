package org.example.LLDQuestions.LFU;

public class LFUCacheDemo {


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

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache();

        lfuCache.put(1,2);
        System.out.println("1 =>" + lfuCache.get(1));
        System.out.println("1 =>" +lfuCache.get(1));
        System.out.println("1 =>" +lfuCache.get(1));

        lfuCache.put(3,6);
        System.out.println("3 =>" +lfuCache.get(3));


        lfuCache.put(4,10);
        System.out.println("4 =>" +lfuCache.get(4));
        System.out.println("4 =>" +lfuCache.get(4));

        lfuCache.put(6,9);
        System.out.println("6 =>" +lfuCache.get(6));
    }
}
