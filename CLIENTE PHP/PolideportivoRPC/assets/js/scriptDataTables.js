$(document).ready(function(){	

 var table1 = $('#reservarCanchas').DataTable({
	        "processing": true,
	        "scrollX": true,
	        //Llamamos método del Controlador Reservas y capturamos el JSON
		    "sAjaxSource":"http://localhost/Polideportivo/Reservas/CargarDataTableCanchas",
		    
	        "columns": [{
			                "class":          "details-control",
			                "orderable":      false,
			                "data":           null,			           
			                "defaultContent": "" 
			            },
	                    {"data":"deporte","defaultContent":"S/D"},	
	                    {"data":"tipoCancha","defaultContent":"S/D"},
	                    {"data":"localidad","defaultContent":"S/D"}
	                    ],
	      "order": [[1, 'dsc']]
 	});
	
	 table1.columns.adjust().draw();
	 
	    var detailRows1 = [];
	 
	    $('#reservarCanchas tbody').on( 'click', 'tr td.details-control', function () {

	        var tr1 = $(this).closest('tr');
	        var row1 = table1.row( tr1 );
	        var idx1 = $.inArray( tr1.attr('id'), detailRows1 );
	 
	        if ( row1.child.isShown() ) {
	            tr1.removeClass( 'details' );
	            row1.child.hide();
	            detailRows1.splice( idx1, 1 );
	        }
	        else {
	            tr1.addClass( 'details' );
	            row1.child( detalleReservarCanchas( row1.data() ) ).show();	 
	            if ( idx1 === -1 ) {
	                detailRows1.push( tr1.attr('id') );
	            }
	        }
	    });
	    
	    table1.on( 'draw', function () {
	        $.each( detailRows1, function ( i, id ) {
	            $('#'+id+' td.details-control').trigger( 'click' );
	        } );
	    } );   
} );

//ENVIA AL UNA VARIABLE POR GET QUE ES CAPTURADA EN /scriptDateTimePicker.js, la variable idCancha es para dar de alta los Turnos
function detalleReservarCanchas(d) {
	var window = "'width=600,height=270'";
	return '<div>' 

	    +'<a href="http://localhost/Polideportivo/Reservas/Turnos?filial='+d.idFilial+'&cancha='+d.idCancha+'" target="_blank" onclick="window.open(this.href,this.target,'+window+'); return false;">Reservar Esta Cancha</a>'

	    +'</div>';
}
