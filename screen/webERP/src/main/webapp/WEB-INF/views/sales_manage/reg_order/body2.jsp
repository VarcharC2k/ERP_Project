<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%> 
<%
	String inputNo = (String)request.getAttribute("inputNo");
	
%>
<% String parent = request.getParameter("custCode");%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:forEach var="cust" items="${orderList}"> 
	<c:set var="code" value="${cust.ordCode}"/>
</c:forEach>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        #contents2{
            position: absolute;
            right: 0;
            top: 25%;
            width: 85%;
            height: 35%;
            border: 1px solid black;
            z-index: 1;
        }
        #contents3{
            position: absolute;
            right: 0;
            top:60%;
            width: 85%;
            height: 35%;
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
        <container2 id="contents2">
           <table id="view">
                <thead>
                    <td><input type="checkbox" id="check" name="content" onclick="selectAll(this)"/></td>
                    <td>주문번호</td>
                    <td>주문일자</td>
                    <td>고객</td>
                    <td>과세구분</td>
                    <td>비고</td>
                </thead>
                <c:forEach var="cust" items="${orderList}"> 
                <tbody>
                    <td><input type="checkbox" value= "${cust.ordCode}" id="check" name="content"/></td>
                    <td><input type="text" name="ListOrd[${status.index}].ordCode" value="${cust.ordCode}"readonly/></td>
                    <td><input type="date" value="${cust.ordDate}"readonly/></td>
                    <td><input type="text" value="${cust.custName}"readonly/></td>
                    <td><input type="text" value="${cust.tax}"readonly/></td>
                    <td><input type="text" value="${cust.note}"readonly/></td>
                </tbody>
                </c:forEach>
                <tbody>
                    <td><input type="checkbox" value = "check1" id="check" name="content"/></td>
                    <td><input type="text" name="ListOrd[${fn:length(orderList)}].ordCode" value="${ordCode}"readonly/></td>
                    <td><input type="date" value="${ordDate}"readonly/></td>
                    <td><input type="text" value="${custCode}"readonly/></td>
                    <td><input type="text" value="${tax}"readonly/></td>
                    <td><input type="text" value="${note}"readonly/></td>
                </tbody>
           </table>
        </container2>
        <container3 id="contents3">
            <table id="view">
                <thead>
                    <td style="width: 5%;"><input type="checkbox" name="content1" onclick="selectAll1(this)"></td>
                    <td>품번</td>
                    <td>품명</td>
                    <td>규격</td>
                    <td>단위</td>
                    <td>납기일</td>
                    <td>주문수량</td>
                    <td>단가</td>
                    <td>공급가</td>
                    <td>부가세</td>
                    <td>합계액</td>
                    <td>검사</td>
                </thead>
                   <c:forEach var="cust" items="${orderList}"> 
                <tbody>
                    <td><input type="checkbox" value = "check1" id="check" name="content"/></td>
                    <td><input type="text" value="${cust.corVO.item_code}" ondblclick="search2()" readonly/></td>
                    <td><input type="text" value="${cust.corVO.item_name}" readonly/></td>
                    <td><input type="text" value="${cust.corVO.stand}" readonly/></td>
                    <td><input type="text" value="${cust.corVO.unit}" readonly/></td>
                    <td><input type="text" value="${cust.corVO.dueDate}" readonly/></td>
                    <td><input type="text" value="${cust.corVO.orderQuant}" readonly/></td>
                    <td><input type="text" value="${cust.corVO.price}" readonly/></td>
                    <td><input type="text" value="${cust.corVO.orderQuant*cust.corVO.price}" readonly/></td>
                    <td><input type="text" value="${(cust.corVO.orderQuant*cust.corVO.price)*0.1}" readonly/></td>
                    <td><input type="text" value="${cust.corVO.orderQuant*cust.corVO.price}" readonly/></td>
                    <td><input type="text" value="${cust.corVO.orderOX}"readonly/></td>
                </tbody>
                </c:forEach>
                <tbody>
                    <td><input type="checkbox" value = "check1" id="check" name="content"/></td>
                    <td><input type="text" value="${corVO.item_code}"readonly/></td>
                    <td><input type="text" value="${corVO.item_name}"readonly/></td>
                    <td><input type="text" value="${corVO.stand}"readonly/></td>
                    <td><input type="text" value="${corVO.unit}"readonly/></td>
                    <td><input type="text" value="${corVO.dueDate}"readonly/></td>
                    <td><input type="text" value="${corVO.orderQuant}"readonly/></td>
                    <td><input type="text" value="${corVO.price}"readonly/></td>
                    <td><input type="text" value="${corVO.orderQuant*corVO.price}"readonly/></td>
                    <td><input type="text" value="${(corVO.orderQuant*corVO.price)*0.1}"readonly/></td>
                    <td><input type="text" value="${corVO.orderQuant*corVO.price}"readonly/></td>
                    <td><input type="text" value="${corVO.orderOX}"readonly/></td>
                </tbody>
            </table>
        </container3>
        <script>
        var item_code = document.getElementById("item_code");
        var item_code = document.getElementById("dataoutput");
        item_code.onfocus = function(){
        	var item_name = document.getElementById("item_code");
        }
        function search5(){
        	openWindowPop('http://localhost:8090/webERP/sales_manage/pop/regorderItem.do','regorderItem');
        }
        </script>
</body>
</html>