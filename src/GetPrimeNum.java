import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class GetPrimeNum {
    private int max;
    private List<Integer> table = new ArrayList<>();
    private Logger logger = Logger.getLogger("GetPrimeNumLogger");

    /**默认存储10000以内的素数*/
    public GetPrimeNum(){
        max = 10000;
        byte[] mark = new byte[max+1];
        /**这里使用的是普通筛法*/
        for(int i=2;i<=max/2;i++){
            /*不能在这加入table，这里只遍历了一半
            if(mark[i]==0){
                this.table.add(i);
            }
             */
            for(int j=2;j<=i&&j*i<=max;j++){
                mark[j*i] = 1;
            }
        }
        for(int i=2;i<=max;i++){
            if(mark[i]==0){
                this.table.add(i);
            }
        }
    }

    /**指定质数表的最大值的构造函数*/
    public GetPrimeNum(int max){
        this.max = max;
        byte[] mark = new byte[max+1];
        /**这里使用欧拉筛法*/
        for(int i=2;i<=max;i++){
            if(mark[i]==0){
                table.add(i);
            }
            for(int j=0;j<table.size()&&table.get(j)*i<=max;j++){
                mark[table.get(j)*i] = 1;
                if(i%table.get(j)==0){
                    break;
                }
            }
        }
    }

    /**获得所有小于num的质数*/
    public List<Integer> get(int num) throws Exception{
        List<Integer> ans = new ArrayList<>();
        if(num>max){
            logger.warning("查询数据超出上限，仅返回所有小于 " + max + " 的质数，请创建一个max值更大的GetPrimeNum对象来获得剩余质数");
        }
        if(num<2){
            logger.warning("查询数据小于2，返回空列表");
        }
        //开始想使用二分法找位置，但是num不一定是质数，即不一定存在于table中
        //其实还是可以用二分法，比如T[mid]<=num,T[mid+1]>num
        for(int i=0;i<table.size();i++){
            if(table.get(i)<=num){
                ans.add(table.get(i));
            }
            else{
                break;
            }
        }
        return ans;
    }

    /**获得所有属于 [start，end] 的质数*/
    public List<Integer> get(int start, int end) throws Exception{
        List<Integer> ans = new ArrayList<>();
        if(start>=end){
            logger.warning("上限小于下限");
            throw new Exception("上限小于下限");
        }
        else if(end>max){
            logger.warning("查询数据超出上限，仅返回所有大于 " + start + " 小于 " + max + " 的质数，请创建一个max值更大的GetPrimeNum对象来获得剩余质数");
        }
        //开始想使用二分法找位置，但是num不一定是质数，即不一定存在于table中
        //其实还是可以用二分法，比如T[mid]<=num,T[mid+1]>num
        //懒得搞，直接顺序吧
        for(int i=0;i<table.size();i++){
            if(table.get(i)>=start&&table.get(i)<=end){
                ans.add(table.get(i));
            }
            else if(table.get(i)>end){
                break;
            }
        }
        return ans;
    }

    public int getMax() {
        return max;
    }

    public int getNums() {
        return table.size();
    }
}