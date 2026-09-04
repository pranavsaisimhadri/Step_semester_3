import java.util.*;
class merge_arrays{
    static int[] mergeSortedArrays(int[] arr1,int[] arr2){
        int[] result=new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(i<arr1.length&&j<arr2.length){
            if(arr1[i]<arr2[j])
                result[k++]=arr1[i++];
            else
                result[k++]=arr2[j++];
        }
        while(i<arr1.length)
            result[k++]=arr1[i++];
        while(j<arr2.length)
            result[k++]=arr2[j++];
        return result;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr1=new int[n];
        for(int i=0;i<n;i++)
            arr1[i]=sc.nextInt();
        int m=sc.nextInt();
        int[] arr2=new int[m];
        for(int i=0;i<m;i++)
            arr2[i]=sc.nextInt();
        System.out.println(Arrays.toString(mergeSortedArrays(arr1,arr2)));
    }
}