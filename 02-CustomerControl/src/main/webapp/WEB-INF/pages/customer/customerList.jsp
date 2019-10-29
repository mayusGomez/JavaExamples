<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es_CO"/>

<section id="customers">
    <div class="container">
        <div class=""row>
            <div class="col-md-9">
                <div class="card-header">
                    <h4>Customer List</h4>
                </div>
                <table class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Balance</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="customer" items="${customers}">
                            <tr>
                                <td>${customer.idCustomer}</td>
                                <td>${customer.name} ${customer.lastname}</td>
                                <td> <fmt:formatNumber value="${customer.balance}" type="currency"/> </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/ServletControler?action=edit&idCustomer=${customer.idCustomer}"
                                       class="btn btn-secondary">
                                        <i class="fas fa-angle-double-right"></i> Edit
                                    </a>
                                </td>
                                    
                                <!-- ${customer.email} ${customer.phone} -->
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>                
        </div>
    </div>
</section>


