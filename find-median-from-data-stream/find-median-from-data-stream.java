class MedianFinder {

    /** initialize your data structure here. */
    
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int val) {
        if(left.size() == 0 && right.size() == 0) {
          right.add(val);
      } else {
          if(val > right.peek()) {
              right.add(val);
              
              if(right.size() - left.size() == 2){
                  left.add(right.remove());
              }
              
          } else {
              left.add(val);
              
               if(left.size() - right.size() == 2){
                  right.add(left.remove());
              }
          }
          
      }
    }
    
    public double findMedian() {
     if(left.size() == 0 || right.size() == 0) 
         return left.size() != 0 ? (double)left.peek() : (double)right.peek();
      else if(left.size() == right.size()) {
          return (double)((left.peek() + right.peek())/ (2.0));
      } else if(left.size() > right.size()) {
          return (double)(left.peek());
      } else return (double)(right.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */