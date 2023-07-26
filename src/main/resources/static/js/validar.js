import { mostrarAlerta } from "./script.js";


let inputs = document.getElementsByClassName("form");

const enviar = document.querySelector(".enviar");
enviar.addEventListener('click', validarPresidente);

function validarPresidente(e) {
	e.preventDefault();


	for (let i = 0; i < inputs.length; i++) {

		if (inputs[i].value == "") {

			mostrarAlerta('Todos los campos son obligatorios');
		}
	}
}

 


