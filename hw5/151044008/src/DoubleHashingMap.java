import java.util.*;

/**
 * Map interface'ini implement ederek double hashing kullanan map sinifini implement eder.
 * @param <K>
 * @param <V>
 */
public class DoubleHashingMap<K,V> implements Map<K,V>{
    private entry<K,V>[] map;
    private static final int startCapacity=5;
    private double loadTreshold=0.75;
    private int numKeys;
    private int numDeletes;
    private final entry<K,V> DELETED=new entry<>(null,null);

    /**
     * inner class
     * @param <K>
     * @param <V>
     */
    private class entry<K,V>{
        private K key;
        private V value;

        public entry(K key, V value){
            this.key=key;
            this.value=value;
        }
        public K getKey(){
            return key;

        }
        public V getValue(){
            return value;
        }
        public V setValue(V val){
            V oldVal=value;
            value=val;
            return oldVal;
        }
    }

    public DoubleHashingMap()    {
        map= new entry[startCapacity];
        numKeys=0;
        numDeletes=0;
    }
    @Override
    public String toString(){

        StringBuilder sb= new StringBuilder();
        for(int i=0; i<map.length;++i){
            if(map[i]==null){
                sb.append("null \n");
            }
            else if(map[i]==DELETED){
                sb.append("DELETED \n");
            }
            else {
                sb.append(map[i].key + " " + map[i].value);
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    /**
     * islem yapilacak eleman icin dogru indexi bulmayı saglar
     * @param key
     * @return
     */
    private int find(Object key){
        int index= key.hashCode()% map.length;
        if(index<0){
            index+=map.length;
        }
        int count = 1;
        while((map[index]!=null) && (!key.equals(map[index].key))){

            index= (index + count * secondHash(key)) % map.length;
            count++;
        }
        return index;
    }

    /**
     * double Hashing icin
     * @param key
     * @return
     */
    private int secondHash(Object key){
        int index=11 - (key.hashCode() % 11);
        return index;
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
        return false;
    }

    @Override
    public boolean containsKey(Object o) {
        return false;
    }

    @Override
    public boolean containsValue(Object o) {
        return false;
    }

    /**
     * aranan elaman var ise onu yoksa null return eder
     * @param o
     * @return
     */
    @Override
    public V get(Object o) {
        int index=find(o);
        if(map[index]!=null){
            return map[index].value;
        }
        else
            return null;
    }

    /**
     * double hash kullanarak eleman ekleme islemini yapar
     * @param k
     * @param v
     * @return
     */
    @Override
    public V put(K k, V v) {
       int index=find(k);
       if(map[index]==null){
           map[index]=new entry<K,V>(k,v);
           numKeys++;
           double loadFactor=(double)(numKeys+numDeletes)/map.length;

           if(loadFactor>loadTreshold){

               rehash();
           }
           return null;
       }
       V oldVal=map[index].value;
       map[index].value=v;
       return oldVal;
    }

    /**
     * load factor'e gore arrayi rehash eder
     */
    private void rehash(){
        entry<K,V>[] oldMap=map;
        map=new entry[2*startCapacity+1];
        numKeys=0;
        numDeletes=0;

        for(int i=0;i<oldMap.length;++i){
            if((oldMap[i]!=null)&& (oldMap[i]!=DELETED)){
                this.put(oldMap[i].key,oldMap[i].value);
            }
        }
    }

    /**
     * Verilen elamani arrayin icinde varsa siler ve return eder yoksa null return eder
     * @param o
     * @return
     */
    @Override
    public V remove(Object o) {
        int index=find(o);
        if(map[index]==null){
            return null;
        }
        else if(map[index].key==o){
            V oldVal=map[index].value;
            map[index]=DELETED;
            numKeys--;
            numDeletes++;
            return oldVal;
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
