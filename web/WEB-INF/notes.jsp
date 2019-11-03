<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notes</title>
    </head>
    <body>
        <h1>Notes</h1>
        <table>
            <tr>
                <th>Date Created</th>
                <th>Title</th>
            </tr>

            <c:forEach var="note" items="${notes}">
                <tr>
                    <td width="250">${note.datecreated}</td>
                    <td width="200">${note.title}</td>
                    <td>   
                        <form action="
                              <c:url value='notes'>
                              <c:param name='action' value='show'/>
                              </c:url>" method="post">
                            
                            <input type="hidden" name='id' value="${note.noteid}">
                            <input type="submit" value="edit">
                            
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>


        <c:if test="${view eq false}">

            <form action="<c:url value='notes'>
                      <c:param name='action' value='add'/>
                      </c:url>" method="post">
                
                      <h2>Add Note</h2>
                      
                      <input type="text" name="titleTxt" value="${note.title}" placeholder="title"><br>
                  <textarea name="contentsTxt" rows="20" cols="30" placeholder="type a note..">${note.contents}</textarea><br><br>
                  <input type="submit" value="add">
            </form>
        </c:if>


        <c:if test="${view eq true}">
            <form action="
                  <c:url value='notes'>
                  <c:param name='action' value='delete'/>
                  </c:url>" method="post">

                <input type="hidden" name='id' value="${note.noteid}">
                <input type="submit" value="delete">

            </form>

            <form action="
                  <c:url value='notes'>
                  <c:param name='action' value='save'/>
                  </c:url>" method="post">

                       <h2>Edit Note</h2>
                
                <input type="hidden" name='id' value="${note.noteid}">
                <input type="text" name="titleTxt" value="${note.title}"><br>
                <textarea name="contentsTxt" rows="20" cols="30">${note.contents}</textarea><br>
                <input type="submit" value="save">
            </form>
        </c:if>
    </body>
</html>
