<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pl">
<body>
<p>Time: ${time}</p>
<p>Total books: ${listing.count}</p>
<p style="color:magenta">${result}</p>



<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Author</th>
    </tr>
    </thead>
    <tbody>
    <form action="books" method="post">
        <input type="text" name="id" />
        <input type="text" name="name" />
        <input type="text" name="author" />
        <input type="submit" name="ADD" value="ADD">
    </form>
    <c:forEach items="${listing.books}" var="book">
        <tr>
            <td><c:out value="${book.id}"/></td>
            <td><c:out value="${book.name}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><a href="/books/delete/${book.id}" onclick="return confirm('Are you sure to delete this book?')">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>