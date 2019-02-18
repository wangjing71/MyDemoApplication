<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/18
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>我是汪京</title>
    <script type="text/javascript">
        function gotos(str){
            alert(str)
        }

        function postStr(){
            var rtn = android.openKefu();
            document.getElementById("text2").value=rtn;
        }
    </script>
  </head>
  <body>
  我是汪京1</br></br>
  <button type="button" onclick="gotos('我是网页的参数')">这是网页的按钮</button></br></br>

  <button type="button" onclick="postStr()">调用安卓原生的方法弹出一个Toast</button></br></br>

  <input type="text" id="text2" value="返回值"/></p>
  </body>
</html>
