<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8" />
    <title></title>
</head>
<body>
	<center>FreeMarker模板引擎语法学习</center>
	
	<h2>1.基本变量的取值</h2>
		<#-- 取值 对应   三个不同类型的数值 -->
		取基本的值 ： 字符串 ： ${StringVar}<br/>
		<#-- 注释 -->
		                         长整型：${chang}<br/>
		                          整形：${zheng}<br/>
				布尔类型：${buer?string("true","flase")}<#-- 对于布尔类型的转换 --><br/>
				时间转换：${nowdate?string("yyyy-MM-dd")}<#-- 对于时间的转换  sql.util.date  会自动转义   util.date 得用string 来转换 --><br/>
				空值：${nullzhi!"我是默认的值了"} <#-- 空值的判断     直接在后面 加!   后面可以跟默认值   可以是字符串  也可以是 数字  有值  就不会输出默认值-->
	
	<h2>2.变量的定义 赋值  运算</h2>
		<#assign a = 100 /> <#-- 定义变量 -->
		取值：${a}<br/>  <#-- 直接使用取值运算符合 -->
		运算：${a+1}<br/> <#-- 和el 一样进行在 取值符号进行运算 -->
		对父文本的处理:${fuwenben}<br/><#-- 默认输出html  带红色的 -->
		不想输出父文本：${fuwenben?html}<#-- 使用   ？ html语法-->
		
	<h2>3.逻辑判断 if </h2>
		
		<#assign zhi = 20 /> <#-- 定义一个99 -->
		<#if zhi == 99>      <#-- 进行判断  -->
			<span> 我是 99 </span>   <#-- 为99 打印 -->
		<#else>                    <#-- else 直接一个便签就可以了 -->
			<span> 不是99？？？ </span>
		</#if>
		
		<p> ================= 对于 if  else  elseif </p>
		<#if zhi &gt;99>	<#-- 大于99 -->
			<span>我大于99 </span>
		<#elseif zhi == 99>
			<span> 我 等于 99 </span>
		<#else>
			<span> 我 等小于于 99 </span>
		</#if>
		
		<p> ================= 对集合进行非空判断   </p>
		<#if mylist??>  <#-- ?? 代表判断 这个集合 我存在  不       也可以  直接 使用   ？exists  效果是一样的--> 
			<#list mylist as item>
				${mylist}
			</#list>
		<#else>
			这个集合不存在呦
		</#if>
	
		<p> =================  多条件判断  </p>
		<#assign lang = 'jss' />
		<#if lang =='java' || lang == 'js'>  <#-- 或者   || -->
			<span>我是java</span>
		</#if>
		
		<#if lang == "jss" && lang?length == 3>  <#-- 与 &&  获取字符串的长度--》?length  还是可以使用括号的  -->
			<span>jss 长度 为  3</span>
		</#if>
		
	<h2>4.switch语法  case break default 和java  没差</h2>
		<#assign yufasw = 1000 /><#-- 判断的变量 -->
		<#switch yufasw>    
			<#case 10>      <#-- case 10 -->
				10<br/>
				<#break>    <#-- 要加入break  不加就会顺序输出  不跳出 -->
			<#case 100>
				100<br/>
				<#break>
			<#default>      <#-- 对最后一个输出  默认的值    break  最好加入 -->
 				其他的值
				<#break>
		</#switch>
		
		
		
</body>
</html>