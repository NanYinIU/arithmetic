package com.effctiveJava;

import java.util.Objects;

/**
 * 不区分大小写（equals）
 */
public class CaseInsensitiveString {
    String string;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaseInsensitiveString that = (CaseInsensitiveString) o;
        return Objects.equals(string, that.string);
    }

    static class A{
        public A(String s) {
            this.s = s;
        }

        String s;
//        @Override
//        public boolean equals(Object o){
//            if(o instanceof B){
//                B b = (B)o;
//                return b.s.equalsIgnoreCase(s);
//            }
//            else if(o instanceof A){
//                A a = (A)o;
//                return a.s.equalsIgnoreCase(s);
//            }
//            else return false;
//        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

    static class B{
        String s;

        public B(String s) {
            this.s = s;
        }

//        @Override
//        public boolean equals(Object o){
//            if(o instanceof B){
//                B b = (B)o;
//                return b.s.equalsIgnoreCase(s);
//            }
//            else return false;
//        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

    static class C{
        String s;

        public C(String s) {
            this.s = s;
        }
    }

    public static void main(String[] args) {
        A a = new A("z");
        B b = new B("z");
        System.out.println(a.equals(b));
        System.out.println(b.equals(a));
//        C c = new C("a");
//        C c_c = new C("a");
//        System.out.println(c.equals(c_c));
    }
}
