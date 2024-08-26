

const usuario = localStorage.getItem('usuario');
const UsuarioGuardado = JSON.parse(usuario)
let Todo_Artistas;
let generosMusicales;
const obtenergenerosMusicales = async () => {
    let url = `http://localhost:8080/generos/musicales/todos`
    const resultado = await fetch(url, {
        method: 'GET',
        
    })

    const generos = await resultado.json();
    generosMusicales = generos;
    console.log(generosMusicales)
    generarGeneros();
    console.log(generos)
}
obtenergenerosMusicales();
const obtenerAristas = async () => {
    let url = `http://localhost:8080/Artistas/todos`;
    try {
        const resultado = await fetch(url, {
            method: 'GET', // No se necesita el cuerpo en una solicitud GET
        });

        // Verificar si la respuesta fue exitosa
        if (!resultado.ok) {
            throw new Error('Error en la solicitud: ' + resultado.statusText);
        }

        const artistas = await resultado.json();
        Todo_Artistas = artistas;
        console.log(Todo_Artistas);
        console.log(UsuarioGuardado.codigo_usuario)
        generarArtistas(); // Llamar a la función para generar los artistas

    } catch (error) {
        console.error('Hubo un problema al obtener los artistas:', error);
    }
};

obtenerAristas();

/*function generarArtistas(){
    
    Todo_Artistas.forEach(artista => {
    document.getElementById('artistas').innerHTML+=` <div class="col-2">
    <div class="card" >
        <img class="card-img-top" src="${artista.foto_perfil}" alt="Card image cap"style="border-radius: 100% !important;">
        <div class="card-body" >
          <h5 class="card-title">${artista.nombre_artistico}</h5>
         
          
        </div>
      </div>
</div>`;


});
}
*/
let artistasSeleccionados = []
function generarArtistas() {
    alert("Seleccione 5 artistas por favor ")
    Todo_Artistas.forEach(artista => {
        const artistaDiv = document.createElement('div');
        artistaDiv.className = 'col-2';
        artistaDiv.innerHTML = `
            <div class="card" data-codigo="${artista.codigo_artista}">
                <img class="card-img-top" src="${artista.foto_perfil}" alt="Card image cap" style="border-radius: 100% !important;">
                <div class="card-body">
                    <h5 class="card-title">${artista.nombre_artistico}</h5>
                </div>
            </div>
        `;
        
        // Añadir evento de clic
        artistaDiv.querySelector('.card').addEventListener('click', () => {
            const codigoArtista = artista.codigo_artista;
            if (artistasSeleccionados.includes(codigoArtista)) {
                // Si ya está seleccionado, quitarlo
                artistasSeleccionados = artistasSeleccionados.filter(codigo => codigo !== codigoArtista);
                artistaDiv.querySelector('.card').classList.remove('seleccionado');
            } else {
                // Si no está seleccionado, añadirlo
                artistasSeleccionados.push(codigoArtista);
                artistaDiv.querySelector('.card').classList.add('seleccionado');
            }
            console.log(artistasSeleccionados); // Para ver los códigos seleccionados
            if (artistasSeleccionados.length<5) {
                console.log("exija al menos 5 artistas")
                document.getElementById('boton').innerHTML=``;
            }else{
                console.log ("puede continuar")
                document.getElementById('boton').innerHTML=`<div class="container mt-5">
        <button class="btn btn-fucsia" onclick="mandar()">Ir</button>
        </div>`
            }
        });
        
        document.getElementById('artistas').appendChild(artistaDiv);

    });
}
function generarGeneros(){

    generosMusicales.forEach(genero => {
        document.getElementById('generos').innerHTML+=`<div class="genero"> ${genero.nombre_genero} </div>`;
        
    });
}

function obtener(){

    if (artistasSeleccionados.length<15) {
        console.log("exija al menos 5 artistas")
    }else{
        console.log ("puede continuar")
    }
}

const enviarPreferencia = async (preferencia) => {


    try {
        const response = await fetch('http://localhost:8080/preferencias/musicales/crear', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(preferencia)
        });

        if (response.ok) {
            const data = await response.json();
            console.log('Preferencia guardada:', data);
        } else {
            console.error('Error al guardar la preferencia');
        }
    } catch (error) {
        console.error('Error de red:', error);
    }
};




 function mandar() {
    artistasSeleccionados.forEach(artista => {
        
        const preferencia = {
        fecha_creacion: new Date().toISOString(),
        codigo_usuario: UsuarioGuardado.codigo_usuario,
        codigo_artista: artista
        };
    
        
         enviarPreferencia(preferencia);
    })
    window.location.href = 'index.html';
    
 }