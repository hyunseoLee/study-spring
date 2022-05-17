import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_220409 {

    static int N;
    static String[] arr;
    static boolean[] check =  new boolean[10];
    static BufferedWriter bw; 
    static List<String> result= new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        bw= new BufferedWriter(new OutputStreamWriter(System.out));

        N= Integer.parseInt(br.readLine());
        arr= new String[N];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]= st.nextToken();
        }

        for(int i=0;i<10;i++){
            check[i]=true;
            recursion(0,Integer.toString(i));
            check[i]=false;
        }

        Collections.sort(result);
        
        bw.write(result.get(result.size()-1) +"\n");
        bw.write(result.get(0)+"\n");

        bw.flush();
        bw.close();

    }
    public static void recursion(int depth, String str){
        if(depth== N){
            result.add(str);
            return;
        }

        if(arr[depth].equals("<")){
            int startNum = str.charAt(str.length()-1) - '0';
            for(int i=startNum; i<10;i++){
                if(check[i]==false){
                    check[i]=true;
                    recursion(depth+1, str+i);
                    check[i]=false;
                }
            }
        }
        else if(arr[depth].equals(">")){

            int endNum = str.charAt(str.length()-1) - '0';
            for(int i=0; i<endNum;i++){
                if(check[i]==false){
                    check[i]=true;
                    recursion(depth+1, str+i);
                    check[i]=false;
                }
            }
        }
    }
    
}
