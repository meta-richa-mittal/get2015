movieData = {};
	movieData = [{MovieTitle: 'M1', Genre: 'Action', Director: 'director A'},
	             {MovieTitle: 'M2', Genre: 'Cartoon', Director: 'director B'},
				 {MovieTitle: 'M3', Genre: 'Comedy', Director: 'director C'},
				 {MovieTitle: 'M4', Genre: 'Action', Director: 'director D'},
				 {MovieTitle: 'M5', Genre: 'War', Director: 'director E'},
				 {MovieTitle: 'M6', Genre: 'Cartoon', Director: 'director F'},
				 {MovieTitle: 'M7', Genre: 'Thriller', Director: 'director G'},
				 {MovieTitle: 'M8', Genre: 'Fantasy', Director: 'director H'},
				 {MovieTitle: 'M9', Genre: 'Comedy', Director: 'director I'},
				 {MovieTitle: 'M10', Genre: 'Action', Director: 'director J'},
				 {MovieTitle: 'M11', Genre: 'Horror', Director: 'director K'},
				 {MovieTitle: 'M12', Genre: 'Fantasy', Director: 'director L'},
				 {MovieTitle: 'M13', Genre: 'Comedy', Director: 'director M'},
				 {MovieTitle: 'M14', Genre: 'Thriller', Director: 'director N'},
				 {MovieTitle: 'M15', Genre: 'Action', Director: 'director O'},
				 {MovieTitle: 'M16', Genre: 'Horror', Director: 'director P'},
				 {MovieTitle: 'M17', Genre: 'War', Director: 'director Q'},
				 {MovieTitle: 'M18', Genre: 'Fantasy', Director: 'director R'},
				 {MovieTitle: 'M19', Genre: 'Musicals', Director: 'director S'} 
				];
	
	function clear1() {
		$( '#movieTable' ).hide();
		$( 'div#nav' ).hide();
	}

	
	function reviews() {
		addTable();
		paging();
	}
	
	function addTable() {
		var myTable = document.getElementById("movieTable");
		
		while(document.getElementById("movieTable").rows.length > 0) {
			
			document.getElementById("movieTable").deleteRow(0);
			  
			}
		
		$( '#movieTable' ).show();
		
		var table = $('#movieTable');
		
		table.append('<tr><td>' + "Movie Title" + '</td><td>' + 'Genre' + '</td><td>' + 'Director' + '</td></tr>');
		
		for(var i=0;i< movieData.length; i++) {
			table.append('<tr><td>' + movieData[i].MovieTitle + '</td><td>' + movieData[i].Genre + '</td><td>' + movieData[i].Director + '</td></tr>');
		}
	}
	
	function paging(){
	    $('#movieTable').after('<div id="nav" style="float:right"></div>');
	    $( 'div#nav' ).empty();
	    var rowsShown = 5;
	    var rowsTotal = $('#movieTable tbody tr').length;
	    var numPages = rowsTotal/rowsShown;
	    for(i = 0;i < numPages;i++) {
	        var pageNum = i + 1;
	        $('#nav').append('<div style="width:40px;border:2px solid gray;float:left;text-align:center;margin-left:5px;"><a href="#" rel="'+i+'">'+pageNum+'</a><div>');
	    }
	    $('#movieTable tbody tr').hide();
	    $('#movieTable tbody tr').slice(0, rowsShown+1).show();
	    $('#nav a:first').addClass('active');
	    $('#nav a').bind('click', function(){

	        $('#nav a').removeClass('active');
	        $(this).addClass('active');
	        var currPage = $(this).attr('rel');
	        var startItem = (currPage * rowsShown)+1;
	        var endItem = startItem + rowsShown;
	        $('#movieTable tbody tr').css('opacity','0.0').hide().slice(startItem, endItem).
	                css('display','table-row').animate({opacity:1}, 300);
	    });
	}
	
	function search() {
		var myTable = document.getElementById("movieTable");
		
		while(document.getElementById("movieTable").rows.length > 0) {
			
			document.getElementById("movieTable").deleteRow(0);
			  
			}
		var searchId = document.getElementById("srch-term");
		var searchMovie = searchId.value;
		var res = "";
		$( '#movieTable' ).show();
		$( 'div#nav' ).hide();
		
		var table = $('#movieTable');
		flag=0;
		table.append('<tr><td>' + "Movie Title" + '</td><td>' + 'Genre' + '</td><td>' + 'Director' + '</td></tr>');
		for(var i=0;i< movieData.length; i++) {
			if(movieData[i]["MovieTitle"].toLowerCase() == searchMovie.toLowerCase()) {
				table.append('<tr><td>' + movieData[i].MovieTitle + '</td><td>' + movieData[i].Genre + '</td><td>' + movieData[i].Director + '</td></tr>');
				flag=flag+1;
				
			}
		}	
		if(flag==0) {
			table.append('<tr><td colspan="3" style="align: center;">' + "No Movie Found" + '</td></tr>');
		}
	}
	
	function searchForSmall() {
		var myTable = document.getElementById("movieTable");
		
		while(document.getElementById("movieTable").rows.length > 0) {
			
			document.getElementById("movieTable").deleteRow(0);
			  
			}
		var searchId = document.getElementById("srchSmall");
		var searchMovie = searchId.value;
		var res = "";
		$( '#movieTable' ).show();
		$( 'div#nav' ).hide();
		
		var table = $('#movieTable');
		flag=0;
		table.append('<tr><td>' + "Movie Title" + '</td><td>' + 'Genre' + '</td><td>' + 'Director' + '</td></tr>');
		for(var i=0;i< movieData.length; i++) {
			if(movieData[i]["MovieTitle"].toLowerCase() == searchMovie.toLowerCase()) {
				table.append('<tr><td>' + movieData[i].MovieTitle + '</td><td>' + movieData[i].Genre + '</td><td>' + movieData[i].Director + '</td></tr>');
				flag=flag+1;
				
			}
		}	
		if(flag==0) {
			table.append('<tr><td colspan="3" style="align: center;">' + "No Movie Found" + '</td></tr>');
		}
	}