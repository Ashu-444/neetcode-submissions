class MedianFinder {

    PriorityQueue<Integer> left; // maxHeap
    PriorityQueue<Integer> right; // minHeap

    public MedianFinder() {
        left = new PriorityQueue<>((a , b)-> Integer.compare(b,a));
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.isEmpty() || num <= left.peek()){
            left.add(num);
        } else {
            right.add(num);
        }
        // balance 
        if(left.size() > right.size() + 1){
            right.add(left.poll());
        }

        if(right.size() > left.size() + 1){
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()){
            return (left.peek() + right.peek()) / 2.0;
        }
        if(left.size() > right.size()){
            return left.peek();
        }
        return right.peek();
    }
}
