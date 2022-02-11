package com.shang.demo.java17Test;

import org.junit.jupiter.api.Test;

public class Java17Test {

    /**
     * json格式字符串不需要转义了
     */
    @Test
    public void test(){
        String jsonStr = """
                {
                    "name": "Java",
                    "age": 18,
                    "address": "北京市西城区"
                }
                """;
        System.out.println(jsonStr);
    }

    @Test
    public void switchTest(){
//        lowVersion1(Fruit.APPLE);
//        System.out.println("============");
//        lowVersion2(Fruit.APPLE);
//        System.out.println("============");
//        withSwitchExpression(Fruit.MANGO);
//        System.out.println("============");
//        withReturnValue(Fruit.MANGO);
//        System.out.println("============");
//        withYield(Fruit.PEAR);
        System.out.println("============");
        oldStyleWithYield(Fruit.MANGO);
    }

    private static void oldStyleWithYield(Fruit fruit) {
        System.out.println(switch (fruit) {
            case APPLE, PEAR:
                yield "普通水果";
            case MANGO, AVOCADO:
                yield "进口水果";
            default:
                yield "未知水果";
        });
    }

    private static void withYield(Fruit fruit) {
        String text = switch (fruit) {
            case APPLE, PEAR -> {
                System.out.println("给的水果是: " + fruit);
                yield "普通水果";
            }
            case MANGO, AVOCADO -> "进口水果";
            default -> "未知水果";
        };
        System.out.println(text);
    }

    private static void withReturnValue(Fruit fruit) {
        String text = switch (fruit) {
            case APPLE, PEAR -> "普通水果";
            case MANGO, AVOCADO -> "进口水果";
            default -> "未知水果";
        };
        System.out.println(text);
    }

    private static void withSwitchExpression(Fruit fruit) {
        switch (fruit) {
            case APPLE, PEAR -> System.out.println("普通水果");
            case MANGO, AVOCADO -> System.out.println("进口水果");
            default -> System.out.println("未知水果");
        }
    }

    private static void lowVersion1(Fruit fruit) {
        switch (fruit) {
            case APPLE, PEAR:
                System.out.println("普通水果");
            case MANGO, AVOCADO:
                System.out.println("进口水果");
            default:
                System.out.println("未知水果");
        }
    }

    private static void lowVersion2(Fruit fruit) {
        switch (fruit) {
            case APPLE, PEAR:
                System.out.println("普通水果");
                break;
            case MANGO, AVOCADO:
                System.out.println("进口水果");
                break;
            default:
                System.out.println("未知水果");
        }
    }

    @Test
    public void recordTest(){
        Person p1 = new Person("小黑说Java", 18, "北京市西城区");
        Person p2 = new Person("小白说Java", 28, "北京市东城区");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.equals(p2));
    }
    @Test
    public void recordTest2(){
        Person p1 = new Person("小黑说Java", 18, "北京市西城区");
        Person p2 = new Person("小白说Java", 28, "北京市东城区");
        record PersonRecord(String name, int age){}
        PersonRecord personRecord1 = new PersonRecord(p1.getName(), p1.getAge());
        PersonRecord personRecord2 = new PersonRecord(p2.getName(), p2.getAge());
        System.out.println(personRecord1);
        System.out.println(personRecord2);
    }

    @Test
    public void recordTest3(){
        Person p1 = new Person("小黑说Java", 18, "北京市西城区");
        Person p2 = new Person("小二说Java", 28, "北京市东城区");
        record PersonRecord2(String name, int age) {
            // 构造方法
            PersonRecord2 {
                System.out.println("name " + name + " age " + age);
                if (name == null) {
                    throw new IllegalArgumentException("姓名不能为空");
                }
            }
        }
        PersonRecord2 p1Record = new PersonRecord2(p1.getName(), p1.getAge());
        PersonRecord2 p2Record = new PersonRecord2(p2.getName(), p2.getAge());
        System.out.println(p1Record);
        System.out.println(p2Record);
    }
}
