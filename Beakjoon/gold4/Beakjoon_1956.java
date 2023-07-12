package gold4;
import java.io.*;
import java.util.*;
/*
날짜 2023.07.10
*/
public class Beakjoon_1956 {
	static final int INF=1000000000;
    static int[][]result;
    public static void floyd(int n){
    	for(int k=1 ; k<=n ; k++){
        	for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                	result[i][j]=Math.min(result[i][j], result[i][k]+result[k][j]);
                }
            }
        }
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
        int m=sc.nextInt();
        int same=INF;
        
        result=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
        	for(int j=1;j<=n;j++){
        		if(i!=j)
        			result[i][j]=INF;
            }
        }
   
        
        for(int i=0;i<m;i++){
        	int st=sc.nextInt();
            int en=sc.nextInt();
            int w=sc.nextInt();
            if(w<result[st][en]){
            	result[st][en]=w;
            }
            if(st==en) {
            	same=w;
            }
        }

       
        floyd(n);
        

        int min=INF;
        for(int i=1;i<=n;i++) {
        	for(int j=1;j<=n;j++) {
        		
        		if(result[i][j]!=INF && result[j][i]!=INF && i!=j) {
        			min=Math.min(min,result[i][j]+result[j][i]);
        		}
        	}
        }
        if(min==INF)
        	min=-1;
        System.out.printf("%d\n", min);
	}

}
