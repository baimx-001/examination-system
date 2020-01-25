<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 顶栏 -->
<jsp:include page="top.jsp"></jsp:include>
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">添加题目信息</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="/subject/showSubject" id="editfrom" method="post">
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">题目</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="title"><span id="score"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">选项A</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="optionA"">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">选项B</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="optionB" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">选项C</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="optionC" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">选项D</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="optionD" >
                            </div>
                        </div>
                        <%--<div class="form-group" style="text-align: center;text-decoration-color: red">--%>
                            <%--<span>${message}</span>--%>
                        <%--</div>--%>
                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-default" type="button" id="prev">上一题</button>
                            <button class="btn btn-default" type="button" id="submit">提交</button>
                            <button class="btn btn-default" type="button" id="next">下一题</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container" id="footer">
</div>
</body>
<script>
    $(document).ready(function(){
        $.get("/addOne?&type=init",function(data,status){
            $("#title").val(data.title);
            $("#optionA").val(data.optionA);
        });
    });
    $("#prev").click(function(){
        $.get("/addf?id="+$("#id"),function(data,status){
            alert("Data: " + data + "\nStatus: " + status);
        });
    });
    $("#submit").click(function(){

    });
    $("#next").click(function(){
        $.get("/addf?id="+$("#id")+"&type=next",function(data,status){
            alert("Data: " + data + "\nStatus: " + status);
        });
    });
</script>
</html>