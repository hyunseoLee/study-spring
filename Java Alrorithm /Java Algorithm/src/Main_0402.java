import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    22.04.02 
    [BOJ] 부등호 
    - 백트래킹, 브루트포스 
*/
public class Main_0402 {

    static BufferedWriter bw;
    static int N;
    static boolean[] check;
    static String[] arr;
    static int max = 0 ;
    static int min = 999999999; 

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N= Integer.parseInt(br.readLine());
        check= new boolean[10];
        arr= new String[N];

        StringTokenizer st= new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i]= st.nextToken();
        }
        /* 
            arr[0]= < 
            arr[1]= >  
        */
        for(int i=0;i<10;i++){
            check[i]=true;
            ArrayList<Integer> v = new ArrayList<>(); 
            v.add(i);
            recursion(0,v);
            check[i]=false; // 이거 깔끔하게 가고싶은데.
        }

        
        bw.write(max+"\n");
        bw.write(min+"\n");

        bw.flush();
        bw.close();


    }
    
    /* cnt: 현재 깊이
       now : 현재 숫자  (배열을 보내는게 나을까?)
    */
    public static void recursion(int cnt, ArrayList<Integer> v) throws IOException{
        if(cnt==N){// 확인
            //bw.write("히히.");
            // v값을 int형으로 바꾸기.
            String result="";
            for(int i=0;i<=N;i++){
                result+= Integer.toString(v.get(i));
            }
            bw.write(result +"\n");
            int now= Integer.parseInt(result);
            

            // 결과값 now 를 최솟값, 최댓값 비교한다. 

            min= Math.min(min, now);
            max= Math.max(max, now);
            return;
        }

        //1. 부등호가 > 인 경우: 그 다음 숫자가 지금숫자보다 작아야 한다. 
        //if(arr[cnt]==">"){
        if(arr[cnt].equals(">")){

            int end_num = v.get(cnt);
            for(int i=0;i<end_num;i++){
                if(check[i]==false){
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp= v;
                    tmp.add(i);
                    check[i]=true;
                    recursion(cnt+1,tmp);
                    check[i]=false;
                }
            }
        }
        //2. 부등호가 < 인 경우: 그 다음 숫자가 지금숫자보다 커야 한다. 
        //else if(arr[cnt]== "<"){
        else if (arr[cnt].equals("<")){
            int start_num = v.get(cnt);
            for(int i= start_num+1;i<10;i++){
                if(check[i]==false){
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp= v;
                    tmp.add(i);
                    check[i]=true;
                    bw.write(cnt + " : " + tmp.get(cnt) +" "+ tmp.get(cnt+1) +"\n" );
                    recursion(cnt+1, tmp);
                    check[i]=false;
                
                }
            }
        }

    }
}
