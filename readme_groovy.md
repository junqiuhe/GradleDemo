#### Groovy 学习笔记

1、通过 def 关键字声明变量以及方法

```
    def a = 1
    def b = "hello world"
    def int c = 1
    
    def hello(){
        println "hello world"
        return 1
    }
```

2、Groovy中，很多东西是可以省略的。比如：

    1、语句后面的分号是可以省略的
    2、变量的类型和方法的返回值可以是省略的
    3、方法调用时，括号也是可以省略的
    4、甚至语句中的return都是可以省略的.
    
```
    def a = 1  //没有分号以及变量的类型是可以省略的。
    def b = "hello world"
    def int c = 1
    
    def int hello(msg){  //方法省略的参数类型
        println "hello world ${msg}"  //调用方法可以省略括号
        12
    }
```


3、Groovy数据类型

    1、Java中的基本数据类型
    2、Java中的对象
    3、Closure(闭包)
    4、加强的List, Map等集合类型
    5、加强的File、Stream等IO类型
    
3.1、String数据类型：在于字符串的拼接
```
    def a = 1
    def b = 2
    def c = "a = ${a} and b = ${b}"
```

3.2、Closure(闭包)

```
    def closure = { int a, int b ->
        println "a=${a}, b=${b}, I am a closure."
    }
    
    //省略了闭包的参数类型
    des test = { a, b->
        println "a=${a}, b=${b}, I am a closure."
    }
```

4、Class是一等公民
在Groovy中，所有的Class类型，都是可以省略.class
```
fun(File.class)
fun(File)

def fun(Class clazz){
}
```
5、Getter与Setter
在Groovy中，Getter与Setter和属性是默认关联的,只要有属性就用 Getter 与 Setter,
同理，只要有 Setter/Getter，那么它就有隐含属性.
```
class Book{
    private String name
    String getName(){
        return name
    }
    
    void setName(String name){
        this.name = name
    }
}

class Book{
    String name
}
```
6、with操作符
```
static void withOp(){
    Book book = new Book()
    book.with {
        id = 1
        name = "Jackson"
        age = 12
    }

    println book
}
```


7、判断是否为真
```
if (name != null && name.length > 0) {}
 
可以替换为：
if (name) {}
```


8、简洁的三元表达式
```
def result = name != null ? name : "Unknown"
 
// 省略了name
def result = name ?: "Unknown"
```

9、简洁的非空判断
```
if (order != null) {
   if (order.getCustomer() != null) {
       if (order.getCustomer().getAddress() != null) {
       System.out.println(order.getCustomer().getAddress());
       }
   }
}
 
可以简写为：
println order?.customer?.address
```

10、switch方法: 支持更多的参数类型，同时变得更加灵活

```
def x = 1.23
def result = ""
switch (x) {
   case "foo": result = "found foo"
   // lets fall through
   case "bar": result += "bar"
   case [4, 5, 6, 'inList']: result = "list"
   break
   case 12..30: result = "range"
   break
   case Integer: result = "integer"
   break
   case Number: result = "number"
   break
   case { it > 3 }: result = "number > 3"
   break
   default: result = "default"
}
assert result == "number"
```

11、== 和 equals.
Groovy中, == 相当于Java中的 equals。比较两个对象是否是同一个，采用is。