interface Interface <T extends Number>{
    public int sum(T a1, T a2, T a3);
} // 接口Interface结束

public class AddInterface  <T extends Number> implements Interface <T>{
    public int sum(T a1, T a2, T a3){
        int b1 = a1.intValue( );
        int b2 = a2.intValue( );
        int b3 = a3.intValue( );
        return( b1 + b2 + b3 );
    } // 方法sum结束

    public static void main(String args[ ]){
        AddInterface<Integer> b = new AddInterface<Integer>( );
        Integer a1 = new Integer(1);
        Integer a2 = new Integer(2);
        Integer a3 = new Integer(3);
        System.out.println( b.sum(a1, a2, a3));
    } // 方法main结束
} // 类AddInterface结束
