public class Test {
    public static void main(String[] args) {
        Child child = new Child();
        child.TakeIt();
        child.doIt();
        System.out.println(child.name);
        System.out.println(child.age);
    }
}
class Parent {
    String name = "Mg Mg";
    public Parent() {
    }
    void doIt() {
        System.out.println("Hello");
    }
}
class Child extends Parent {
    int age = 0;
    public Child( ) {}
    public Child(String d) {}
    public Child(int r) {}
    public Child(String r,int w) {}
    public Child(int e , String q) {}
    public Child(String t,String a) {}
    public Child(int p,int y) { }

    void TakeIt() {
        System.out.println("Hello");
    }
}