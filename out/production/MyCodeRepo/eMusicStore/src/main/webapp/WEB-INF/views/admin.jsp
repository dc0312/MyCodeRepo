<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator Page</h1>

            <p class="lead">This is the administrator page.</p>
        </div>

        <h3>
            <a href="<c:url value="/admin/productInventory"/>">Product Inventroy</a>
        </h3>

        <p>
            Here you can check and modify the product inventory.
        </p>



<%@include file="/WEB-INF/views/template/footer.jsp" %>
