package com.Quartz;

import com.sweng.exer3.Person;
import org.omg.CORBA.INTERNAL;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/3/2214:57
 */
public class Test {


    public static void main(String[] args) throws UnsupportedEncodingException, URISyntaxException {


        String headerName = "admin,adfasdf";
        String headerPassword = "$1$izNHHGm$";
        String authString = headerName + ":" + headerPassword;

        byte[] encode = Base64.getEncoder().encode(authString.getBytes("utf-8"));
        String encodeAuthor = new String(encode);

        System.out.println("encode:"+encodeAuthor);

        String xpp = "171.17.229.217/flv?app=huiju&stream=hjanhui_1_900";
        String xoo = "cctv1_1_900";


        Person p1 = new Person();
        Person p2 = new Person();

        p1.setName("p1");

        System.out.println("NULL"+p2.getName()+p1.getName().equals(p2.getName()));


        String s1 = xpp.replaceAll("&", "*");
        System.out.println(s1);

        if(xoo.contains(xpp))
            System.out.println("yes");

        ArrayList<String> result = new ArrayList<>();

        ArrayList<String> strings1 = new ArrayList<>();


        ArrayList<String> strings2 = new ArrayList<>();
        strings2.add("2");

        result.addAll(strings1);
        result.addAll(strings2);
        for(String x:result){
            System.out.println(x);
        }

        StringBuilder errorMessage = new StringBuilder();
        System.out.println(errorMessage.toString()==null?"yes":"NP");

        HashMap<String, String> resultMap = new HashMap<>();
        resultMap.put("1","10");

        String s2 = resultMap.get("2");
        System.out.println(s2);


        System.out.println(resultMap.get("1"));

        String x = "";
        System.out.println("1"+x+"2");
        String x222 = "190.12.34";
        String x111 = "190.12.34";

        System.out.println(x222.contains(x111));

        HashMap<Integer, List<Person>> integerListHashMap = new HashMap<>();
        ArrayList<Person> integers = new ArrayList<>();
        Person person = new Person();
        Person person2 = new Person();
        person.setName("初始值");
        person2.setName("加入只");
        integers.add(person);
        integerListHashMap.put(1, integers);

        List<Person> integerList = integerListHashMap.get(1);
        integerList.add(person2);


        integerListHashMap.put(1,integerList);

        List<Person> integerList2 = integerListHashMap.get(1);
        for(Person s : integerList2) {
            System.out.println("result:" + s.getName());
        }

        List<String> strings = new ArrayList<>();
        strings.add("1");



        int xxxx = 1025;
        int i1 = (xxxx + 1) % 1024;
        System.out.println(i1);

        List<String> list = Arrays.asList("1", "2", "3");
        for(int i = list.size()-1;i>=0;i--){
            System.out.println(list.get(i));
        }

        String sxx = "Px";
        String[] ps = sxx.split("P");
        try {
            System.out.println(Integer.parseInt(ps[1]));
        }catch (Exception e){
            System.out.println("err");
        }

        String tes = "10.55.32.45/flv?app=huiju&amp;stream=hjtiyuip1_1_900,origins:10.55.32.45/flv?app=huiju&amp;stream=hjtiyuip1_1_900";

        String url = "%E4%BD%A0%E5%A5%BD%20javascript";
        String url2 = "pull name=P12 schema=http live auto=1 push=1 drm=clear group=hjanhui_1 origins=10.55.32.45/flv?app=huiju&stream=hjanhui_1_900,172.17.230.118/flv?app=huiju&stream=hjanhui_1_900 static";
        String hello_world = URLEncoder.encode(url2, "UTF-8").replace("+", "%20");
        String hello_world2 = URLEncoder.encode(url2, "UTF-8");

        String tesRE = URLDecoder.decode(tes,"UTF-8");


        System.out.println("result:"+hello_world);
        System.out.println("result2:"+hello_world2);

        System.out.println("tesRE:"+tesRE);

        URI uri = new URI(hello_world);
        System.out.println("uri===:"+uri);

        String url3 = "Hello World ds 大侠们";

        String decodeUrl = URLDecoder.decode(hello_world, "UTF-8");

        System.out.println(decodeUrl);

        String cron = getCron(new Date());

        HashMap<Integer,Integer> testKe = null;




        System.out.println(cron);
        Random random = new Random();
        int i = random.nextInt(10000);
        System.out.println(i);


    }

    public static String getCron(Date date) {
        String dateFormat = "ss mm HH dd MM ? yyyy";

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }
}
