<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
        .con1_search{
            padding:0;
            text-align: center;
            position: absolute;
            top: 25%;
            left: 18%;
        }
        #view1,#view2{
            width: 100%;
            text-align: center;
            border: 1px solid black;
        }
      
        /* ----------------버튼-------------------- */

        #view2 td:not(.ch){
            width: 8%;
            font-size: 15px;
            font-weight: bold;
        }
        #view2 td input{
            width: 100%;
        }
        #view1 td:not(#non){
            width: 14.5%;
        }
        #view1 td input{
            width: 100%;
        }
        #view1 th{
            width: 4%;
        }

        ul.tabs{
            margin: 0px;
            padding: 0px;
            list-style: none;
        }
        ul.tabs li{
            background: none;
            color: black;
            display: inline-block;
            padding: 5px 5px;
            cursor: pointer;
            width: 80px;
            text-align: center;
            font-size: 12px;
        }
        ul.tabs li.current{
            border-top: 2px solid skyblue;			
            background-color: #ddd;        
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
        }
        .tab-content{
            display: none;
        }
        .tab-content.current{
            display: inherit;
        }
</style>
</head>
<body>
<container1 id = contents1>
            <table class="con1_search">
                <tr>
                    <td>사업장</td>
                    <td>
                        <input type="text" style="width:100px;">
                        <i class="fas fa-search" style="color: blue;"></i>
                    </td> 
                    <td>
                        <input type="text" disabled>
                    </td>
					<td style="width:50px;"></td>

                    <td>거래처</td>
                    <td>
                        <input type="text" style="width:100px;">
                        <i class="fas fa-search" style="color: blue;"></i>
                    </td>
                    <td>
                        <input type="text" disabled>
                    </td>
                </tr>
            </table>
            <div>
                <ul class="tabs" style="left:0px; bottom:0px; position: absolute;" >
                    <li class="tab-link current" data-tab="tab-1">창고/장소</li>
                    <li class="tab-link" data-tab="tab-2">생산공정/<br>작업장</li>
                    <li class="tab-link" data-tab="tab-3">외주공정/<br>작업장</li>
                </ul>
            </div>
        </container1>
        <container2 id="contents2">
        <div class="tab-1 tab-content current">     	
            <table id="view1"><!-- 창고/장소 탭1 -->    
                <thead>             
                    <th id="non"><input type="checkbox" name="content" onclick="selectAll(this)" /></th>
                    <th>창고코드</th>
                    <th>창고명</th>
                    <th>입고기본위치</th>
                    <th>출고기본위치</th>
                    <th>창고설명</th>
                    <th>사용여부</th>
                </thead>
                <tbody>
                    <td id="non"><input type="checkbox" value = "check1" id="check" name="content"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><select name="" id="">
                        <option value="1">사용</option>
                        <option value="2">미사용</option>
                    </select></td>
                </tbody>
            </table>
        </div>
        <div class="tab-2 tab-content">
            <table id="view1"><!-- 생산공정/작업장 탭2-->
                <thead>
                    <th id="non"><input type="checkbox" name="content" onclick="selectAll(this)" /></th>
                    <th>생산공정코드</th>
                    <th>생산공정명</th>
                    <th>입고기본위치</th>
                    <th>출고기본위치</th>
                    <th>공정설명</th>
                    <th>사용여부</th>
                </thead>
                <tbody>
                    <td id="non"><input type="checkbox" value = "check1" id="check" name="content"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><select name="" id="">
                        <option value="1">사용</option>
                        <option value="2">미사용</option>
                    </select></td>
                </tbody>
            </table>
        </div>
        <div class="tab-3 tab-content">  
            <table id="view1"><!-- 외주공정/작업장 탭3 -->
                <thead>
                    <th id="non"><input type="checkbox" name="content" onclick="selectAll(this)" /></th>
                    <th>외주공정코드</th>
                    <th>외주공정명</th>
                    <th>입고기본위치</th>
                    <th>출고기본위치</th>
                    <th>외주공정설명</th>
                    <th>사용여부</th>
                </thead>
                <tbody>
                    <td id="non"><input type="checkbox" value = "check1" id="check" name="content"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><select name="" id="">
                        <option value="1">사용</option>
                        <option value="2">미사용</option>
                    </select></td>
                </tbody>
            </table>
        </div>
        </container2>
        <container3 id="contents3">
        <div class="tab-1 tab-content current">
            <table id="view2">
                <tr>
                    <td>위치코드1</td>
                    <td>위치명</td>
                    <td>위치설명</td>
                    <td>사용여부</td>
                </tr>
            </table>
        </div>
        <div class="tab-2 tab-content">
            <table id="view2">
                <tr>
                    <td>작업장코드2</td>
                    <td>작업장명</td>
                    <td>작업장설명</td>
                    <td>사용여부</td>
                </tr>
            </table>
        </div>
        <div class="tab-3 tab-content">
            <table id="view2">
                <tr>
                    <td>작업장코드3</td>
                    <td>작업장명</td>
                    <td>작업장설명</td>
                    <td>사용여부</td>
                </tr>
            </table>
        </div>
        </container3>
        <script src="http://code.jquery.com/jquery-latest.js"></script> <!--제이쿼리최신버젼가져옴-->
    	<script>
        	$(document).ready(function(){
        
        	$('ul.tabs li').click(function(){
            	var tab_id = $(this).attr('data-tab');
    
            	$('ul.tabs li').removeClass('current');
            	$('.tab-content').removeClass('current');
    
            	$(this).addClass('current');
            	$("."+tab_id).addClass('current');
       	 	})
    
    		})
    </script>
</body>
</html>