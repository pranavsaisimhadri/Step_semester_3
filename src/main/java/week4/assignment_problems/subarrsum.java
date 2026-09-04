import java.util.*;
class subarrsum{
    static int subarraySum(int[] nums,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0,count=0;
        for(int x:nums){
            sum+=x;
            count+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++) nums[i]=sc.nextInt();
        int k=sc.nextInt();
        System.out.println(subarraySum(nums,k));
    }
}