class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> map = new HashMap<>();
        for(String word : strs){
            int[] hash = new int[26];
            for(char ch : word.toCharArray()){
                hash[ch - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int count : hash){
                key.append("$");
                key.append(count);
            }
            String str = key.toString();
            if(!map.containsKey(str)){
                map.put(str , new ArrayList<>());
            }
            map.get(str).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
