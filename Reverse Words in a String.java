class Solution {
    public String reverseWords(String s) {
        String[] splitted = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=splitted.length-1; i>=0; i--)if(splitted[i].length()>0)sb.append(splitted[i]+" ");
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
