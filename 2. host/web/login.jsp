<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/8/4
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>

<html >
<head>
    <title> �û���¼ </title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap-3.3.7-distcss/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap-3.3.7-distcsscss/recordSearchResult.css">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery�ļ��������bootstrap.min.js ֮ǰ���� -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <!-- ���µ� Bootstrap ���� JavaScript �ļ� -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/bootstrap-3.3.7-distcssjs/bootstrap-paginator.min.js"></script>
</head>
<body>
<br>
<br>
<h3 class="col-sm-2 control-label" for="formGroupInputLarge">�������û���������:</h3>

<div style="padding: 80px 250px 100px;">

    <form id="login" method="post" action="login" class="bs-example bs-example-form" role="form" >
        <div class="row">
        <div class="col-lg-6">
         <div class="input-group">
            <span class="input-group-addon">�û���</span>
            <input type="text" class="form-control" placeholder="Username" name="username"/>
         </div>
        </div>
        <br>
        <br>
     <div class="col-lg-6">
        <div class="input-group">
            <span class="input-group-addon">�� &nbsp;&nbsp ��</span>
            <input type="password" class="form-control" placeholder="Password" name="pass"/>
        </div>
        </div>
        </div>
        <br>
        <br>

        <!-- ���������ʾ -->
        <label class="col-sm-2 control-label" for="formGroupInputSmall" style="color:red;font-weight:bold">
        <%
       if (request.getAttribute("err") != null)
       {
        out.println(request.getAttribute("err"));
       }
       %>
       </label>
        <br/>
        <br>
        <br>
        <br>
        <button type="submit" class="btn btn-success">��¼</button>
        <a href="login_add.jsp"><button type="button" class="btn btn-primary">ע��</button></a>
       <br/>
    </form>
    </div>
    </body>
</html>
