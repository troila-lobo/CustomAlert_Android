# 前言
>本框架是对Dialog和Toast简单封装，满足项目日常提示显示
### 项目组成
##### 项目整体分为两部分
* Android Dialog弹出框
* Android 定时消失的Toast

### 1、Dialog
>Dialog 的基础样式为白底，其他部分半透明，带有标题，图标，内容，两个按钮
>* Dialog 根据所传值显示内容，不传默认不生效
>
| 方法名 | 说明 | 
| - | - | 
|`showDialogOnlyContent(String msg)`| 显示简单文字框|
| `showDialogTCBB(String title,String msg,String negativeButtonText,DialogInterface.OnClickListener negativeButtonlistener,String positiveButtonText,DialogInterface.OnClickListener positiveButtonlistener) ` | 显示简单错误提示框 |
