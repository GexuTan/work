
import java.util.*;
class DealCardDemo {
    public static void main(String args[]) {
        int numHands = 4;
        int cardsPerHand = 12;
       // 生成一副牌（含52张牌）
        String[] suit = {"♠", "♣", "♥", "♦"};
        String[] rank = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        List deck = new ArrayList();
        for (int i=0; i<suit.length; i++)
            for (int j=0; j<rank.length; j++)
                deck.add(suit[i]+rank[j]);

        Collections.shuffle(deck); //随机改变deck中元素的排列次序，即洗牌。

        for (int i=0; i<numHands; i++){
        //生成一手牌,并对牌按花色排序后输出。
            List p=dealCard(deck, cardsPerHand);
            Collections.sort(p);
            System.out.println(p); 
        }    
    }
    public static List dealCard(List deck, int n) {
        int deckSize = deck.size();
        List handView = deck.subList(deckSize-n, deckSize); //从deck中截取一个子链表
        List hand = new ArrayList(handView);  //利用该子链表创建一个链表，作为本方法返回值。
        handView.clear(); //将子链表清空。
        return hand;
    }
}
