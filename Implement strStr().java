class Solution {
    public int strStr(String haystack, String needle) {
        int hl = haystack.length();
        int nl = needle.length();
        for(int i=0; i<hl; i++)
        {
            boolean in = true;
            for(int j=0; j<nl; j++)
            {
                if(i+j==hl||needle.charAt(j)!=haystack.charAt(i+j))
                {
                    in = false;
                    break;
                }
            }
            if(in)return i;
        }
        return -1;
    }
}
