<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8" />
    <title></title>
</head>
<body>
FreeMarker模板引擎
<p>==============================properties文件的取值</p>
<h1>${resource.name}</h1>
<h1>${resource.web}</h1>
<h1>${resource.language}</h1>
<p>==============================list取值</p>
<#list listuser as item>

	${item.userId}<br/>
	${item.userName}<br/>
	${item.userPassworld}<br/>
	${item.userEmail}<br/>
	<p>========================</p>
	
</#list>
</body>
</html>