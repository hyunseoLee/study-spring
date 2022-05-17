import java.util.*;

public class HashMap_220509 {
    public static void main(String[] args){
        HashMap map= new HashMap();
        map.put("kim", 100);
        map.put("lee",100);
        map.put("park",80);
        map.put("choi",90);

        //1. keySet() 이나 values 를 이용
        Set set = map.keySet();
        System.out.println("이름 : " + set);
        
        Collection values = map.values();
        Iterator it = values.iterator();

        while(it.hasNext()){
            Integer i = (Integer)it.next(); 
            System.out.println("점수1 : " +  i);
            System.out.println("점수2: " +  i.intValue()); 
        }
        //2. map.entrySet()을 이용해서 Map.Entry 의 getKey, getValue
        set = map.entrySet();
        it= set.iterator(); 

        while(it.hasNext()){
            Map.Entry e= (Map.Entry)it.next();
            System.out.println( "이름: " + e.getKey() + "/ 점수 : "+e.getValue()); 
            
        }
        
    }
    
}
