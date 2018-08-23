public class Add <T>{
    public String sum(T a1, T a2, T a3){
        return(a1.toString( ) + a2.toString( ) + a3.toString( ));
    } // 方法sum结束

    public static void main(String args[ ]){
        Add<Integer> b = new Add<Integer>( );
        Integer a1 = new Integer(1);
        Integer a2 = new Integer(2);
        Integer a3 = new Integer(3);
        System.out.println( b.sum(a1, a2, a3) );
    } // 方法main结束
} // 类Add结束
