import java.io.*;
import java.util.*;

public class Main_0407 {

    static int N;
    static boolean[] check;
    static int[] arr;
    static int[] ans; 
    static BufferedWriter bw;
    static ArrayList<String> result= new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        bw= new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){

            StringTokenizer st= new StringTokenizer(br.readLine());
            N= Integer.parseInt(st.nextToken());

            if(N==0) break;

            check = new boolean[N];
            arr = new int[N];
            ans = new int[6];
            for(int i=0;i<N;i++){
                arr[i]=  Integer.parseInt(st.nextToken());
            }

            // 배열로 넘겨보자 
           // int tmp[]= new int[6];
           // 배열을 여기서 넘길 필요없고 recursion에서 return 전에 출력하면된다.. 

           // String으로 넘겨주자

            recursion(0,0);

            //Collections.sort(result);
            bw.write("\n");
        }

        

        bw.flush();
        bw.close();
      

    }
    private static void recursion(int idx, int cnt) throws IOException{ 
        if(cnt==6){
            for(int i=0;i<6;i++){
                bw.write(ans[i] +" "); 
            }
            bw.write("\n");
            return;
        }

        for(int i=idx;i<N;i++){
            if(check[i]==false){
                check[i]=true;
                //1. arrayList에 해당 값을 추가해서 넘기는 방법  v.add
                //2. 배열로 넘겨주자. i값을 받고 되돌려줄 필요는 없을듯. 다시 i 넣으면 되니까. 
                //3. String으로 넘겨주자.. 

                //다, 넘길필요없고, 그냥 저장하면 된다......
                ans[cnt] = arr[i];
                recursion(i, cnt+1 );
                check[i]=false; 
            }
        }
    }
}
