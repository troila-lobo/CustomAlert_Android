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
 	CommonDialogFragment dialogFragment = CommonDialogFragment.newInstance(new CommonDialogFragment.OnCallDialog() {
                    @Override
                    public Dialog getDialog(Context context) {
       new CustomDialog.Builder(context)
		.setTitle(title)
                .setMessage(msg)
                .setIconType(iconType)
		.setTitleColor(titleColor).setTitleSize(titleSize)
                .setContentColor(msgColor).setContentSize(msgSize)
                .setButtonLeftColor(negativeButtonTextColor).setContentSize(negativeButtonTextSize)
                .setButtonRightColor(positiveButtonTextColor).setContentSize(positiveButtonTextSize)
                .setNegativeButton(negativeButtonText, negativeButtonlistener)
                .setPositiveButton(positiveButtonText, positiveButtonlistener).create();
		 }
                }, true);
                dialogFragment.show(getSupportFragmentManager(), "tag");
   
| 方法名 | 说明 | 
| - | - | 
|`setTitle(title)`| 设置标题|
| `setMessage(msg)` | 设置内容 |
| `setIconType(iconType)` | 设置图标仅"success","fail" ,"warning" |
| `setTitleColor(titleColor).setTitleSize(titleSize)` | 设置标题的样式，颜色字体|
| `setContentColor(msgColor).setContentSize(msgSize)` | 设置内容的样式，颜色字体|
| `setButtonLeftColor(negativeButtonTextColor).setContentSize(negativeButtonTextSize)` | 设置左边按钮的样式，颜色字体|
| `setButtonRightColor(positiveButtonTextColor).setContentSize(positiveButtonTextSize)` | 设置右边按钮的样式，颜色字体|
| `setNegativeButton(negativeButtonText, negativeButtonlistener)` | 设置按钮文字和事件|
| `setPositiveButton(positiveButtonText, positiveButtonlistener)` | 设置按钮文字和事件|
### 2、Toast
>Toast 的基础样式为白底，其他部分半透明，带有标题，图标，内容，两个按钮
>* Toast 根据所传值显示内容，不传默认不生效
>
	CustomToast.showToast(context,"success", "文字");
| 方法名 | 说明 | 
| - | - | 
| `showToast(Context context,String icon,String msg)` | 带图标的Toast，图标仅"success","fail" ,"warning"  |
### 3、ProgressDialog
>ProgressDialog 包含进度条和文字
>
 		new ProgressDialog.Builder(context)
                        .setTitle(title).create().show();
| 方法名 | 说明 | 
| - | - | 
|`setTitle( msg)`| 设置标题|





