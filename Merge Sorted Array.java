class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int []res = new int[m+n];
        int i=0, j=0, index = 0;
        while(i!=m&&j!=n)
        {
            res[index++] = nums1[i]<nums2[j]?nums1[i++]:nums2[j++];
        }
        while(i!=m||j!=n)
        {
            res[index++] = i==m?nums2[j++]:nums1[i++];
        }
        while(--index >=0)
        {
            nums1[index] = res[index];
        }
    }
}
