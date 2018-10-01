<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="login?action=out">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="bill?action=list">账单管理</a></li>
                <li><a href="supplier?action=list">供应商管理</a></li>
                <li id="active"><a href="user?action=list">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login?action=out">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="user?id=${id}&action=userUpdate" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" placeholder="${user.user_name}"/>
                    <span >*</span>
                </div>

                <div>
                    <label >用户性别：</label>


                    <c:if test="${user.gender eq '男' }">
                        <c:set var="selectMan" value="selected"  scope="page"></c:set>
                    </c:if>
                    <c:if test="${user.gender eq '女' }">
                        <c:set var="selectWM" value="selected"  scope="page"></c:set>
                    </c:if>

                    <select name="gender">
                        <option value="男" ${selectMan}>男</option>
                        <option value="女" ${selectWM}>女</option>
                    </select>
                </div>
                <div>
                    <label for="data">出生日期：</label>
                    <input type="text" name="data" id="data" placeholder="${user.birthday}"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="userphone" id="userphone" placeholder="${user.phone_num}"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="userAddress" id="userAddress" placeholder="${user.address}"/>
                </div>
                <div>
                    <c:if test="${user.post eq '管理员' }">
                        <c:set var="checkAdmin" value="checked"  scope="page"></c:set>
                    </c:if>
                    <c:if test="${user.post eq '经理' }">
                        <c:set var="checkMana" value="checked"  scope="page"></c:set>
                    </c:if>
                    <c:if test="${user.post eq '普通用户' }">
                        <c:set var="checkComm" value="checked"  scope="page"></c:set>
                    </c:if>
                    <label >用户类别：</label>
                    <input type="radio" name="userlei" value="管理员" ${checkAdmin}/>管理员
                    <input type="radio" name="userlei" value="经理" ${checkMana}/>经理
                    <input type="radio" name="userlei" value="普通用户" ${checkComm}/>普通用户

                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.jsp">返回</a>-->
                    <input type="submit" value="保存" />
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>