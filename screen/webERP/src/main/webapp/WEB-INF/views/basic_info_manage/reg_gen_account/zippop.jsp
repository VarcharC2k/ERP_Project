<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    
    

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
<form name="popForm" method="get" action="${contextPath }/member/regbasicacc" >
    <div id="wrap">
        <div id="searchBox">
            <table id="search">
                <tr>
                    <td>검색1</td>
                    <td><input type="text" id="code" /></td>
                </tr>
                <tr>
                    <td>검색2</td>
                    <td><input type="text" id="name"/></td>
                </tr>
            </table>
            <div id="button">
                <button id="submit">적용</button>
                <button id="close">닫기</button>
            </div>
        </div>
        <div id="view">
            <table style="width: 100%;">
                <tr align="center">
                    <td>우편번호</td>
                    <td>도로명주소</td>
                    <td>로트주소</td>
                </tr>
   <c:forEach var="zip" items="${ZipView}" >     
	   <tr align="center">
	      <td><a href="javascript:popFunction('${zip.zipCode }','${zip.road_Address }')">${zip.zipCode }</a></td>
	      <td><a href="javascript:popFunction('${zip.zipCode }','${zip.road_Address }')">${zip.road_Address }</a></td>
	      <td><a href="#">${com.general_Customer_Division }</a></td>
	   </tr>
    </c:forEach> 
            </table>
        </div>
    </div>
    <script>
	    var submit_button = document.getElementById("submit");
	    var close_button = document.getElementById("close");
	    
		var text_code = document.getElementById("code");
		var text_name = document.getElementById("name");
    
    	function popFunction(code,name){
    			text_code.value = code;
    			text_name.value = name;
    	}
    	
    	submit_button.onclick = function() { //적용버튼에 온클릭이벤트 부여함 (팝업창)
    		$(opener.document).find("#zipCode").val($("#code").val()); //#zipCode는 body.jsp의 텍스트박스임, #code는 팝업.jsp의 텍스트박스임
    		$(opener.document).find("#workplace_Address").val($("#name").val());
    		window.close();
    	}
	
  
    	close_button.onclick = function(){
    		window.close();
    	}
		
    	
    	
    </script>
    </form>
    
</body>
</html>