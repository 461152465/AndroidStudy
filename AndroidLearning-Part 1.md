安卓编程虽然是以Java语言作为基础，但是需要使用需要Android包中的类和方法，目前接触到的如有Toast、Intent、RecyclerView这些，或者ConnecvityManage这些需要查阅API等Java基础语言不会涉及到的部分，所以在学习的时候需要透析应用方法， 不然在编写个人APP的时候可能会遇到想要的效果不知道如何实现的问题。
另外APP是一个工程项目，所以除了JAVA语言的使用，关于页面的布局需要使用XML语言。
需要熟悉Android包中常见组件的使用，例如对于常用方法以及类，需要了解import的包，类的常用方法，方法参数的意义。

### 广播(Broadcast)
广播是安卓四大组件之一，
动态注册监听网络：在代码中注册Broadcast，动态注册只能在程序运行状态下能够有效
静态注册监听网络：在AndroidMainfest中注册Broadcast，静态注册能够在程序启动之前有效
监听系统的网络状态需要在AndroidMainfest中使用uses-permission说明权限
ConnectivityManager主要用于管理与网络连接相关的操作用于查询网络连接状态

广播静态注册的步骤例子：
1. 建立一个Broadcast Receiver类，接受发出的广播
2. 在AndroidMainfest.xml中使用intent-filter注册
3. 在活动中使用sendBroadcast(intent)发出广播

在xml布局文件中需要使用string类型时，首先在strings.xml中
```xml
<string name="string_name">字符串</string>
```
然后再使用android:name="@string/string_name"引用，避免了硬编码的问题

>备注：发送有序广播的实验失败...


### Java
Java抽象类 抽象方法 内部类 匿名内部类
静态代码块 非静态代码块
静态方法 非静态方法
接口

接口和抽象类的区别

1. 匿名内部类
```java 
//定义一个抽象类Bird
public abstract class Bird {
	private String name;
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public abstract int fly();
}

public class Test {
	public void test(Bird bird){
		System.out.println(bird.getName()+" can fly "+bird.fly()+" meters");
	}
	
	public static void main(String[] args){
		Test test = new Test();
		test.test(new Bird(){
			public int fly(){
				return 1000;
			}
			public String getName(){
				return "Sea gull";
			}
		});
	}
}
```
首先定义了一个抽象类Bird，抽象类是不能直接new创建对象的，所以使用test(new Bird() {父类构造器 + 接口 + 方法});
相当于在test()方法中创建了一个只能使用一次的匿名的类，这个类继承了Bird（）抽象类
实现匿名内部类的方式是实现一个接口或者继承一个类，上面的代码继承了Bird()抽象类，而Android的button则是实现了onClickListener接口

---
Android Studio中如果要使用RecyclerView，需要在app/gradle中添加相应的依赖，而且对于依赖的版本有要求，可以File -> Project Structure -> app -> dependencies中查询对应版本的包，然后添加。
在Layout中创建需要的布局，然后可以在Class里通过R.id.xxx_layout加载相应的布局。

关于XML语言的基本语法总结
```xml
对于一般的元素，格式：
<TextView 元素属性/>
<View 元素属性/>
对于Layout布局，格式：
<LinearLayout 元素属性> </LinearLayout>

//example
<LinearLayout 
android:id="@+id/layout">
</LinearLayout>
```

在类中记载布局的方法，重写onCreate方法
```java
@Override
    public View onCreatView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        return view;
    }
```
其中LayoutInflater引用res/layout中的xml布局，类似于findViewById因为layout中的widget一样。
