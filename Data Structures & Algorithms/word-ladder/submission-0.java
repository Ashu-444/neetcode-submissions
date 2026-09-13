class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;
        while(!q.isEmpty()){
            int n = q.size();

            while(n-- > 0){
                char[] word = q.poll().toCharArray();

                for(int i = 0; i < word.length; i++){
                    char old = word[i];

                    for(char ch = 'a'; ch <= 'z'; ch++){
                        word[i] = ch;
                        String s = new String(word);

                        if(s.equals(endWord)) return level+1;

                        if(set.remove(s)) q.add(s);
                    }
                    word[i] = old;
                }
            }
            level++;
        }
        return 0;
    }
}
