class Solution {
    //µÝ¹é
    /*
    public boolean lemonadeChange(int[] bills) {
        int[] changes = new int[2];
        int len = bills.length;
        for(int i=0;i<len;i++) {
            if(bills[i]==5) {
                changes[0] ++;
            } else if(bills[i]==10) {
                changes[1] ++ ;
            }
            if(!isCanChange(changes,bills[i]-5)) return false;
        }
        return true;
    }
    public boolean isCanChange(int[] changes,int money) {
        if(money==0) return true;
        if(changes[0]==0&&changes[1]==0) return false;
        if(money>=10&&changes[1]>0) {
            changes[1]--;
            return isCanChange(changes,money - 10);
        } else if(money>=5&&changes[0]>0) {
            changes[0]--;
            return isCanChange(changes,money - 5);
        }
        return false;
    }
    */
     public boolean lemonadeChange(int[] bills) {
         int fiveNum=0,tenNum=0;
         for(int temp:bills) {
             if(temp==5) {
                 fiveNum++;
             }else if(temp==10) {
                 //ÊÇ·ñ¿ÉÒÔÕÒÁã
                 if(fiveNum==0) return false;
                 fiveNum--;
                 tenNum++;
             }else {
                 if(tenNum>0&&fiveNum>0) {
                     fiveNum--;
                     tenNum--;
                     continue;
                 }
                 if(fiveNum>=3) {
                     fiveNum = fiveNum - 3;
                     continue;
                 }
                 return false;
             }
         }
         return true;
     }   
}