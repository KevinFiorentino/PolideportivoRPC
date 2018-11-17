//CAPTURO PARAMETRO GET DESDE EL DATATABLES
function getParameterByName(name) {
	    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	    results = regex.exec(location.search);
	    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}

var filial = getParameterByName('filial');
	

angular.module('app', []).controller('ctrl', function($scope, $http) {
	
	//Llamamos método del Controlador Reservas y capturamos el JSON 
  $http.get("http://localhost/Polideportivo/Reservas/PedirTurno?filial=" + filial).
    then(function(response) {

    $scope.hr = response.data;
    
	var dMant = $scope.hr.data[0].dMantenimiento;		//Día Mantenimiento	
	var hsDesde = $scope.hr.data[0].hsDesde;			//Horario Apertura Filial
	var hsHasta = $scope.hr.data[0].hsHasta;			//Horario Cierre Filial
	
	//Armar Horarios Disponibles Para la Filial
	var hours = [];
	var max = hsHasta.substring(0, 2);
	var min = hsDesde.substring(0, 2);
	while(max >= min) {
		hours.push(min + ":00");
		min++;
	}
	
	
	//********** JQUERY **********

	function mantenimiento(date){ 
		var day = date.getDay();
		return [(day != dMant), ''];  			//Bloquear Día de la Semana en Mantenimiento
	};

	$(function() {
		  $("#datepicker").datetimepicker({
		    timepicker: false,
		    minDate: 0,                       	//Bloquear días anteriores a hoy
		    maxDate: new Date(2018, 9, 31),   	//Calendario hasta la fecha indicada 
		    format:'Y/m/d',
		    beforeShowDay: mantenimiento,
		  
		  });  
	});

	$(function() {
		$("#timepicker").datetimepicker({
		datepicker: false,
		format:'H:i',
		allowTimes: new function horarios() {	//Horario de la Filial
			return hours;
		}

		});  
	});

    });	//FIN HTTP

});