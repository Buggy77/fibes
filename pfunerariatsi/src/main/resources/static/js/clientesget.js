$(document).ready(function() {
	var _ctx = $("meta[name='ctx']").attr("content");
	
	$('#cp').blur(function(e){
		cp = $('#cp').val().replace(/ /g,'');
		//alert('Valor: ' + cp)
		//obtenColoniasDir(cp);
		obtdireccion();
	});
	
	$("form").submit(function() { 
        var cp =  $('#cp').val();
        if (cp == '')
        	$('#cp').val('0');
    });
	
	/*
	$("#cp").validate({
		  rules: {
		    amount: {
		      required: true,
		      digits: true
		    }
		  }
		});
	*/
	/*
	$('#nombre').blur(function(e){
		var global = [[${editMode}]];
		console.log('Dato de editMode: ' + dato);
	});
	*/
	
	$('#asentamientos').on('click', function(e){
		var selected = $("#asentamientos option:selected");
		//alert('Valor di: ' + selected.val());
		$('#idRegAsentaS').val(selected.val());
		$('#descAsentaS').val(selected.attr('descasenta'));
		$('#idRegTipoS').val(selected.attr('idtipo'));
		//var idRegTipoSL = $('#idRegTipoS').val();
		//alert('Valor de la variable: ' + idRegTipoSL);
		//cp = $('#cp').val().replace(/ /g,'');
		//alert('Valor: ' + cp)
		//obtenColoniasDir(cp);
		//obtdireccion();
	});
	/*
	$('#cp').on('input',function(e){
		if($('#cp').val().replace(/ /g,'').length<=5){
			cp = $('#cp').val().replace(/ /g,'');
			cp = pad(cp, 5);
			alert('Cambio! '+ cp);
		}
		//LLAMADO A FUNCIÓN DE AJAX
		//obtenColoniasDir(cp);
	});
	 */
		
	
	function obtdireccion(){
		var cp = $('#cp').val()
		var f = 0;
		//var dataResp;
		$.ajax({
			url : urldirecciones = _ctx + "/obtDireccionesB",
			type : "get",
			data : { 'cp': cp },
			success: function(response){
				//$('#idRegAsentaS').empty();
				//$('#idRegAsentaS').append($('<option>', {
				$('#asentamientos').empty();
				$('#asentamientos').append($('<option>', {
					value: 'NINGUNO',
					text: '-----Seleccionar-----'
						,
					descasenta: '',
					idtipo: ''
				}));
				//console.log(response.length);
				
				if(response.length == 0)
					{
						$('#idRegMnpioS').val('');
						$('#descMnpio').val('');
						$('#idRegEstadoS').val('');
						$('#descEstado').val('');
					}
					
				for (fila in response){
					if(f == 0){
						$('#idRegMnpioS').val(response[fila].idRegMnpioS);
						$('#descMnpio').val(response[fila].descMnpio);
						$('#idRegEstadoS').val(response[fila].idRegEstadoS);
						$('#descEstado').val(response[fila].descEstado);
						f=1;
					}
					//$('#idRegAsentaS').append($('<option>', {
					$('#asentamientos').append($('<option>', {
						value: response[fila].idRegAsentaS,
						text: response[fila].descAsentaS + '/' + response[fila].descAsentamiento
						,
						descasenta: response[fila].descAsentaS,
						idtipo: response[fila].idRegTipoS
					}));
				}
			},
			error: function (e) {
				//alert('Error!!!')
			}
		
			
		});
	}
	
	function pad (str, max) {
	  str = str.toString();
	  return str.length < max ? pad("0" + str, max) : str;
	}
	
	function obtenColoniasDir(strcp){
		var urldirecciones = _ctx + "/obtDirecciones";
		alert('Valor de urldirecciones: ' + urldirecciones);
		//$("#colonia").load(urldirecciones,strcp);
		$('#idRegAsentaS').load(urldirecciones,$('#cp').serialize());
	}
	
	function obtenColonias(strcp){
		alert("Entra");
		//var cp=$(#cp).on('input',function(e)){
			
		//}
		$.ajax({
			url: getContextPath() + "/getAsentamientosxcp",
			type: "get",
			success: function(response) {
				$('#colonia').empty();
				$('#colonia').append($('<option>', {
				    value: 'NINGUNO',
				    text:  '-----Seleccionar-----'
				}));
				for (item in response) {
					$('#colonia').append($('<option>', {
					    value: response[item].indRegAsentaS,
					    text:  response[item].descAsentaS
					}));
				}
			},
			error: function(e){
				//TODO: colocar la etiqueta para mandar error
				alert('Error en la recuperación de los asentamientos');
			}
		});
	}
	
	//**************************************************************
	//VALIDACIONES FORM BENEF
	/*
	$('#validaform').on('click', function(e){
		validaForm();
	});
	
	$('#beneficiariosTitular2\\.registrar1').change(function(){
		var value = $(this).prop("checked") ? 'true' : 'false';                     
	    console.log(value);
	});
	
	function validaForm(){
		$('#beneficiarioForm').find(':checkbox').each(function() {
			var elementoCheck = this;
			console.log('Valor de id check: ' + elementoCheck.id);
			console.log('Valor de nombre check: ' + elementoCheck.name);
			
			
			//if($("#beneficiariosTitular2\\.registrar1").is(':checked')){
			//	console.log('SELECCIONADO 1');
			//}
			if($("#beneficiariosTitular2\\.registrar1").prop("checked")){
				console.log('SELECCIONADO 2');
			}
			if($("checkbox[id='beneficiariosTitular2.registrar1']").prop('checked')){
				console.log('SELECCIONADO');
			}
			if($("checkbox[name='beneficiariosTitular[2].registrar']").prop('checked')){
				console.log('SELECCIONADO');
			}
			if($("#beneficiariosTitular\\[2\\]\\.registrar").is(':checked')){
				console.log('SELECCIONADO');
			}
			//if(('#beneficiariosTitular2\\.registrar1').prop('checked')){
			//	console.log('SELECCIONADO');
			//}
			//if($('#'+elementoCheck.id).is(':checked')){
			//	console.log('El elemto: ' +elementoCheck.id+ ' con valor: ' + elementoCheck.value + ' esta seleccionado.');
			//}
		});
	}
	*/
	//**************************************************************
	
	//MANEJO FORM CONVENIOS
	$('#estados\\.idRegEstadoS').on('change', function(e){
		console.log('Cambio');
		var selected = $("#estados\\.idRegEstadoS option:selected");

		console.log('Valor select: ' + selected.val());
		valorsel = selected.val();
		
		$.ajax({
			url : urldirecciones = _ctx + "/obtmnpiosestado",
			type : "get",
			data : { 'cvmnpio': valorsel },
			success: function(response){

				$('#municipios\\.idRegMnpioS').empty();
				$('#municipios\\.idRegMnpioS').append($('<option>', {
					value: '',
					text: '-----Seleccionar-----'
				}));
				//console.log(response.length);
				
				//if(response.length == 0)
				//	{
				//	}
					
				for (fila in response){
					$('#municipios\\.idRegMnpioS').append($('<option>', {
						value: response[fila].idRegMnpioS,
						text: response[fila].descMnpio
					}));
				}
			},
			error: function (e) {
				//alert('Error!!!')
			}
		});
		//console.log('Texto select: ' + selected.text())
		//$('#idRegAsentaS').val(selected.val());
		//$('#descAsentaS').val(selected.attr('descasenta'));
		//$('#idRegTipoS').val(selected.attr('idtipo'));
		
		//var idRegTipoSL = $('#idRegTipoS').val();
		//alert('Valor de la variable: ' + idRegTipoSL);
		//cp = $('#cp').val().replace(/ /g,'');
		//alert('Valor: ' + cp)
		//obtenColoniasDir(cp);
		//obtdireccion();
	});
	
})


