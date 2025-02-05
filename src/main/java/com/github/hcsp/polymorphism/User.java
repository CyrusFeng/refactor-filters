package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class User {
    /**
     * 用户ID，数据库主键，全局唯一
     */
    private final Integer id;

    /**
     * 用户名
     */
    private final String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    interface Predicate {
//        boolean isSatisfying(User users);
//    }
//    static abstract class xxx implements Predicate{
//        public abstract boolean isSatisfying(User user);
//    }

    //    class AAA extends xxx{
//
//        @Override
//        public boolean isSatisfying() {
//            return filter(User users);
//        }
//    }
//    static class 判断id是否为偶数 implements Predicate {
//        @Override
//        public boolean isSatisfying(User user) {
//            return user.id % 2 == 0;
//        }
//    }


    public static void main(String[] args) {
        List<User> users =
                Arrays.asList(
                        new User(1, "a"), new User(2, "b"), new User(3, "c"), new User(4, "d"));


//        System.out.println(filter(users,new 判断id是否为偶数()));
        filterUsersWithEvenId(users);
        filterZhangUsers(users);
        filterWangUsers(users);
    }

    static class 过滤ID为偶数的用户 implements Predicate<User>{
        @Override
        public boolean test(User user) {
            return user.id % 2 == 0;
        }
    }
    static class 过滤姓张的用户 implements Predicate<User>{
        @Override
        public boolean test(User user) {
            return user.name.startsWith("张");
        }
    }
    static class 过滤姓王的用户 implements Predicate<User>{
        @Override
        public boolean test(User user) {
            return user.name.startsWith("王");
        }
    }

    public static List<User> filter(List<User> users,Predicate<User> predicate) {
        List<User> results = new ArrayList<>();
        for (User user : users) {
            if (predicate.test(user)) {
                results.add(user);
            }
        }
        return results;
    }

    // 过滤ID为偶数的用户
    public static List<User> filterUsersWithEvenId(List<User> users) {
//        List<User> results = new ArrayList<>();
//        for (User user : users) {
//            if (user.id % 2 == 0) {
//                results.add(user);
//            }
//        }
//        return results;
        return filter(users,new 过滤ID为偶数的用户());
    }

    // 过滤姓张的用户
    public static List<User> filterZhangUsers(List<User> users) {
//        List<User> results = new ArrayList<>();
//        for (User user : users) {
//            if (user.name.startsWith("张")) {
//                results.add(user);
//            }
//        }
//        return results;
        return filter(users,new 过滤姓张的用户());
    }

    // 过滤姓王的用户
    public static List<User> filterWangUsers(List<User> users) {
//        List<User> results = new ArrayList<>();
//        for (User user : users) {
//            if (user.name.startsWith("王")) {
//                results.add(user);
//            }
//        }
//        return results;
        return filter(users,new 过滤姓王的用户());
    }
    // 你可以发现，在上面三个函数中包含大量的重复代码。
    // 请尝试通过Predicate接口将上述代码抽取成一个公用的过滤器函数
    // 并简化上面三个函数
//    public static List<User> filter(List<User> users, Predicate<User> predicate) {}
}
