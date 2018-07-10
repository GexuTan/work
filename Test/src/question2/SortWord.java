package question2;

import java.util.Comparator;

class SortWord implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        String sa = (String) o1;
        String sb =(String) o2;
        return sa.compareTo(sb);
    }
}

