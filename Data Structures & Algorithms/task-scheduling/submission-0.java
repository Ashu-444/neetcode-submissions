class Solution {
    public int leastInterval(char[] tasks, int n) {
        char[] freq = new char[26];
        for(char ch : tasks){
            freq[ch - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> Integer.compare(b , a));
        for(int f : freq){
            if(f > 0){
                pq.offer(f);
            }
        }
        int count = 0;
        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                if(!pq.isEmpty()){
                    int f = pq.poll();
                    f--;

                    if(f > 0){
                        temp.add(f);
                    }
                    count++;
                } else {
                    if(temp.isEmpty()){
                        break;
                    }
                    count++;
                }
            }
            for(int f : temp){
                pq.offer(f);
            }
        }
        return count;
    }
}
