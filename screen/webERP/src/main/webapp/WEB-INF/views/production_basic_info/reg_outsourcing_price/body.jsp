<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"    
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>    
 <c:forEach var="set" items="${setText}" >     
 	<c:set var="itemNumber" value="${set.itemNumber }"/>
 	<c:set var="itemName" value="${set.itemName }"/>
 	<c:set var="standard" value="${set.standard }"/>
 	<c:set var="unit" value="${set.unit }"/>
 	<c:set var="actual" value="${set.actualCost }"/>
 	<c:set var="no" value="${set.no }"/>
 </c:forEach>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
#contents1{
            position: absolute;
            left: 15%;
            top: 15%;
            width: 85%;
            height: 10%;
            border: 1px solid black;
            z-index: 1;
        }
        #contents2{
            position: absolute;
            left: 15%;
            top: 25%;
            width: 85%;
            height: 70%;
            border: 1px solid black;
            z-index: 1;
        }
        .con1_search{
            padding:0;
            text-align: center;
            /* position: absolute; 칸 모잘라서 지움*/
            top: 25%;
            left: 5%;
        }
        #searchForm {
            height: 100%;
            margin: 20px 20px;
            padding:0;
            text-align: center;
        }
        /* 컨테이너 스타일부 */
        #workOrderInfo {
            overflow: scroll;
            height: 100%;
            width: 100%;
        }
		input{
			text-align: center;
		}
</style>
</head>
<body>
            <form id="searchForm" method="get" commandName = "ListVO">
 <container1 id = contents1>
                <table class="con1_search">
                    <tr>
                        <td>외주처</td>
                        <td style="width: 80px;"><input type="text" name="ListVO[${fn:length(outpriceView) }].parent" value='${param.itemNumber }' id="outcode"style="width: 100%; background-color: yellow;"/></td>
                        <td> <a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></a></td> 
                        <td colspan="2"><input type="text" name="" value='${param.itemName }' disabled style="width: 100%;"/></td>
    
                        <td colspan="4" style="width: 80px;">외주작업장</td>
                        <td style="width: 80px;"><input type="text" value='${param.placeCode }' style="width: 100%; background-color: yellow;"/></td>
                        <td> <a href="javascript:search2()"><i class="fas fa-search" style="color: blue;"></i></a></td>
                        <td><input type="text" name="" disabled/></td>
                        
                    </tr>
                    
                    <tr>
                        <td>품목군</td>
                        <td style="width: 80px;"><input type="text"  style="width: 100%;"/></td>
                        <td>  <a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></a></td>
                        <td><input type="text" name="" disabled/></td>
    
                        <td colspan="5" style="width: 80px;">사원</td>
                        <td style="width: 80px;"><input type="text" style="width: 100%; background-color: yellow;"/></td>
                        <td > <a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></a></td>
                        <td><input type="text" name="" disabled/></td>

                        <td>
                            <input type="button" value="품목전개" style="padding: 5px; margin-left: 30px;"></input>
                        </td>
                        <td>
                            <input type="button" value="품목복사" style="padding: 5px;"></input>
                        </td>
                    </tr>
                </table>
            
        </container1>
        <container2 id= contents2>
            <div id="workOrderInfo">
                <table id="workOrderTable">
                    <thead align="center">
                        <td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                        <td>품번</td>
                        <td>품명</td>
                        <td>규격</td>
                        <td>단위</td>
                        <td>원가</td>
                        <td>외주단가</td>
                        <td>시작일</td>
                        <td>종료일</td>
                    </thead>
                    <!-- 테스트용 데이터, 추후 표현식으로 수정필요 -->
                    <c:forEach var="out" items='${outpriceView }' varStatus="status">
                    <tbody>
                        <td><input type="checkbox" value = "check1" id="check" name="content"/></td>
                        <td><input type="text" name="ListVO[${status.index}].outsourcing_Code" value='${out.outsourcing_Code }'/></td>
                        <td><input type="text" name="ListVO[${status.index}].outcustomer" value='${out.outcustomer }' ondblclick="search3()"/></td>
                        <td><input type="text" name="ListVO[${status.index}].item_code" value='${out.item_code }'/></td>
                        <td><input type="text" name="ListVO[${status.index}].cost" value='${out.cost }'/></td>
                        <td><input type="text" name="ListVO[${status.index}].outprice" value='${out.outprice }'/></td>
                        <td><input type="text" name="ListVO[${status.index}].startDate" value='${out.startDate }'/></td>
                        <td><input type="date" name="ListVO[${status.index}].endDate" value='${out.endDate }'/></td>
                    </tbody>
                    </c:forEach>
                    <tbody>
                        <td><input type="checkbox" value = "check1" id="check" name="content"/></td>
                        <td><input type="text" id="itemNumber" name="ListVO[${fn:length(outpriceView) }].outsourcing_Code" value='${itemNumber} '/></td>
                        <td><input type="text" id="itemName" name="ListVO[${fn:length(outpriceView) }].outcustomer" ondblclick="search3()" value='${itemName }'/></td>
                        <td><input type="text" id="standard" name="ListVO[${fn:length(outpriceView) }].item_code" value='${standard }' /></td>
                        <td><input type="text" id="unit" name="ListVO[${fn:length(outpriceView) }].cost" value='${unit }'/></td>
                        <td><input type="text" id="actual" name="ListVO[${fn:length(outpriceView) }].outprice" value='${actual }'/></td>
                        <td><input type="text" id="start" name="ListVO[${fn:length(outpriceView) }].startDate"/></td>
                        <td><input type="date" id="end" name="ListVO[${fn:length(outpriceView) }].endDate"/></td>
                    </tbody>
                </table>
            </div>
            </form>
        </container2>
        <script>
        var save_button = document.getElementById('save');
        var update_button = document.getElementById('update');
      function openWindowPop(url, name){
          var options = 'top=0, left=0, width=320, height=420, status=no, menubar=no, toolbar=no, resizable=no';
          window.open(url, name, options);
      }
      
      function search1(){
    	      	openWindowPop('http://localhost:8090/webERP/member/outsourcingPop.do?div=1','codehelper');
      }
      function search2(){
    	  var outcode = document.getElementById('outcode');
    	      	openWindowPop('http://localhost:8090/webERP/member/outsourcingPop.do?div=2&&itemNumber='+outcode.value,'codehelper1');
      }
	  function search3(){
		  openWindowPop('http://localhost:8090/webERP/member/outpricehelper.do','codehelper2');
	  }
		function setChildValue(name){
    	  
    	  const URLSearch = new URLSearchParams(location.search);
		  URLSearch.set('submit', '2');
		  const newParam = URLSearch.toString();
        if(URLSearch.get('itemCode') == null){
		window.location.href = location.pathname +'?'+newParam + '&itemCode=' + name;
        }
        else{
        	URLSearch.set('itemCode', name);
        	const newParam = URLSearch.toString();
        	window.location.href = location.pathname +'?'+newParam;
        }
        
    }
		save_button.onclick = function(){
			const URLSearch = new URLSearchParams(location.search);
			  URLSearch.set('submit', '1');
			  const newParam = URLSearch.toString();
			 var link = location.pathname +'?'+newParam;
	  			var articleNOInput = document.createElement("input");
	  		     articleNOInput.setAttribute("type","hidden");
	  		     articleNOInput.setAttribute("name","path");
	  		     articleNOInput.setAttribute("value", link);
	  		     document.getElementById('searchForm').appendChild(articleNOInput);
	            document.getElementById('searchForm').action = "${contextPath}/member/addoutprice.do";
	  			document.getElementById('searchForm').submit();  
		}
		update_button.onclick = function(){
			document.getElementById("itemNumber").disabled = true;
 		     document.getElementById("itemName").disabled = true;
 		     document.getElementById("standard").disabled = true;
 		     document.getElementById("unit").disabled = true;
 		     document.getElementById("actual").disabled = true;
 		     document.getElementById("start").disabled = true;
 		     document.getElementById("end").disabled = true;
 		    const URLSearch = new URLSearchParams(location.search);
			  URLSearch.set('submit', '1');
			  const newParam = URLSearch.toString();
			 var link = location.pathname +'?'+newParam;
	  			var articleNOInput = document.createElement("input");
	  		     articleNOInput.setAttribute("type","hidden");
	  		     articleNOInput.setAttribute("name","path");
	  		     articleNOInput.setAttribute("value", link);
	  		     document.getElementById('searchForm').appendChild(articleNOInput);
	            document.getElementById('searchForm').action = "${contextPath}/member/updoutprice.do";
	  			document.getElementById('searchForm').submit();  
		}
      </script>
      
</body>
</html>