class NumArray {
    //logic here is simply prefix sum which I know
    //int n=nums.length;
    // int prefix[]=new int[n];
    // prefix[0]=nums[0];
    // for(int i=1;i<nums;i++){
    // prefix[i]=nums[i]+prefix[i-1];
    // } but we simply want to return the outputs query 
    //using logic 
    //sum between queries of range[x,y]
    //subarraySum(i,j)=prefix[j+1]-prefix[i]
    //But I dont't understand what is the actual format or essence of this kind of input 
    //Strictly from interview perspective if my fails.
    private int prefix[];
    public NumArray(int[] nums) {
    int n=nums.length;
    this.prefix=new int[n+1];
    prefix[0]=0;
    for(int i=0;i<n;i++){
    prefix[i+1]=nums[i]+prefix[i];
    }
    for(int i=0;i<n;i++)
    System.out.print(prefix[i]);
    }
    public int sumRange(int left, int right) {
    return prefix[right+1]-prefix[left];
    }
    }

