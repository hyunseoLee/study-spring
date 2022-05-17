import java.io.*;

public class Main_DP_220503 {
    static BufferedWriter bw;
    static int N; 
    static int[] dp; 
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        bw= new BufferedWriter(new OutputStreamWriter(System.out));

        N= Integer.parseInt(br.readLine());

        dp= new int[N+1]; 
        dp[0]= dp[1]=0;


        for(int i=2; i<=N;i++){
            dp[i]= dp[i-1]+1;

            if(i%3==0) dp[i]= Math.min( dp[i], dp[i/3]+1);

            if(i%2==0) dp[i]= Math.min( dp[i], dp[i/2]+1); 
        }
        
        bw.write(dp[N] +"\n"); 
        
        // bw.write(solve(N)+"\n"); 

        bw.flush();
        bw.close();
    }

    /* Top-Down */
    public static int solve(int N){
        if(N==1) return 0; 
        if(dp[N]>0) return dp[N]; 

        dp[N]= solve(N-1)+1; 

        if(N%3==0) dp[N]= Math.min( dp[N], dp[N/3]+1);
        if(N%2==0) dp[N]= Math.min( dp[N], dp[N/2]+1); 

        return dp[N];
    }
    
}


/*

/ */