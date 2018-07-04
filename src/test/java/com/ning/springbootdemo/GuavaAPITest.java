package com.ning.springbootdemo;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GuavaAPITest {

    //使用com.google.common.base.Strings类的isNullOrEmpty(input)方法判断字符串是否为空
    @Test
    public void testString1(){
        String string = "";
        boolean nullOrEmpty = Strings.isNullOrEmpty(string);
        System.out.println(nullOrEmpty);
    }

    // 获得两个字符串相同的前缀或者后缀
    @Test
    public void testString2(){
        String a = "www.joysuch.com";
        String b =  "www.baidu.com";
        String prefix = Strings.commonPrefix(a, b);
        String suffix = Strings.commonSuffix(a, b);
        System.out.println(prefix);
        System.out.println(suffix);
    }

    // Strings的padStart和padEnd方法来补全字符串
    @Test
    public void testString3(){
        String a = "123";
        String padStart = Strings.padStart(a, 4, '0');
        String padEnd = Strings.padEnd(a, 4, '4');
        System.out.println(padStart);
        System.out.println(padEnd);
        System.out.println(a);
    }

    //使用Splitter类来拆分字符串
    //Splitter类可以方便的根据正则表达式来拆分字符串，可以去掉拆分结果中的空串，可以对拆分后的字串做trim操作，还可以做二次拆分
    @Test
    public void testString4(){
        Iterable<String> split = Splitter.onPattern("[,.]{1,}").trimResults().omitEmptyStrings().split("你好,World. Hello.世界");
        split.forEach(System.out::println);
        /*
        * Splitter的onPattern方法传入的是一个正则表达式，其后紧跟的trimResults()方法表示
        * 要对结果做trim，omitEmptyStrings()表示忽略空字符串，split方法会执行拆分操作。
        * split返回的结果为Iterable<String>，我们可以使用for循环语句来逐个打印拆分字符串的结果。
        * */
    }

    //Splitter还有更强大的功能，做二次拆分，这里二次拆分的意思是拆分两次，例如我们可以将a=b;c=d这样的字符串拆分成一个Map<String,String>
    @Test
    public void testString5(){
        String toSplitString = "a=b;c=d,e=f";
        Map<String, String> split = Splitter.onPattern("[,;]{1,}").withKeyValueSeparator('=').split(toSplitString);
        for (Map.Entry<String,String> entry : split.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        //二次拆分首先是使用onPattern做第一次的拆分，然后再通过withKeyValueSeperator('')方法做第二次的拆分。
    }

    //guava提供了Joiner类来做字符串的合并,使用Joiner.on(" ").join(xx)来合并字符串
    @Test
    public void testString6(){
        String join = Joiner.on('.').join(new String[]{"hello", "world"});
        System.out.println(join);
    }

    //Splitter方法可以对字符串做二次的拆分，对应的Joiner也可以逆向操作，将Map<String,String>做合并
    @Test
    public void testString7(){
        Map<String,String> map = new HashMap<>();
        map.put("a","b");
        map.put("c","d");
        String join = Joiner.on("&").withKeyValueSeparator("=").join(map);
        System.out.println(join);
        //使用withKeyValueSeparator方法可以对map做合并。合并的结果是:a=b&c=d
    }


}
