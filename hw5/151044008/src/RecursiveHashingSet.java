import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * set interfaceini implement ederek ve collisionu chainingle cözen recursive bir set olusturur
 * @param <K>
 */
public class RecursiveHashingSet<K> implements Set<K> {
    private entry<K>[] set;
    private int  startCapacity=20;
    private int numKeys;
    private int numDeletes;
    private final entry<K> DELETED=new entry<>(null);

    private class entry<K>{
        private K key;
        private  entry<K>[] table;

        public entry(){
            key=null;
            table=null;

        }
        public entry (K key){
            this.key=key;
            table=null;
        }
        public K getKey() {
            return key;
        }

        public entry<K>[] getTable() {
            return table;
        }

    }
    public RecursiveHashingSet(){

        set= new entry[startCapacity];
        for(int i=0;i<startCapacity;++i){
            set[i]=new entry<K>();
        }
        numKeys=0;
        numDeletes=0;
    }

    @Override
    public int size() {
        return numKeys;
    }

    @Override
    public boolean isEmpty() {
        if(numKeys==0 && numDeletes==0){
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /**
     * verilen elamani dogru yere ekler, elaman varsa ekleme islemi basarisiz olur ve false return eder.
     * @param o
     * @return
     */
    @Override
    public boolean add(Object o) {
        if(add(o,set)==true){
            return true;
        }
        return false;
    }

    /**
     * recursive yardimci add metodu
     * @param O
     * @param set_p
     * @return
     */
    private boolean add (Object O , entry<K>[] set_p  ){
        int index=O.hashCode()%set.length;
        if(index<0){
            index=index+set.length;
        }
        if(set_p[index].key==null){

            set_p[index].key= (K)O;
            numKeys++;
            System.out.println("Eklenen deger: "+ (K)O);
            System.out.println("Array'in size'i: "+set_p.length);
            return true;
        }
        else{
            if(set_p[index].table==null){

                set_p[index].table= new  entry[startCapacity/2];
                for(int i=0;i<set_p[index].table.length;++i){
                    set_p[index].table[i]=new entry<K>();
                }

                startCapacity=startCapacity/2;
                int tempIndex=O.hashCode()%startCapacity;
                if(tempIndex<0) {
                    tempIndex = tempIndex + set.length;
                }
                    set_p[index].table[tempIndex].key=(K)O;
                    System.out.println("Yeni tablo olusturuldu. Eklenen deger: "+ (K)O);
                    System.out.println("Yeni Array'in Size'i: "+set_p[index].table.length);
                    numKeys++;
                    return true;
            }
            else{
                add(O,set_p[index].table);
            }

        }

        return false;

    }

    /**
     * verilen eleman silinirse true, silme islemi basarisiz olursa false return eder.
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) {
        if(remove(o,set)==true){
            return true;
        }
        return false;
    }

    /**
     * yardımcı recursive remove metodu
     * @param O
     * @param set_p
     * @return
     */
    private boolean remove(Object O , entry<K>[] set_p){
        int index=O.hashCode()%set.length;
        if(index<0){
            index=index+set.length;
        }
        if(set_p[index].key==(K)O){
            set_p[index]=DELETED;
            numDeletes++;
            return true;
        }


        return false;
    }
    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }
}
