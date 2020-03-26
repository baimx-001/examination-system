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
                    <form class="form-horizontal" role="form" action="/subject/submitSubject" id="editfrom" method="post">
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">题目</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="title" placeholder="请输入题目内容">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">选项A</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="optionA" placeholder="请输入选项内容">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">选项B</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="optionB" placeholder="请输入选项内容">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">选项C</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="optionC" placeholder="请输入选项内容">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">选项D</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="optionD" placeholder="请输入选项内容">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">正确答案</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="rightOption" placeholder="请输入正确选项">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">分值</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" name="score" placeholder="请输入分值">
                            </div>
                        </div>
                        <%--<div class="form-group" style="text-align: center;text-decoration-color: red">--%>
                            <%--<span>${message}</span>--%>
                        <%--</div>--%>
                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-default" type="submit">提交</button>
                            <button class="btn btn-default" type="reset">重置</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container" id="footer">
    <div class="row">
        <div class="col-md-12"></div>
    </div>
</div>
</body>
</html>