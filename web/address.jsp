<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/6
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<script src="js/jquery.min.js"></script>
    <script>
        //页面加载完成
             $(function () {
              //异步选择城市
                 $.getJSON("CountryServlet",function (data) {
                    var str ="";
                     for (var i = 0; i <data.length ; i++) {
                         str+="<option value='"+data[i].id+"'>"+data[i].name+"</option>"
                     }
                     $("#countrySel").html($("#countrySel").html()+str);
                 })
                 $("#countrySel").change(function () {
                     var countrySelId=$("#countrySel").val();
                     $.getJSON("CityServlet",{"countrySelId":countrySelId},function (data) {
                       if (data.length>0){
                           var str="";
                           for (var i = 0; i <data.length ; i++) {
                               str+="<option value='"+data[i].id+"'>"+data[i].name+"</option>"
                           }
                           $("#citySel").html(str);
                       }else{
                           $("#citySel").html("<option value='0'>-未选择-</option>")
                       }
                     })
                 })
             })
    </script>
</head>
<body>
国家<select name="countrySel" id="countrySel">
    <option value="0">-未选择-</option>
</select>
城市<select name="citySel" id="citySel">
    <option value="0">-未选择-</option>
</select>
</body>
</html>
