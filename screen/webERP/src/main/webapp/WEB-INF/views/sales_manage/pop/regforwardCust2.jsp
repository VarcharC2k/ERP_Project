<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>  
<% 
	String custCode = request.getParameter("general_Customer_Code");
%>  
<html>
<head>
<meta charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>거래처 팝업</title>
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
<form name="popForm" method="get">
    <div id="wrap">
        <div id="searchBox">
            <table id="search">
                <tr>
                    <td>고객명</td>
                    <td><input type="text" id="code" /></td>
                </tr>
                <tr>
                    <td>고객 번호</td>
                    <td><input type="text" id="name"/></td>
                </tr>
            </table>
            <div id="button">
                <button id="search">조회</button>
                <button id="submit">적용</button>
                <input type="reset" id="reset" value="초기화"/>
            </div>
        </div>
           <div id="view">
               <table style="width: 100%;">
                   <tr align="center">
                     <td><b>거래처 코드</b></td>
                     <td><b>거래처명</b></td>
                     <td><b>사업자 번호</b></td>
                 </tr>
   
                <c:forEach var="cust" items="${custList}" >
                     <tr align="center">
                        <td><a href="javascript:popFunction('${cust.general_Customer_Code}','${cust.general_Customer_Name}')">${cust.general_Customer_Code}</a></td>
                        <td><a href="javascript:popFunction('${cust.general_Customer_Code}','${cust.general_Customer_Name}')">${cust.general_Customer_Name}</a></td>
                        <td><a href="javascript:popFunction('${cust.general_Customer_Code}','${cust.general_Customer_Name}')">${cust.company_Registration_Number}</a></td>
                  </tr>
                 </c:forEach>   
            </table>
         </div>
      </div>
              <script>
             var submit_button = document.getElementById("submit");
             var text_code = document.getElementById("code");
             var text_name = document.getElementById("name");
                
             function popFunction(code,name){
                text_code.value = code;
                text_name.value = name;
             }
             
   submit_button.onclick = function(){
          var url = window.opener.document.location.href;
         var url_arr = url.split('?');
         opener.parent.location=url_arr[0]+'?'+url_arr[1]+'&custCode='+text_code.value+'&&custName='+text_name.value+'&&submit='+2;
          window.close();
       }
    </script>


   </form>
</body>
</html>