package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 28 May 2022
 * https://leetcode.com/problems/find-median-from-data-stream/
 */

class MedianFinder {
	 
	private static PriorityQueue<Integer> lowerNumbers = null;
	private static PriorityQueue<Integer> higherNumbers = null; 

    public MedianFinder() {
        
        lowerNumbers = new PriorityQueue<Integer>(new Comparator<Integer>() {
        	public int compare(Integer a, Integer b) {
        		return -1*a.compareTo(b);
        	}
        });
        
        higherNumbers = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
    	
    	if(lowerNumbers.size() == 0 || num < lowerNumbers.peek()) {
    		lowerNumbers.add(num);
    	}else {
    		higherNumbers.add(num);
    	}
    	
    	rebalanceQueue();
    	
    }
    
    public static void rebalanceQueue() {
    	
    	PriorityQueue<Integer> biggerHeap = lowerNumbers.size() > higherNumbers.size() ? lowerNumbers : higherNumbers;
    	PriorityQueue<Integer> smallHeap = lowerNumbers.size() > higherNumbers.size() ? higherNumbers : lowerNumbers;
    	
    	if(biggerHeap.size() - smallHeap.size() >= 2) {
    		smallHeap.add(biggerHeap.poll());
    	}
    }
    
    public double findMedian() {
    		
    	PriorityQueue<Integer> biggerHeap = lowerNumbers.size() > higherNumbers.size() ? lowerNumbers : higherNumbers;
    	PriorityQueue<Integer> smallHeap = lowerNumbers.size() > higherNumbers.size() ? higherNumbers : lowerNumbers;
    	
    	if(biggerHeap.size() == smallHeap.size()) {
    		return ((double)biggerHeap.peek() + (double)smallHeap.peek()) / 2;
    	}else {
    		return biggerHeap.peek();
    	}
    	
    }
    
    
    public static void main(String[] args) {
    	
    	MedianFinder medianFinder = new MedianFinder();
    	medianFinder.addNum(1);    // arr = [1]
    	medianFinder.addNum(2);    // arr = [1, 2]
    	System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
    	medianFinder.addNum(3);    // arr[1, 2, 3]
    	System.out.println(medianFinder.findMedian());// return 2.0
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */