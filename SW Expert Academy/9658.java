class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <=T; test_case++)
		{
			String s= sc.next();//범위가 10^100000여서 문자열로 받아야함.
			int size=s.length()-1;
            int a;
            int b;
            int c;
            a=s.charAt(0)-'0';
            b=s.charAt(1)-'0';
            c=s.charAt(2)-'0';
            //System.out.printf("%d, %d, %d, %d\n",size,a,b,c);
            if(c>=5){//반올림 진행
                b++;
                if(b==10){
                    b=0;
                    a++;
				}
            }
            if(a==10){
               a=1;
               b=0;
               size++;
            }
            System.out.printf("#%d %d.%d*10^%d\n",test_case,a,b,size);
		}
	}
}
