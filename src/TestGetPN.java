import java.util.List;

public class TestGetPN {
    public static void main(String[] args) throws Exception {
        GetPrimeNum getPrimeNum = new GetPrimeNum(10000000);
        System.out.println("质数表上限" + getPrimeNum.getMax());
        System.out.println("一共有" + getPrimeNum.getNums());

        List<Integer> pNums = getPrimeNum.get(10000,10025);
        System.out.println(pNums);
        System.out.println(JudgePrimeNum.isPrimeNum(10023));
    }
}