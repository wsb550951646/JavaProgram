package com.sweng.string;

import org.junit.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/2315:24
 */

/*


 */
public class TestStringExer {

    /*
       将jDK 全部变成大写，并且截取DK输出

     */

    @Test
    public void testString(){

        String test = new String();
        System.out.println(test.valueOf(new Integer("1")));
        char[] data = {1,2,3,4,5,6};
        System.out.println("字符数组已经复制，不会影响"+test.valueOf(data));
        System.out.println("字符数组已经复制，不会影响"+test.valueOf(data, 0, 3));

       // char c = test.charAt(1);
       // System.out.println("charAt方法P:"+c);

        System.out.println("----------");

        String str1 = new String("123456");
        String str2 = new String("1234567");
        System.out.println("compareTo:"+str1.compareTo(str2));

        String str3 = new String("abcd");
        String str4 = new String("abcde");
        System.out.println("compareIgnoreCase"+str3.compareToIgnoreCase(str4));

        String index = new String("aaabbbccc");
        System.out.println(index.indexOf("bbb"));
        System.out.println(index.indexOf('a'));
        System.out.println(index.indexOf("ccc", 3));
        System.out.println(index.indexOf('c', 3));

        //lastIndexof 找到最后出现的字符
        String index2 = new String("aaabbbccc");
        System.out.println("lastIndexof:"+index2.lastIndexOf('a', 1)); //2 ???




    }

    @Test
    public void test00(){

        StringBuilder sb = new StringBuilder();
        if(sb==null)
            System.out.println("YES");
        String s = sb.toString();
        if(s.isEmpty())
            System.out.println("YES");
        if(s == null)
            System.out.println("NUll");
        System.out.println(s);
        System.out.println(sb.length());
       // String s1 = sb.substring(0, sb.length() - 1);



    }


   @Test
    public void test1(){

       String name = "jdk";

       String upperCase = name.toUpperCase();

       String substring = upperCase.substring(1);

       System.out.println(substring);
   }

   /*
        将test 字符串变成 tset
    */
   @Test
    public void test2(){

       String name = "test";

       StringBuffer rever = new StringBuffer(name).reverse();

       name = rever.toString();

       System.out.println(name);

   }

   /*
    String s = "113@ ere qqq yyui" 输出113 ere qqq yyui子串
    */
   @Test
    public void test3(){
       String s = "113@ ere qqq yyui";


       //replace 是目标字符 替换成结果字母  而replacceAll 是将正则表达式 所匹配的替换成结果字母
       String split3 = s.replace("@", "");


       String[] ss = split3.split( " ");

       for (int i = 0; i < ss.length ; i++) {

           System.out.println(ss[i]);
       }

   }

   /*
        将下面文本各个单词反转  To Be Or Not To Be

        oT eB rO toN oT eB

        //  result+=..  result 后面加上.. 相当于append
    */
   @Test
    public void  test4(){

       String s = "To Be Or Not To Be";

       String result = "";

       String[] ss = s.split(" ");

       for (int i = 0; i < ss.length ; i++) {

           result += new StringBuffer(ss[i]).reverse();

           if(i!=ss.length-1)
               result+=" ";
           else
               result+=".";
       }
       System.out.println(result);


   }

   /*
    String s=" name=zhangsan age=18 classNo=0987" 拆分成zhangsan 18 0987


    其中 subString(index,end); 俩个参数的范围   [index,end)  半包半闭

    所以 subString(0,s.length); 是s的原来一直字符
    */
   @Test
    public void test5(){

       String s = "name=zhangsan age=18 classNo=0987";

       String[] ss = s.split(" ");

       String result = "";

       for (int i = 0; i <ss.length ; i++) {

           result += ss[i].split("=")[1]+"-";
           //System.out.println();


       }
       System.out.println(result.substring(0, result.length()-1));

       String ss1 ="123";
       System.out.println(ss1.substring(0, 1));


   }

    /**
     * 使用String.format("%s://",name) 将name替换到%s的位置  %s:表示的是字符串
     */
   @Test
   public void test6_1() {


       String uriWithoutSchema = ":@_mnt_data_remote_test-oss/local/bj-hsy-vod/y1khjwzz?/target/hls/2019/03/04/104_c4acf437e7024ea7b5b84b13c5576449_10_t_1280x720.m3u8/IMG_9417 - 副本.ts";
       int endPos1 = uriWithoutSchema.lastIndexOf("?");
       int endPos2 = uriWithoutSchema.lastIndexOf("/");

       if (endPos1 != -1&&(endPos1>endPos2)) {
           System.out.println(uriWithoutSchema.substring(uriWithoutSchema.indexOf("/"), endPos1));
       } else {
           System.out.println(uriWithoutSchema.substring(uriWithoutSchema.indexOf("/")));

       }
   }
   @Test
   public void test6_2(){


       String uriWithoutSchema = ":@_mnt_data_remote_test-oss/local/bj-hsy-vod/y1khjwzz?/target/hls/2019/03/04/104_c4acf437e7024ea7b5b84b13c5576449_10_t_1280x720.m3u8/IMG_9417 - 副本.ts";
       int endPos = uriWithoutSchema.indexOf("?");
       if (endPos != -1){
           System.out.println(uriWithoutSchema.substring(uriWithoutSchema.indexOf("/"), endPos));
       }else{
           System.out.println(uriWithoutSchema.substring(uriWithoutSchema.indexOf("/")));
       }

   }

   @Test
    public void test6(){

       String originalUri = "dhy://:@_mnt_data_remote_test-oss/local/bj-hsy-vod/y1khjwzz?/target/hls/2019/03/04/104_c4acf437e7024ea7b5b84b13c5576449_10_t_1280x720.m3u8";
       int index = originalUri.lastIndexOf("/");




   }

    /**
     *
     *
     * 重点：在java中使用正则表达式需要转移 java识别不出来 所以使用\d 时 写成\\d
     *
     * 利用while语句,条件为输入的字符不为'\n'.
     *
     *  使用正则表达式
     *
     * 1.\代表转义    例如： \ , .  , $ , ^ 想要匹配这些字符则使用 \ 转义字符；
     *
     *  如： \^  \$  \.  \\(\本身)  \r ,\n ,\t 回车 换行符 制表符
     *
     *
     *  2.与多种字符匹配（一个）
     *
     *  .(任意一个字符 处理\n)  \d(任意一个数字0-9)  \w(任意数字 字母 自划线 0-9 a-z A-Z _);
     *  \s(空格 制表符 回车)
     *
     *
     *  3.自定义匹配多种字符（一个）
     *  例如
     *  [ab5@]:匹配ab5@任意一个    [^abc]:abc外的任意一个  [^a-d0-2]:a到d，0-2 中外的任意一个
     *
     *  4.修饰匹配的次数
     *  {m}:重复m次  {m,n}:至少重复m次 至多重复n次 {m,}至少重复m次
     *  +：至少重复一次相当于{1，}
     *  *：至少出现任意次或不出现 相当于{0，}
     *  ？：匹配表达式至少0或1次  相当于{0,1}；
     *
     *
     *  5.代表抽象意义的特殊符号
     *  ^:字符串开始的地方
     *  $:字符串结束的地方
     *  \b:匹配一个单词的边界，单词与空格位置
     *  |:表示匹配两边之间表达式 表示匹配左边或者右边
     *  (): 1.在修饰匹配次数的时候，（）里面的可以表示整体修饰的内容
     *      2.取匹配结果的时候，括号中的表达式匹配到的内容可以被单独得到
     *
     *  6.高级匹配
     *  贪婪式：
     *  具体匹配的次数随被匹配的字符串而定。这种重复匹配不定次数的表达式在匹配过程中，总是尽可能多的匹配。
     *
     *  例如； reg="count(\d*)(df)" string name = count012419df 取决于中间出现的数字的个数
     *
     *
     *
     *  使用pattern Matcher类
     *
     *
     */

    //常用reg正则表达式匹配
    @Test
    public void test7_6(){



        //匹配一个或多个汉字
        Pattern compile = Pattern.compile("^[\u0391-\uFFE5]+$");
        Matcher matcher = compile.matcher("翁时斌");
        System.out.println(matcher.find());

        //邮政编码(邮政编码6位)
        Pattern compile1 = Pattern.compile("^[1-9]\\d{5}$");
        Matcher matcher1 = compile1.matcher("339272");
        System.out.println(matcher1.find());

        //QQ号码(5-11位数)
        Pattern compile2 = Pattern.compile("^[1-9]\\d{4,10}");
        Matcher matcher2 = compile2.matcher("550951646");
        System.out.println(matcher2.find());

        //邮箱(QQ)
        Pattern compile3 = Pattern.compile("^[a-zA-Z_]{0,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$");
        Matcher matcher3 = compile3.matcher("550951646@qq.com");
        System.out.println(matcher3.find());

        //用户名（字母开头+数字/字母/下划线）
        Pattern compile4 = Pattern.compile("^[a-zA-Z]{1,}(\\w)*");
        Matcher matcher4 = compile4.matcher("Dhwsb621800");
        System.out.println(matcher4.find());

        //手机号码(首位1  次位3458 共11位)
        Pattern compile5 = Pattern.compile("^[1][3|4|5|8][0-9]\\d{8}$");
        Matcher matcher5 = compile5.matcher("13036027283");
        System.out.println(matcher5.find());

        //URL


        //18位身份证

    }

    //贪婪和非贪婪模式
    @Test
    public void test7_5(){

        //贪婪模式
        Pattern compile = Pattern.compile("<td>.*</td>");
        Matcher matcher = compile.matcher("<table><tr><td>hello</td><td>world</td></tr></table>");
        while (matcher.find()){
            System.out.println("---贪婪---");
            System.out.println(matcher.group(0));
        }

        Pattern compile2 = Pattern.compile("<td>.*?</td>");
        Matcher matcher2 = compile2.matcher("<table><tr><td>hello</td><td>world</td></tr></table>");
        while (matcher2.find()){
            System.out.println("---非贪婪---");
            System.out.println(matcher2.group(0));
        }

    }

    //Matcher.grup使用
    @Test
    public  void test7_4(){

        //matcher.group 匹配的是reg里面括号单独的内容 0：整个 1：第一个括号内 2：第二个括号内  前提是matcher.find()为true！
        Pattern compile = Pattern.compile("count(\\d*)(df)");
        Matcher matcher = compile.matcher("count0003dfkdga");
        System.out.println(matcher.find());
        //System.out.println(matcher.matches());
        System.out.println("group(0):"+matcher.group(0)+" group(1)"+matcher.group(1)+" group(2):"+matcher.group(2));
    }

    //Pattern的split使用
    @Test
    public  void test7_3(){

        //Pattern 创建一个正则表达式 使用complile方法（"\\d+"）!
        Pattern p = Pattern.compile("\\d+");
        Pattern pattern = Pattern.compile("java");
        System.out.println(pattern.pattern());
        System.out.println(p.pattern());

        //Pattern 根据匹配模式拆分输入序列
        //使用\\b 分割字母与符号之间的位置
        Pattern pattern1  =  Pattern.compile("\\b");
        String name  = "124?2?a63@5sdfa4#654";
        String [] names = pattern1.split(name);
        for(String n:names){
            System.out.println("["+n+"]");
        }

        Pattern pattern2 = Pattern.compile("Java");
        String test = "123Java456Java789Java";
        String[] result = pattern.split(test);
        for(String s : result)
            System.out.println("["+s+"]"); //123, 456Java789Java

        Pattern pattern3 = Pattern.compile("java");
        String test1 = "java";
        String test3 = "Java1234";
        String test2 = "1234Java";
        Matcher matcher = pattern.matcher(test1);
        System.out.println(matcher.matches());//返回true


    }

    //str是否包含regex 正则表达式
    @Test
    public void test7_1_1(){

        String name5=   "大风车-2014-13-A1.avi";
        String name2 = "大风车-2014-13-A0.mxf";
        String name3 = "大风车-2014-13-A1.mxf";
        String name = "大风车-2014-13-V0.mxf";
        String vname = "大风车-2014-13-V0.MXF";


        String regex = vname.replaceAll("(?i)V0\\.mxf$", Matcher.quoteReplacement("A\\d+\\.mxf"));

        System.out.println(regex);
        System.out.println(Matcher.quoteReplacement("A\\d+\\.mxf"));

        System.out.println(name5.matches(".*V0\\.mxf$"));

        System.out.println(name3.matches(".*A\\d+\\.mxf$"));


    }

    @Test
    public void testpa(){
        final String videoSuffix = "V0\\.MXF$";
        String exAudioRegBegin = ".*";
        String exAudioNameReg = exAudioRegBegin+"(?i)"+"A\\d+\\.mxf";

        String testAudioNameReg = "A\\d+\\.mxf";
        String[] test = new String[10];
        String test1 = "${FILENAME}/V0\\.mxf$/A\\d+\\.mxf/";
        test = test1.split("/");

        String testa = "大风车-2014-13-A01.MXF";
        String testa1 = "大风车-2014-13-a01.mxf";


        String testv = "大风车-2014-13-V0.MXF";
        String testv1 = "大风车-2014-13-v0.mxf";



        System.out.println(Matcher.quoteReplacement(test[1]));
        System.out.println(Matcher.quoteReplacement(test[2]));
        //String videoName = testa1.replaceAll("(?i)"+"A\\d+\\.mxf", videoSuffix);

        String s = testv.replaceAll("(?i)" + test[1], Matcher.quoteReplacement(test[2]));
        System.out.println(s);
        Pattern compile = Pattern.compile(s, Pattern.CASE_INSENSITIVE);
        System.out.println(compile.matcher(testa).matches());



        //System.out.println(videoName);

        //System.out.println(videoName.equalsIgnoreCase(testv));
        //System.out.println(videoName.equalsIgnoreCase(testv1));


    }


    //Pattern的compile 和 matcher
    @Test
    public void test7_2() {

        String str = "(中文问号？123???英文)问号?我是华丽[的制表符\t]我是华丽{的空格符 我是华丽}的换行符\n";
        String rex = "\b";

        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(str);



        String[] result = pattern.split(str);

        for (String string : result) {
            System.out.println("分割的字符串:" + "[" + string + "]");

        }
    }

    @Test
    public void test7_2_2(){

        String name = "abc";

        String reg = "(?:a)(b)(c)";

        Pattern pattern = Pattern.compile(reg);

        Matcher matcher = pattern.matcher(name);

       // System.out.println(matcher.group(1));
        //System.out.println(matcher.find());
        System.out.println(matcher.matches());

        System.out.println(matcher. group(0));
        System.out.println(matcher. group(1));
        System.out.println(matcher. group(2));

    }

    @Test
    public void test7_2_3(){

        String name = "abc-abc-";

        String reg = "(ab)c(?=-)";

        Pattern compile = Pattern.compile(reg);

        Matcher matcher = compile.matcher(name);

        //System.out.println(matcher.matches());
        System.out.println(matcher.find());

        System.out.println(matcher.groupCount());
        System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
        //System.out.println(matcher.group(2));
        //System.out.println(matcher.group(2));

    }

    @Test
    public void test7_2_4(){

        String name = "a-b-";

        String reg = "(\\w)(?!-)";

        Pattern compile = Pattern.compile(reg);

        Matcher matcher = compile.matcher(name);

        //System.out.println(matcher.matches());
        if(matcher.find()){
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
        }






    }

    @Test
    public void test7_2_5(){

        String name = "abc-abc";

        String reg = "(?<=-)(ab)c";

        Pattern compile = Pattern.compile(reg);

        Matcher matcher = compile.matcher(name);

        //System.out.println(matcher.matches());
        if(matcher.find()){
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
        }



    }

    @Test
    public void test7_2_6(){

        String name = "a-b";

        String reg = "(?!=-)(\\w)";

        Pattern compile = Pattern.compile(reg);

        Matcher matcher = compile.matcher(name);

        //System.out.println(matcher.matches());
        if(matcher.find()){
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
        }



    }

    @Test
    public void test7_2_7(){

        Pattern pattern = Pattern.compile("([a-z]+)(\\d+)");

        Matcher matcher = pattern.matcher("adc123adfa");

        if(matcher.find()){

            System.out.println(matcher.groupCount());
            System.out.println(matcher.group());

            System.out.println(matcher.start());
            System.out.println(matcher.end());

            System.out.println(matcher.start(1));
            System.out.println(matcher.start(2));

            System.out.println(matcher.end(1));
            System.out.println(matcher.end(2));
           // System.out.println(matcher.start("a"));


        }
    }

    @Test
    public void test7_2_1(){

        String str1 = "\b";
        String rex1 = "\\b";

        System.out.println(str1.matches(rex1));

    }

    @Test
    public void test7_1(){

        String name3 = "never ";

        System.out.println(name3.matches("er\b"));

        String name1 ="xxx aaa bbb";

        //注意使用^ 匹配开头字符 后面的字符也要补充 例如 .* 任意的字符在后面匹配
        System.out.println(name1.matches("^xxx.*"));

        //举例子：陪陪带小数点的数字
        String name = "12.2";

        System.out.println(name.matches("\\d+\\.?\\d"));

        name="123";
        System.out.println(name.matches("\\d*"));

        String name2 = "a";
        System.out.println(name.matches("[ab]"));

//        name.matches("\\d{4}\\-\\d{1,2}\\-\\d{1,2}");
    }

    /**
     *   题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
     */

   @Test
    public void test7(){
       String s = "LKAJFJ12531 AJKSLFJ#KASJF__)882嘻嘻34翁时斌&^$";
       System.out.println("s的总共length:"+s.length());

       String regex = "\\d";
       int digit = 0;
       String regex1 = "[\u0391-\uFFE5]";
       int word = 0;
       String regex2 = "\\s";
       int otherword = 0;
       String regex3 = "[a-zA-z]";
       int Enword = 0;
       int other = 0;

       char[] chars = s.toCharArray();
       int length = s.length();

       for (int i = 0; i < length; i++) {
            String e = String.valueOf(chars[i]);
            if(e.matches(regex))
                digit++;
            else if(e.matches(regex1))
                word++;
            else if(e.matches(regex3))
                Enword++;
            else if (e.matches(regex2))
                otherword++;
            else
                other++;
       }
       System.out.println("数字："+digit+" 汉字："+word+" 英文："+Enword+" 字符："+otherword+" 其他："+other);


   }
    /**
     * 题目：将字符串的空格替换成 %20
     */
    @Test
    public void test8(){
        String s = "We Are Hero I love Chinese City";

        System.out.println(s.replace(" ", "%20"));

    }
    /**
     * （1）把每个单词的首字母变为大写。
     * （2）把数字与字母之间用下划线字符（_）分开，使得更清晰；
     * （3）把单词中间有多个空格的调整为1个空格。
     */

    //(3)
    @Test
    public void test9(){

        String jvzi="asdf adf  adfa   asdf";
        // 把单词中间有多个空格的调整为1个空格。

        //使用正则表达式  replaceAll中的方法 regex--》 " +"表示一个以上的" "替换成" "
        jvzi=jvzi.replaceAll(" +"," ");
        System.out.println(jvzi);

    }

    //(2)  charAt（i） 方法： 获取i中index 返回对应成char
    @Test
    public void test10(){

        String  s = "asdga132asdfa1dadf";

        int length = s.length();


        for (int i = 0; i < s.length()-1; i++) {

            String  firstAt = String.valueOf(s.charAt(i));

            String  secodAt = String.valueOf(s.charAt(i+1));

            if(firstAt.matches("[0-9]")&&secodAt.matches("[a-z]")||
                    firstAt.matches("[a-z]")&&secodAt.matches("[0-9]")){

                s = s.substring(0, i+1)+"_"+s.substring(1+i);


            }


        }
        System.out.println(s);


    }

    @Test
    public void test11() {

        String s = "aaabbbaaac";

        ArrayList<Integer> integers = new ArrayList<>();

        int index = 0;
        int length = s.length();
        int wordlength = 0;
        double result = 0;

        while (index<length){

            wordlength=1;

           while(index<length-1&&s.charAt(index)==s.charAt(index+1)){
                wordlength++;
                index++;
            }
            integers.add(wordlength);
            index++;
        }

        for (Integer i :integers) {
            System.out.println(i);
            result +=i;
        }
        System.out.println("average:"+result/integers.size());
    }



}
