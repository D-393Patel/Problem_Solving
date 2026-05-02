class Solution {
    public boolean lemonadeChange(int[] bills) {
    if(bills.length==0) return false;
    int five=0,ten=0;
    for(int i=0;i<bills.length;i++){
    //five rupee customer
    if(bills[i]==5)
    five+=1;
    else if(bills[i]==10){
    if(five>0){
    five-=1;
    ten+=1;
    }
    else
    return false;
    }
    else{
        if(ten>0 && five>0){
            ten-=1;
            five-=1;
        }
        else if(five>=3){
            five-=3;
        }
        else{
            return false;
        }
    }
    
    } 
    return true;
    }
}