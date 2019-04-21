<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8" />
    <title></title>
</head>
<body>
	<center>FreeMarker  函数    指令  以及自定义函数的实例</center>
	
	<h2>1.对字符串的操作</h2>
		<#assign str1 ="hello" />
		<#assign str2 ="world" />
		字符串的连接 用 +：${str1 + str2} <br/>              <#-- 连接 -->
		截取字符串：${(str1+str2)?substring(5,8)} <br/>   <#-- 截取   -->
		获取字符的长度：${str1?length} <br/> 
		大写：${str1?upper_case}<br/>    <#--  非java的驼峰的  命名   而是使用下划线的方式    -->
		小心：${str2?lower_case}<br/> 
		index of 首次出现的位置${str1?index_of("o")}<br/> 
		替换：${str1?replace('l','x')}   <br/> 
		last index of 单词最后一处出现的位置：${str1?last_index_of("l")}<br/> 	
		
	<h2>2.自定义函数</h2>
		<#assign myshuzu = [2,3,8,1,9,5,6] />  <#-- 自定义数组 -->
		未排序的时候直接用list语法：
		<#list myshuzu as items>
			${items}
		</#list>
		
		<br/>
		使用排序算法进行list输出:
		<#list short_int(myshuzu) as items> <#-- 使用后台的排序的自定义函数  short_int  是后台传过来的 -->
			${items}
		</#list>
		
		<br/>
		=====================内置的函数内置的函数内置的函数内置的函数排序： 直接使用sort
		<#list myshuzu?sort as item>
			下标：${item_index}值：${item}  <#-- item_index 获取下标 -->
		</#list>
		
		<br/>
		数组的倒置：直接使用：reverse
		<#list myshuzu?reverse as items>
			${items}
		</#list>
		
		<br/>
		获取集合的长度:${myshuzu?size}
		<br/>
		list下边取值：${myshuzu[2]} <#-- list下边取值 -->
		
	<h2>3.自定义指令</h2> <#-- ctrl+t 查看具体的实现类 -->
		<#-- 两个入参   user  当前用户的id    role 角色      两个返回值   1  是不是这个角色   2角色的权限 -->

	<h2>4.内建函数</h2>
	1.处理字符串的   -->  substring 字符串截取  cap_first 首字母变大写  ends_with 以..结尾   contains 是否包含目标字符串   <br/>
			   -->  date datetime time  字符串转换时间类型                                                                                                                                 <br/>
			   -->  start_with 已..开始  index_of  last_index_of spilt 切分     trim  去掉两头的空格                       <br/>
	2.处理数字的       -->  ?string("0.##")小数后几位  round  floor ceiling                                 <br/>
	3.list的          -->   first last seq_contains seq_index_of  size rever sort sort_by     chunk分块    <br/>
	4.其他内建函数  -->   is_string  is_number is_method 是不是方法    ()括起来  has_content整体判断            eval      <br/>
	
	
	
	<h2>5.宏 macro nested tetrn 指令</h2>
		macro 语法：<br/>
		第一个，没有参数的宏指令<br/>
			<#macro test> <#-- 申明一个没有参数的 macro 指令 -->
				我是没有参数的macro
			</#macro>
		
			<@test /><#-- 调用 macro -->
		<br/>
		第二个，有参数的macro<br/>
			<#macro havepar par1 par2>   <#-- 申明 -->
				传递的参数 ${par1},${par2}
			</#macro>
		
			<@havepar par1="java" par2="js" />   <#-- 调用 -->
		<br/>
		第三个,有默认参数的  在声明的时候赋值  传的话用传的  不传的话 使用默认的<br/>
			<#macro defval par1 par2="java">   <#-- 申明 -->
				传递的参数：${par1},${par2}
			</#macro>
			
			<@defval par1=".net" par2="hello java" />有传<br/>    <#-- 调用 -->
			<@defval par1=".net" />不传<br/> 
		<br/>
		第四种,有多个参数<br/>
			<#macro manyVal par1 par2 parext...>   <#-- 申明 -->
				第一个参数：${par1}<br/>
				第二个参数：${par2}<br/>
				多个参数 ： ${parext['par3']}
			</#macro>
		<@manyVal par1="哇哈哈" par2="我曹" par3="你爸爸" /><#-- 调用 -->
		
		<br/>

		
		==============================================================nested 语法：<br/>
		<#macro testnested par>
			取值：${par}<br/> <#-- 公共部分 java -->
			<#nested par,"我是 newsted 参数"><br/><#-- 参数为 2个   一个是传递的  一个是 默认的 -->	
		</#macro>
		
		调用：<br/>
		<@testnested par="hello java";loopv1 , loopv2 > <#-- 后面的 loop参数   有两个 newsted 参数 调用两个的方式 -->
			<span style="color:red">
				取值：${loopv1}，${loopv2}
			</span>
		</@testnested>
		
		<br/>
		<@testnested par="hello nodeJS";loopv1 >  <#-- 调用一个的参数  -->
				取值：${loopv1}
		</@testnested>
		
		<br/>
		==============================================================function语法：<br/>
		<#function tow_Add_count par1 par2><#-- 声明函数 -->
			<#return par1 + par2>
		</#function>
		${tow_Add_count(100,200)} <#-- 调用 -->
		
</html>