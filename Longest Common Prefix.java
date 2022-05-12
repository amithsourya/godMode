class Solution {
    public String longestCommonPrefix(String[] st) {
        int n = st.length;
        int ml = Integer.MAX_VALUE;
        for(String s: st)ml = Math.min(ml, s.length());
        boolean valid = true;
        int index = 0;
        for(int i=0; i<ml&&valid; i++)
        {
            char c = st[0].charAt(index);
            for(String s:st)if(s.charAt(index)!=c)valid=false;
            index++;
        }
        if(valid)index++;
        return st[0].substring(0, index-1);
    }
}
