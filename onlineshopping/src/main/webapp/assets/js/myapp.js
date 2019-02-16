$(function() {	
	
	// solving the active menu problem
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Product Management':
		$('#manageProduct').addClass('active');
		break;
	case 'Shopping Cart':
		$('#userModel').addClass('active');
		break;		
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}
	
	var products=[
		['1','ABC'],
		['2','JHA'],
		['3','HYG'],
		['4','AFG'],
		['5','KJH'],
		['6','XYZ']
	];
	
	var $table =$('#productListTable');
	
	if($table.length){
		//console.log('Inside the table!');
		var jsonUrl='';
		if(categoryId==''){
			jsonUrl=contextRoot+'/json/data/all/products';
		}else{
			jsonUrl=contextRoot+'/json/data/category/'+categoryId+'/products';
		}
		
		
		$table.DataTable({
			lengthMenu: [[3,5,10,-1],['3 Records','5 Records','10 Records','All']],
			pageLength: 5, 
			ajax:{
				url:jsonUrl,
				dataSrc:''
			},
			columns:[
				{
					data:'code',
					bSortable: false,
					mRender: function(data,type,row){
						var imgUrl='<img src="' + window.contextRoot
						+ '/resources/images/' + data
						+ '.jpg" class="dataTableImg"/>';
						return imgUrl;
					}
				},
				{
					data:'name'
				},
				{
					data:'brand'
				},
				{
					data:'price',
					mRender: function(data,type,row){
						return '&#8377;'+data;
					}
				},
				{
					data:'quantity'
				},
				{
					data:'id',
					bSortable: false,
					mRender: function(data,type,row){
						var str='';
						str+='<a href="'+contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160';
						str+='<a href="'+contextRoot+'/show/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						
						return str;
					}
				}
			]
		});
		
	}
	
	//console.log(categoryId+' '+contextRoot);
	
	
	
	
	
});