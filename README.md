# 前言
>本框架是对Dialog和Toast简单封装，满足项目日常提示显示
### 使用方法
* Step 1
 > allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
* Step 2
 > dependencies {
	        implementation 'com.github.troila-mobile:CustomAlert_Android:1.0.1'
	}
### 项目组成
##### 项目整体分为两部分
* Android Dialog弹出框
* Android 定时消失的Toast

### 1、Dialog
>* Dialog 的基础样式为白底，其他部分半透明，带有标题，图标，内容，两个按钮
>* Dialog 根据所传值显示内容，不传默认不生效
>
| 方法名 | 说明 | 
| - | - | 
|`showDialogOnlyContent(String msg)`| 显示简单文字框|
| `showDialogTCBB(String title,String msg,String negativeButtonText,DialogInterface.OnClickListener negativeButtonlistener,String positiveButtonText,DialogInterface.OnClickListener positiveButtonlistener) ` | 显示标题内容按钮 |
| `showDialogAll(String title,String msg,int icon,String negativeButtonText,DialogInterface.OnClickListener negativeButtonlistener,String positiveButtonText,DialogInterface.OnClickListener positiveButtonlistener)` | 显示标题图标内容按钮 |
| `showDialogTCBBStyle(String title,int titleStyle,String msg,int icon,int msgStyle,String negativeButtonText,int leftStyle,DialogInterface.OnClickListener negativeButtonlistener,String positiveButtonText,int rightStyle,DialogInterface.OnClickListener positiveButtonlistener)` | 可设置样式的 ，style字段设为0，显示默认样式|
| `showDialogICBB(int icon,String msg,String negativeButtonText,DialogInterface.OnClickListener negativeButtonlistener,String positiveButtonText,DialogInterface.OnClickListener positiveButtonlistener)` | 显示标题图标内容按钮|
### 1、Toast
>Toast 的基础样式为白底，其他部分半透明，带有标题，图标，内容，两个按钮
>* Toast 根据所传值显示内容，不传默认不生效
| 方法名 | 说明 | 
| - | - | 
|`showToast(String msg)`| 显示简单提示框|
| `showToastIC(int icon,String msg)` | 显示带图标提示框 |
| `showToastPC(String msg)` | 带进度条的提示框 |

