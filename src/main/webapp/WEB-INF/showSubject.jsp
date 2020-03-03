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
<body id="body">
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
                        <h1 style="text-align: center;">java在线考试系统</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" id="editfrom" method="post">
                        <span id="idspan">
                            <input type="text" class="form-control" id="subjectid"/>
                        </span>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">题目</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="title">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">选项A</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="optionA">
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
                            <label><input type="radio" name="option" value="A">A</label>
                            <label><input type="radio" name="option" value="B">B</label>
                            <label><input type="radio" name="option" value="C">C</label>
                            <label><input type="radio" name="option" value="D">D</label>
                        </div>
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
        $.get("/subject/getSubjectByIdAndType?type=init",function(data,status){
            showSubject(data);
        });
    });
    function showSubject(data){
        //JSON.parse()从一个字符串中解析出json对象
        var data1 = JSON.parse(data);
        $("#idspan").hide();
        $("#subjectid").val(data1.id);
        $("#title").val(data1.title);
        $("#optionA").val(data1.optiona);
        $("#optionB").val(data1.optionb);
        $("#optionC").val(data1.optionc);
        $("#optionD").val(data1.optiond);
    }
    $("#prev").click(function(){
        $.get("/subject/getSubjectByIdAndType?id="+$("#subjectid").val()+"&type=prev&option="+$('input:radio[name="option"]:checked').val(),function(data,status){
            $('input[type=radio][name="option"]:checked').prop("checked", false);
            showSubject(data);
        });
    });
    $("#next").click(function(){
        $.get("/subject/getSubjectByIdAndType?id="+$("#subjectid").val()+"&type=next&option="+$('input:radio[name="option"]:checked').val(),function(data,status){
            $('input[type=radio][name="option"]:checked').prop("checked", false);
            showSubject(data);
        });
    });


    $("#submit").click(function(){
        // $.get("/subject/submitSubjects?id="+$("#subjectid").val()+"&option="+$('input:radio[name="option"]:checked').val(),function (data,status) {
        // });
        $.ajax({
            type : "get",
            url : "/subject/submitSubjects?id="+$("#subjectid").val()+"&option="+$('input:radio[name="option"]:checked').val(),
            dataType : "html",
            data : null,
            async:false,
            success : function(html) {
                $("#body").append(html);
                $("#content").hide();
            }
        });
    });

</script>
</html>