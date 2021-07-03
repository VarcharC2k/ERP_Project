<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
<title>일반거래처 검색창</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <style>
    	a{
    		text-decoration:none;
    	}
        #wrap{
            width: 300px;
            height: 400px;
            border: 1px solid black;
        }
        #searchBox{
            width: 100%;
            height: 23%;
            border: 1px solid black;
        }
        #button{
            margin-top: 3%;
            margin-right: 3%;
            text-align: right;
        }
        #search{
            margin-left: 30px;
        }
        #view{
        	width:100%;
        	height:77%;
        	overflow:scroll;
        }
    </style>
</head>
<body>
<form name="popForm" method="get" action="${contextPath}/member/orderstat" >
    <div id="wrap">
        <div id="searchBox">
            <table id="search">
                <tr>
                    <td>품번</td>
                    <td><input type="text" id="code" /></td>
                </tr>
                <tr>
                    <td>품명</td>
                    <td><input type="text" id="name"/></td>
                </tr>
            </table>
            <div id="button">
                <button id="search">조회</button>
                <button id="submit">적용</button>
                <input type="hidden" name="inputNo" value=""/>
                <input type="reset" id="reset" value="초기화"/>
            </div>
        </div>
        	<div id="view">
            	<table style="width: 100%;">
                	<tr align="center">
      					<td><b>코드</b></td>
      					<td><b>거래처명</b></td>
      					<td><b>사업자번호</b></td>
  					</tr>
   
 					<c:forEach var="cust" items="${orderCustList}" >
   						<tr align="center">
      						<td><a href="javascript:popFunction('${cust.custCode}','${cust.custName}')">${cust.custCode}</a></td>
      						<td><a href="javascript:popFunction('${cust.custCode}','${cust.custName}')">${cust.custName}</a></td>
      						<td><a href="javascript:popFunction('${cust.custCode}','${cust.custName}')">${cust.comNum}</a></td>
						</tr>
  					</c:forEach> 
				</table>
			</div>
		</div>
		<script src="<c:url value="/js/egovframework/mbl/cmm/jquery-1.11.2.min.js" />"></script>
	 <script>
	    var submit_button = document.getElementById("submit");
		var text_code = document.getElementById("code");
		var text_name = document.getElementById("name");
		
	function popFunction(code,name){
			text_code.value = code;
			text_name.value = name;
			
	}
	function submitClick(form){
		opener.setChildValue(text_name.value);
		window.close();
	}
	submit_button.onclick = function(){
		var url = window.opener.do cument.location.href;
		var url_arr = url.split('?');
		opener.parent.location=url_arr[0] + '?custCode='+text_code.value+'&&custName='+text_name.value;
		window.close();
	}
	</script>
	</form>
</body>
</html>
