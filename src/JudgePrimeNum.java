import java.net.InterfaceAddress;

class JudgePrimeNum {
    /**可以指定判断的方法*/
    public static boolean isPrimeNum(int num){
        if(num<2){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                System.out.println(i);
                return false;
            }
        }
        return true;
    }
}

