import java.util.*;

public class Main {
	static int[] bc = new int[26];
	public static void bcf(char []st, char []pat)
	{
		int n = pat.length;
		for(int i=0; i<26; i++)bc[i] = n;
		for(int i=0; i<pat.length; i++)bc[pat[i]-'A'] = i;
	}
	public static void search(char []st, char[]pat)
	{
		int s = 0;
		int stl = st.length;
		int pl = pat.length;
		while(s<=(stl-pl))
		{
			int j = pl-1;
			while(j>=0&&pat[j]==st[s+j])j--;
			if(j<0)System.out.println("Pattern found at index "+(s++));
			else
			{
				s += Math.max(1, j-bc[st[s+j]-'A']);
			}
		}
	}
	public static void main(String[] args) {
		char[] st = "AAABBBABAABAAABAABA".toCharArray();
		char[] pat = "ABA".toCharArray();
		bcf(st, pat);
		search(st, pat);
	}
}

