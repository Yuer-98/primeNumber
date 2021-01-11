import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        int max = 100000000;
        byte[] mark = new byte[max+1];
        int num = 0;
        List<Integer> table = new ArrayList<>();

        /**埃拉托色尼筛法*/
        //这不能只到sqrt(max)，至少到max/2
        for(int i=2;i<=max/2;i++){
            //这不能跳过合数
            for(int j=2;j<=i&&j*i<=max;j++){
                mark[j*i] = 1;
            }
        }
        for(int i=2;i<=max;i++){
            if(mark[i]==0){
                num++;
                //System.out.print(i+" ");
            }
        }
        System.out.println(num);

        /**欧拉筛法*/
//        for(int i=2;i<=max;i++){
//            if(mark[i]==0){
//                table.add(i);
//                num++;
//            }
//            for(int j=0;j<table.size()&&table.get(j)*i<=max;j++){
//                mark[table.get(j)*i] = 1;
//                if(i%table.get(j)==0){
//                    break;
//                }
//            }
//        }
//        System.out.println(num);

        /**不用筛法*/
//        int num = 0;
//        for(int i=2;i<=max;i++){
//            if(isPrimeNum(i)){
//                num++;
//            }
//        }
//        System.out.println(num);
    }

    public static boolean isPrimeNum(int num){
        if(num<2){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
