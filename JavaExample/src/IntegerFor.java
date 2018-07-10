public class IntegerFor{
    public static void main(String args[ ]){
        int [ ] a = {10, 20, 30, 40, 50};
        int s = 0;
        for ( int c : a)
            s += c; // 这里需要注意c是数组的元素，而不是相应的下标
        System.out.println("数组a的元素之和等于" + s);
        
        s = 0;
        int [ ] ca = a;
        for ( int i=0; i< ca.length; i++ ){
            int c = ca[i];
            s += c;
        } 
        System.out.println("数组a的元素之和等于" + s);
    } 
} 
