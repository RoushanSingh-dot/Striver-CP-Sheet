import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;





//import jdk.javadoc.internal.doclets.toolkit.NestedClassWriter;
 
 
 
 
public class Codeforces {
	static String ab,b;
	static class Node
	{
		int val;
		Node left;
		Node right;
		public Node(int x) {
			// TODO Auto-generated constructor stub
			this.val=x;
			this.left=null;
			this.right=null;
			}
	}
	static class Pair<U, V> implements Comparable<Pair<U, V>> {
        public U x;
        public V y;
 
        public Pair(U x, V y) {
            this.x = x;
            this.y = y;
        }
 
        public int compareTo(Pair<U, V> o) {
            int value = ((Comparable<U>) x).compareTo(o.x);
            if (value != 0) return value;
            return ((Comparable<V>) y).compareTo(o.y);
        }
 
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return x.equals(pair.x) && y.equals(pair.y);
        }
 
        public int hashCode() {
            return Objects.hash(x, y);
        }
 
    }
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        }
        int[] nextArray(int n)
        {
        	int arr[]=new int[n];
        	for(int i=0;i<n;i++)
        		arr[i]=nextInt();
        	return arr;
        }
    } 
	static String string;
	static int gcd(int a, int b)
    {
        // Everything divides 0 
        if (a == 0)
          return b;
        if (b == 0)
          return a;
      
        // base case
        if (a == b)
            return a;
      
        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
	static long gcd(long a, long b)
    {
        // Everything divides 0 
   
        for(long i=2;i<=b;i++)
        {
        	if(a%i==0&&b%i==0)
        		return i;
        }
        return 1;
    }
	static int fac(int n)
	{
		int c=1;
		for(int i=2;i<n;i++)
		if(n%i==0)
			c=i;
		return c;
	}
	
	
	static int lcm(int a,int b)
	{
		for(int i=Math.min(a, b);i<=a*b;i++)
			if(i%a==0&&i%b==0)
				return i;
		return 0;
	}
	static int maxheight(char[][] ch,int i,int j,String[] arr)
	{
		int h=1;
		if(i==ch.length-1||j==0||j==ch[0].length-1)
			return 1;
		while(i+h<ch.length&&j-h>=0&&j+h<ch[0].length&&ch[i+h][j-h]=='*'&&ch[i+h][j+h]=='*')
		{
			String whole=arr[i+h];
			//System.out.println(whole.substring(j-h,j+h+1));
			if(whole.substring(j-h,j+h+1).replace("*","").length()>0)
				return h;
			h++;
		}
			
		return h;
	}
	static boolean all(BigInteger n)
	{
		BigInteger c=n;
		HashSet<Character> hs=new HashSet<>();
		while((c+"").compareTo("0")>0)
		{
			String d=""+c;
			char ch=d.charAt(d.length()-1);
			if(d.length()==1)
			{
				c=new BigInteger("0");
				
			}
			else
			c=new BigInteger(d.substring(0,d.length()-1));
			if(hs.contains(ch))
				continue;
			if(d.charAt(d.length()-1)=='0')
				continue;
			if(!(n.mod(new BigInteger(""+ch)).equals(new BigInteger("0"))))
				return false;
				hs.add(ch);
		}
		return  true;
	}
	
	static int cal(long n,long k)
	{
		System.out.println(n+","+k);
		if(n==k)
			return 2;
		if(n<k)
			return 1;
		if(k==1)
			return 1+cal(n, k+1);
		if(k>=32)
			return 1+cal(n/k, k);
		return 1+Math.min(cal(n/k, k),cal(n, k+1));
	}
	static Node buildTree(int i,int j,int[] arr)
	{
		if(i==j)
		{
			
			//System.out.print(arr[i]);
			return new Node(arr[i]);
		}
		int max=i;
		for(int k=i+1;k<=j;k++)
		{
			if(arr[max]<arr[k])
				max=k;
		}
		Node root=new Node(arr[max]);
		//System.out.print(arr[max]);
		if(max>i)
			root.left=buildTree(i, max-1, arr);
		else {
			root.left=null;
		}
		if(max<j)
			root.right=buildTree(max+1, j, arr);
		else {
			root.right=null;
		}
		return root;
	}
	static int height(Node root,int val)
	{
		if(root==null)
			return Integer.MAX_VALUE-32;
		if(root.val==val)
			return 0;
		if((root.left==null&&root.right==null))
			return Integer.MAX_VALUE-32;
		return Math.min(height(root.left, val), height(root.right, val))+1;
	}
	static void shuffle(int a[], int n) 
    { 
        for (int i = 0; i < n; i++) { 
  
            // getting the random index 
            int t = (int)Math.random() * a.length; 
  
            // and swapping values a random index 
            // with the current index 
            int x = a[t]; 
            a[t] = a[i]; 
            a[i] = x; 
        } 
    }
	static void sort(int[] arr )
	{
		shuffle(arr, arr.length);
		Arrays.sort(arr);
	}
	static int helper(int i,boolean flag,int n,int c,int val,int[][][] dp)
	{
		if(i<=0||i>=n+1)
		{
			c++;
			return 1;
		}
		int last=flag?1:0;
		if(dp[i][val][last]!=0)
			return dp[i][val][last];
		int ans=0;
		if(flag)
		{
			ans=helper(i+1, flag, n, c, val,dp);
			if(val>1)
			ans+=helper(i-1, !flag, n, c, val-1,dp);
		}
		else {
			ans=helper(i-1, flag, n, c, val,dp);
			if(val>1)
			ans+=helper(i+1, !flag, n, c, val-1,dp);
		}
		return dp[i][val][last]=ans;	
	}
	static boolean valid(char[] arr,int k)
	{
		int[] count=new int[26];
		for(int i=0;i<arr.length;i++)
			count[(int)arr[i]-'a']++;
		for(int i=0;i<26;i++)
			if(count[i]%k!=0)
				return false;
		return true;
	}
	
	static int compute(int c,int r)
	{
		if(r<c/2)
			r=c-r;
		int ans=1;
		for(int i=c;i>r;i--)
			ans*=i;
		int fac=fac(c-r);
		return ans/fac;
	}
	static boolean arraySortedInc(int arr[], int n)
    {
 
        // Array has one or no element
        if (n == 0 || n == 1)
            return true;
 
        for (int i = 1; i < n; i++)
 
            // Unsorted pair found
            if (arr[i - 1] > arr[i])
                return false;
 
        // No unsorted pair found
        return true;
    }
	static boolean arraySortedDec(int arr[], int n)
    {
 
        // Array has one or no element
        if (n == 0 || n == 1)
            return true;
 
        for (int i = 1; i < n; i++)
 
            // Unsorted pair found
            if (arr[i - 1] > arr[i])
                return false;
 
        // No unsorted pair found
        return true;
    }
	static int largestPower(int n, int p) {
        // Initialize result
        int x = 0;
 
        // Calculate x = n/p + n/(p^2) + n/(p^3) + ....
        while (n > 0) {
            n /= p;
            x += n;
        }
        return x;
    }
 
// Utility function to do modular exponentiation.
// It returns (x^y) % p
    static int power(int x, int y, int p) {
        int res = 1; // Initialize result
        x = x % p; // Update x if it is more than or
        // equal to p
        while (y > 0) {
            // If y is odd, multiply x with result
            if (y % 2 == 1) {
                res = (res * x) % p;
            }
 
            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }
 
// Returns n! % p
    static int modFact(int n, int p) {
        if (n >= p) {
            return 0;
        }
 
        int res = 1;
 
        // Use Sieve of Eratosthenes to find all primes
        // smaller than n
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
 
        // Consider all primes found by Sieve
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                // Find the largest power of prime 'i' that divides n
                int k = largestPower(n, i);
 
                // Multiply result with (i^k) % p
                res = (res * power(i, k, p)) % p;
            }
        }
        return res;
    }
	static boolean helper(int[][] all,int row,int[] count)
	{
//		System.out.println(new String(arr)+","+i+","+a+","+b);
		if(row==all.length)
			return true;
//		System.out.println(all[row][row]);
//		for(int i=0;i<all.length;i++)
//			System.out.println(Arrays.toString(all[i]));
//		System.out.println();
//		System.out.println();
		if(count[all[row][row]]==all[row][row])
			return helper(all, row+1, count);
		else {
			for(int i=0;i<all.length;i++)
			{
				for(int j=0;j<=i;j++)
				{
					if(all[i][j]==all[row][row])
					{
//						System.out.println(row+","+i+","+j);
						if(j>0&&all[i][j-1]==0)
						{
							all[i][j-1]=all[row][row];
							count[all[row][row]]++;
							if(helper(all, row, count))
								return true;
							else {
								all[i][j-1]=0;
								count[all[row][row]]--;
							}
						}
						if(j<i&&all[i][j+1]==0)
						{
							all[i][j+1]=all[row][row];
							count[all[row][row]]++;
							if(helper(all, row, count))
								return true;
							else {
								all[i][j+1]=0;
								count[all[row][row]]--;
							}
						}
						if(i<all.length-1&&all[i+1][j]==0)
						{
							all[i+1][j]=all[row][row];
							count[all[row][row]]++;
							if(helper(all, row, count))
								return true;
							else {
								all[i+1][j]=0;
								count[all[row][row]]--;
							}
						}
						if(i>0&&j!=i&&all[i-1][j]==0)
						{
							all[i-1][j]=all[row][row];
							count[all[row][row]]++;
							if(helper(all, row, count))
								return true;
							else {
								all[i-1][j]=0;
								count[all[row][row]]--;
							}
						}
						
					}
				}
			}
			return false;
		}
	}
	static boolean helper(int[] arr,long[] val,int i,int x,StringBuilder sb,HashSet<String> hs)
	{
		String key=Arrays.toString(val);
		if(hs.contains(key))
			return false;
		hs.add(key);
		if(i==arr.length)
		{
			long max=val[0],min=val[0];
			for(long in:val)
			{
				max=Math.max(max,in);
				min=Math.min(min,in);
				if(in==0)
					return false;
			}
//			System.out.println(min+","+max);
			if(max-min<=x)
				return true;
			return false;
		}
		for(int j=0;j<val.length;j++)
		{
			if(j>0&&val[j-1]==0)
				break;
			if(j<val.length-1&&Math.abs(val[j]+arr[i]-val[j+1])>x)
				continue;
			if(j>0&&Math.abs(val[j]+arr[i]-val[j-1])>x)
				continue;
			val[j]+=arr[i];
			if(helper(arr, val, i+1, x,sb,hs))
			{
				sb.append(j+1).append(" ");
				return true;
			}
			val[j]-=arr[i];
		}
		return false;
	}
	static boolean check(int[] arr,int diff,int k)
	{
//		System.out.println(diff);
		int st=arr[0]+diff;
		int in=Arrays.binarySearch(arr, st);
		if(in<0)
			in=-in-1;
		int c=1;
		while(in<arr.length)
		{
//			System.out.println(in);
			st=arr[in];
			in=Arrays.binarySearch(arr, st+diff);
			if(in<0)
				in=-in-1;
			c++;
		}
		if(c>=k)
			return true;
		return false;
	}
	public static void main(String[] args)throws IOException
	{
		BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
		FastReader fs=new FastReader();
		PrintWriter out=new PrintWriter(System.out);
//		int T=fs.nextInt();
		StringBuilder sb=new StringBuilder();
//		while(T-->0)
		{
			int n=fs.nextInt(),k=fs.nextInt();
			long[] arr=new long[n];
			for(int i=0;i<n;i++)
				arr[i]=fs.nextLong();
			for(int i=1;i<n;i++)
				arr[i]+=arr[i-1];
//			int[] arrows=fs.nextArray(k);
			long[] arrows=new long[k];
			for(int i=0;i<k;i++)
				arrows[i]=fs.nextLong();
			long prev=0,extra=0;
			for(long i:arrows)
			{
				int in=Arrays.binarySearch(arr, prev+i+extra);
				if(in<0)
				{
					in=-in-1;
					if(in==0)
						extra=prev+i+extra;
					else
						extra=Math.max(prev+i+extra-arr[in-1],0);
				}
				else {
					extra=0;
					in++;
				}
//				System.out.println(in);
				if(in>=n)
				{
					sb.append(n);
					prev=0;
					extra=0;
				}
				else {
					sb.append(n-in);
					if(in!=0)
					prev=arr[in-1];
					else {
						prev=0;
					}
				}
//				System.out.println(in+","+extra+","+prev);
				sb.append("\n");
			}
			
//			c=c*(c-1)/2;
//			sb.append(c);
//			sb.append("\n");
		}
		System.out.println(sb);
	 }
}