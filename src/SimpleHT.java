import java.util.Arrays;
import java.util.LinkedList;
import java.util.Hashtable;

public class SimpleHT {
// Pair class Stores the value of the key and the value in the array list

    class Pair {
        private Integer key;
        private Integer value;
        Pair() {};

//points to the currennt key and value
        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
//overwrites the value if the value exists
        public Pair setValue(int value) {
            this.value = value;
            return this;
        }


        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

    }


    private int size;
    private LinkedList<Pair>[] table;  //linked list for the hash table

    public SimpleHT(int m) {
        this.size = m;
        table = new LinkedList[size];
    }

    private boolean isEmpty(LinkedList<Pair> list) {
        return list == null;
    }// checks if there exists any element

    private int addressOfList(Integer key) {
        return Math.floorMod(key, size);
    } //returns the index in the hash Table

    public void insert(Integer key, Integer value) {

        int index = addressOfList(key);
        LinkedList <Pair> list = table[index];
        if (isEmpty(list)) //if linked list is empty, create first node
        {
            list = new LinkedList<> ();
            Pair p = new Pair(key, value);
            list.add(p);
            table[index] = list;
        } else {// if not empty and key is found it updates the value
           if (getPair(key) != null)
           {
               update(key,value);
               return;
           }  //if the key doesn't exist we add it the the end of the list
           Pair p = new Pair (key, value);
           list.add(p);
           }
        }

private void update (Integer key , Integer value)
{
    int i = addressOfList(key);
    LinkedList < Pair> l = table[i];
    if (isEmpty(l)) {
        return ;
    } else {
        Pair p = getPair(key);
        if (p != null) {
            p.value = value;
            return ;
        }
    }
    return ;
}

    private Pair getPair(Integer key) {
        if (key == null)
            return null;
        int index = addressOfList(key);
        LinkedList < Pair > list = table[index];
        if (isEmpty(list))
            return null;
        else
            for (Pair p : list)
                if (p.key.equals(key))
                    return p;
        return null;
    }


    public Integer get(Integer key) {

        if (key == null)
            return null;
        int index = addressOfList(key);
        LinkedList < Pair > list = table[index];
        if (isEmpty(list))
            return null;
        else
            for (Pair p: list)
                if (p.key.equals(key))
                 return p.value;
        return null;


    }


    public boolean remove(Integer key) {
        int index = addressOfList(key);
        LinkedList <Pair> list = table[index];
        if (isEmpty(list))
            return false;
        else {
            Pair p = getPair(key);
            if (p != null) {
                list.remove(p);
                return true;
            }
        }
        return false;
    }
}