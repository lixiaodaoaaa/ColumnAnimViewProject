# ColumnAnimViewProject
##为何要用带动画的柱状图呢？

by: lixiaodaoaaa 简单总结下:

最近，项目中遇到一个地方，要用到柱状图。所以这篇文章主要讲怎么搞一个柱子。100行代码，搞定柱状图!
![这里写图片描述](http://img.blog.csdn.net/20170519010413220?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGl4aWFvZGFvYWFh/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

圆角，头顶带数字。恩，这样用drawable也可以搞定。但是，这个柱子是有一个动画的，就是进入到界面的时候柱子不断的长高。这样的话，综合考虑还是用自定义View来做比较简便。效果如下图了：

![这里写图片描述](http://img.blog.csdn.net/20170519011923930?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGl4aWFvZGFvYWFh/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

关于尺寸
-------
控件尺寸直接来自xml中的设置，无需进行onMeasure测量。所以使用getWidth和getHeight获取高度。

关于数据范围
-------
数据如果是一个柱子单独显示，则数据的范围不是很重要，但是柱状图通常是由很多柱子并列显示的，而这些柱子的单位高度都应该是一样的，所以提供设置最大值的范围，最小值就是0.

关于数字的文字大小
-------
由于柱子的宽度就是整个View的宽度，所以数字的宽度不能超过柱子的宽度。因为这个原因，文字的size需要动态计算。意思就是 0和100000这两个数字显示的时候，文字的大小是不一样的。

关于边界值
-------
0，是一个边界值（最小值），当显示0的时候，并不是柱子不显示的，而是显示一个最小高度的。

关于动画
-------

不停的设置值，就会形成动画。意思是先设置数据1，然后紧接着设数据2.3.4.5……一直到最终的显示值，就会有动画效果。但是如果最终数值很大，1,1,1的增加就会很慢，动画时间很长。

简单调用办法：
-------
```
        column_one = (PColumn) findViewById(R.id.column_one);
        column_two = (PColumn) findViewById(R.id.column_two);
        column_three = (PColumn) findViewById(R.id.column_three);

        column_one.setData(0, 100);
        column_two.setData(30, 400);
        column_three.setData(450, 900);
```
