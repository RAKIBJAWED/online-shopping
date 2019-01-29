<div class="container">

      <div class="row">

        <div class="col-lg-3">

			<%@include file="./shared/sidebar.jsp"%>

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

          <div class="row">

            <div class="col-lg-12">
            	<c:if test="${userClickAllProducts==true}">
            		<ol class="breadcrumb">
            			<li><a href="${contextRoot}/home">Home</a></li>
            			<li class="active">All Products</li>
            		</ol>
            	</c:if>
            	<c:if test="${userClickCategoryProducts==true}">
            		<ol class="breadcrumb">
            			<li><a href="${contextRoot}/home">Home</a></li>
            			<li class="active">All Products</li>
            			<li class="active">${category.name}</li>
            		</ol>
            	</c:if>
            	
            </div>

          </div>
          <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

      </div>
      <!-- /.row -->

    </div>
    