$(document).ready(function(){	

 var table1 = $('#TraerTurnos').DataTable({
	        "processing": true,
	        "scrollX": true,
	        //Llamamos método del Controlador Reservas y capturamos el JSON
		    "sAjaxSource":"http://localhost/Polideportivo/Reservas/CargarDataTableTurnos",
		    
	        "columns": [{
			                "class":          "details-control",
			                "orderable":      false,
			                "data":           null,			           
			                "defaultContent": "" 
			            },
	                    {"data":"idTurno","defaultContent":"S/D"},	
	                    {"data":"fechaHora","defaultContent":"S/D"},	
	                    {"data":"tipoCancha","defaultContent":"S/D"},	
	                    {"data":"deporte","defaultContent":"S/D"},
	                    {"data":"localidad","defaultContent":"S/D"},
	                    {"data":"idCancha","defaultContent":"S/D"}
	                    ],
	      "order": [[1, 'dsc']]
 	});
	
	 table1.columns.adjust().draw();
	 
	    var detailRows1 = [];
	 
	    $('#TraerTurnos tbody').on( 'click', 'tr td.details-control', function () {

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
	            row1.child( detalleTraerTurnos( row1.data() ) ).show();	 
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
function detalleTraerTurnos(d) {
	var window = "'width=600,height=270'";
	return '<div>' 
	
    +'<a href="http://localhost/Polideportivo/Reservas/CancelarTurno?idTurno='+d.idTurno+'&fechaHora='+d.fechaHora+'">Cancelar Turno</a>'
    + '&nbsp;&nbsp;&nbsp; <a href="http://localhost/Polideportivo/Reservas/modificarTurnovista?idTurno='+d.idTurno+'&idCancha='+d.idCancha+'&filial='+d.idFilial+'" target="_blank" onclick="window.open(this.href,this.target,'+window+'); return false;">Modificar Turno</a>'
	    +'</div>';
}
