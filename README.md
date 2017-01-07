# Android 培训

Android lesson by Juhezi in 2017

## View

XML通用属性：

* id - Java代码中根据此属性找到该View(@+id/btn_test)

* layout_width - 宽度

    * match_parent - 与父布局的尺寸相同

    * wrap_content - 由内容决定，内容有多大，该View就有多大

    * xdp - 具体大小

* layout_height - 高度

    * 同上

* layout_margin - 设置外间距

* padding - 设置内间距

* background - 设置背景（可以是图片，也可以是颜色）

* gravity - 设置内容的位置

### TextView

* text - 显示的文本

* textColor - 文本颜色

* textSize - 文本字体大小

### EditText

* hint - 提示文本

* textColorHint - 提示文本颜色

* inputType - 文本输入类型

* 其他与TextView 相同

### Button

* 与TextView相同

### ImageView

* src - 设置显示的图片

## ViewGroup

### RelativeLayout 相对布局

以下属性都是对于RelativeLayout子控件而言：

* layout_centerHorizontal - 位于水平中央

* layout_alignBottom - 与某控件的底部对齐

* layout_toRightOf - 位于某控件的右边

* ...

### LinearLayout 线性布局

以下属性都是对于LinearLayout子控件而言：

* layout_weight - 设置权重

* layout_gravity - 设置本View在父控件中的位置

## 快捷键

* ctrl + alt + l - 调整代码格式

* ctrl + alt + 空格 - 显示候选词

* 双击Shift - 全局查找

* ctrl + f - 查找

* ctrl + 鼠标左键 - 查看源码

## 其他

* android:background="?selectableItemBackground" - 设置点击效果(涟漪)

* Log.i(TAG,message) - 打印Log日志
