<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es_CO"/>

<section id="customers">
    <div class="container">
        <div class="row">
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
                        <c:forEach var="customer" items="${customers}" varStatus="status">
                            <tr>
                                <!--<td>${customer.idCustomer}</td>-->
                                <td>${status.count}</td>
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
        
            <!-- Total Cards -->
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Total balance</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${totalBalance}" type="currency"/>
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total customers</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalCustomers}
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- add customer (modal) -->
<jsp:include page="/WEB-INF/pages/customer/addCustomer.jsp"/>

