<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#contents1{
            position: absolute;
            padding: 10px;
            right: 0;
            top: 15%;
            width: 85%;
            height: 10%;
            border: 1px solid black;
            z-index: 1;
        }
       
        #view{
            width: 100%;
            text-align: center;
            border: 1px solid black;
        }
        #view td:not(#no){
            width: 8%;
        }
        #view td input{
            width: 100%;
        }
</style>
</head>
<body>
<container1 id = contents1>
            <table class="con1_search">
                <tr>
                    <td>사업장</td>
                    <td><input type="text" name="" id=""></td>
                    <td><i class="fas fa-search" style="color: blue;"></i></td>
                    <td><input type="text" disabled></td>
                    <td>주문기간</td>
                    <td><input type="date"></td>
                    <td>~</td>
                    <td><input type="date"></td>
                </tr>
                <tr>
                    <td colspan="5">거래처 명</td>
                    <td class="codeInput"><input type="text" name="cust" value='${param.custCode}'disabled /></td>
                    <td class="nameInput"><input type="text" name="cust" value='${param.custName}'disabled /></td>
                    <td style="width: 50px;"><a href="javascript:search1()"><i class="fas fa-search"></i></a></td>

                </tr>
            </table>
           </container1>
           	   <script>
                     function search1(){
    	  
        	  openWindowPop('http://localhost:8090/webERP/sales_manage/pop/regorderCust.do','regorderCust');  
    }
    </script>

</body>
</html>