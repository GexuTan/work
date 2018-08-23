enum Season{
    春季, 夏季, 秋季, 冬季 
} 

public class EnumFor{
    public static void main(String args[ ]){
        for ( Season c : Season.values( ))
            System.out.print(c + ", ");
        System.out.println( );

        Season [ ] ca = Season.values( );
        for ( int i=0; i< ca.length; i++ ){
            Season c = ca[i];
            System.out.print(c + ", ");
        } 
    } 
} 
