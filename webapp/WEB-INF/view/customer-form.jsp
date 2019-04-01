<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Form</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>

    <div id="container">
        <h3>Add New Customer</h3>

        <form:form action="saveCustomer" modelAttribute="customer" method="POST">

            <form:hidden path="id"/>

            <table>
                <tbody>
                <tr>
                    <td><label>First Name</label></td>
                    <td><form:input path="firstName"/></td>
                </tr>

                <tr>
                    <td><label>Last Name</label></td>
                    <td><form:input path="lastName"/></td>
                </tr>

                <tr>
                    <td><label>Email</label></td>
                    <td><form:input path="email"/></td>
                </tr>

                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="add-button"></td>
                </tr>

                <tr>
                    <td><label></label></td>
                    <td><a href="${pageContext.request.contextPath}/customer/list">
                        <input type="button" value="Back to List" class="add-button"></a></td>
                </tr>

                </tbody>
            </table>
        </form:form>
        <div>
        </div>

    </div>
</div>
</body>
</html>
