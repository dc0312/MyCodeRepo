package Programs.src.hackerRank;

public class FindMissingNumber {

    public static int findMissingNumber(int [] arr,int size){

        int x1=arr[0];
        int x2=1;

        for(int i=1;i<size;i++){
            x1 = x1 ^ arr[i];
        }

        for(int i=2;i<=size+1;i++){
            x2 =  x2 ^ i;
        }

        return x1 ^ x2;

    }

    public static void main(String[] args) {

        int [] arr = {1,2,4,6,5,8,9,3,10};

        System.out.println(findMissingNumber(arr,arr.length));
    }
}
