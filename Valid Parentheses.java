class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        String par = "(){}[]";
        for(char c: s.toCharArray())
        {
            if(c=='('||c=='{'||c=='[')st.push(c);
            else
            {
                if(st.empty())return false;
                if(par.charAt(par.indexOf(st.peek())+1)==c)st.pop();
                else return false;
            }
        }
        if(st.empty())return true;
        return false;
    }
}
