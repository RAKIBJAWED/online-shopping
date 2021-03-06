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
            		<script>
            			window.categoryId='';
            		</script>
            		<ol class="breadcrumb">
            			<li><a href="${contextRoot}/home">Home</a></li>
            			<li class="active">All Products</li>
            		</ol>
            	</c:if>
            	<c:if test="${userClickCategoryProducts==true}">
            		<script>
            			window.categoryId='${category.id}';
            		</script>
            		<ol class="breadcrumb">
            			<li><a href="${contextRoot}/home">Home</a></li>
            			<li class="active">All Products</li>
            			<li class="active">${category.name}</li>
            		</ol>
            	</c:if>
            	
            </div>

          </div>
          <!-- /.row -->
          
          <div class="row">
          	<div class="col-xs-12">
          		<table id="productListTable" class="table table-striped table-bordered">
          			<thead>
          				<tr>
          					<th></th>
          					<th>NAME</th>
          					<th>BRAND</th>
          					<th>PRICE</th>
          					<th>Qty. Available</th>
          					<th></th>
          				</tr>
          			</thead>
          			
          			<tfoot>
          				<tr>
          					<th></th>
          					<th>NAME</th>
          					<th>BRAND</th>
          					<th>PRICE</th>
          					<th>Qty. Available</th>
          					<th></th>
          				</tr>
          			</tfoot>
          		</table>
          	</div>
          </div>
          
        </div>
        <!-- /.col-lg-9 -->

      </div>
      <!-- /.row -->

    </div>
    