import java.util.Iterator;
import java.util.Vector;

public class VectorFor{
    public static void main(String args[ ]){
        Vector<String> a = new Vector<String>( );
        a.add( "a" );
        a.add( "b" );
        a.add("c");
        for ( String c : a)
            System.out.print(c + ", ");
        System.out.println( );

        for ( Iterator<String> i=a.iterator( ); i.hasNext( ); ){
            String c = i.next( );
            System.out.print(c + ", ");
        } 
    } 
} 
