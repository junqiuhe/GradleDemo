#### 如何学习Gradle?

    1、Gradle是基于语言Groovy.

    2、Gradle DSL学习

    3、Android Plugin DSL学习

    4、Gradle Task

#### Gradle 构建周期

    1、Initialization

    2、Configuration

    3、Execution

#### Task

    1、Task 声明
```
    task myTask
    task myTask {configure closure}
    task (myTask) {configure closure}
    task (name: myTask) {configure closure}
```

    2、Gradle还支持Task类的书写（支持Task的复用）

    2.1、将下述代码写在 'build.gradle' 中, 并用@TaskAction标记想要执行的方法
```
class GreetingTask extends DefaultTask{
    String greeting = "hello from GreetingTask"

    @TaskAction
    def greet(){
        return greeting
    }
}
```

    2.2、在 'build.gradle' 中撰写 Task 调用 GreetingTask 类

```
task(name: hello, type: GreetingTask)

task(name: greeting, type: GreetingTask){
    greeting = "greetings from GreetingTask"
}
```

    2.3、执行task.

#### Gradle 自定义插件

我们平时在进行Android开发时，都会使用Gradle进行项目配置，通常在对应的module:app的build.gradle中,
```
apply plugin: 'com.android.application'
```
这句话就是用来加载gradle的android开发插件，然后，我们就可以使用该插件提供的配置方法进行Android项目配置.

按照自定义插件基于源码放置，分为三种：

1、Build Script.

这种插件脚本的源码放置在模块内的 build.gradle 中，好处就是插件脚本会自动编译并添加进模块的 classpath 中，我们完全不用做任何事情。但是，这种插件脚本只能声明在这个 build.gradle中使用，其它模块没有办法复用这个插件.

```
//app build.gradle
apply plugin: HelloPlugin1

/**
 * 创建插件的方式一: build script.
 */
class HelloPlugin1 implements Plugin<Project>{
    @Override
    void apply(Project project) {
        project.task("helloPlugin1Task"){
            doFirst {
                println "Hello Plugin 1"
            }
        }
    }
}
```


2、buildSrc project

这种插件脚本要求源码放在 `rootProject/buildSrc/src/main/groovy`目录内（也就是工程根目录下创建buildSrc目录），然后[Gradle]就会自动编译和测试这个插件。同时，这种方法创建的插件对工程内的所有模块都可以使用。


3、Standalone Project.

这种方法就是使用单独的一个工程/模块创建我们的 gradle 插件，这种方法会构建和发表一个 Jar 文件，可以提供多个工程和其它开发者共同使用.


#### 参考链接

[Gradle自定义插件以及发布方法](https://www.jianshu.com/p/d1d7fd48ff0b)

[写给 Android 开发者的 Gradle 系列（三）撰写 plugin](https://juejin.im/post/5b02113a5188254289190671)
