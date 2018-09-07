public class mainTestForDHM {
    public void TestMap(){

         DoubleHashingMap<String,String> map=new DoubleHashingMap();
         map.put("bilgehan","kargin");
         map.put("onur","polattimur");
         map.put("firat","kizilirmak");
         map.put("hizir","bayram");
         map.remove("hizir","bayram");
         map.remove("ali","oz");
        map.put("hizir","bayram");
        System.out.println(map);
        System.out.println("mapSize:"+ map.size());

    }
}
