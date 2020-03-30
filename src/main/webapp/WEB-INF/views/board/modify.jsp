<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../includes/header.jsp"%>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시글 등록</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                    
                        <div class="panel-heading">게시글 등록하기</div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
                        
                        
                        <!-- POST방식으로 처리하는 부분 -->
                        <form role="form" action="/board/modify" method="post">
                        
                        <div class="form-group">
                        		<label>번호</label> 
                        		<input class="form-control" name='bno'
                        		value='<c:out value="${board.bno }"/>' readonly="readonly">
                        	</div>
                        	
                        	<div class="form-group">
                        		<label>제목</label> 
                        		<input class="form-control" name='title'
                        		value='<c:out value="${board.title }"/>'>
                        	</div>
                        	
                        	<div class="form-group">
                        		<label>내용</label> 
                        		<textarea class="form-control" row="3" name='content'> 
                        		<c:out value="${board.content }"/></textarea>
                        	</div>
                        	
                        	<div class="form-group">
                        		<label>작성자</label>
                        		<input class="form-control" name='writer'
                        		value='<c:out value="${board.writer }"/>' readonly="readonly">
                        	</div>
                        	
                        	<div class="form-group">
                        		<label>작성일자</label>
                        		<input class="form-control" name='regDate'
                        		value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate }"/>' 
                        		readonly="readonly">
                        	</div>
                        	
                        	<div class="form-group">
                        		<label>업데이트 일자</label>
                        		<input class="form-control" name='updateDate'
                        		value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate }"/>' 
                        		readonly="readonly">
                        	</div>         
                        	
                        	<button type="submit" data-oper='modify' class="btn btn-default">
                        	수정</button>
                        	
                        	<button type="submit" data-oper='remove' class="btn btn-danger">
                        	제거</button>
                        	
                        	<button type="submit" data-oper='list' class="btn btn-info">
                        	리스트</button>	
                        </form>
                        	
                        	
                        
                        </div>
                        <!-- end panel-body -->
                        
                        </div>
                        <!-- end panel-body -->
                        </div>
                        <!-- end panel -->
                        </div>
                        
                        <!-- /.row -->
                        
                        <script type="text/javascript">
                        	$(document).ready(
                        			function(){
                        		
                        		var formOjb = $("form");
                        		
                        		$('button').on("click", function(e){
                        			e.preventDefault();
                        			
                        			var operation = $(this).data("oper");
                        			
                        			console.log(operation);
                        			
                        			if(operation === 'remove'){
                        				formObj.attr("action", "/board/remove");
                        				}else if(operation === 'list'){
                        					formOjb.attr("action", "/board/list").attr("method", "get");
                        					formOjb.empty();
                        				}
                        			formOjb.submit();
                        		});
                        	});
                        </script>
                        
<%@include file="../includes/footer.jsp" %>