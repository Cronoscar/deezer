let User =localStorage.getItem('usuario');
const UsuarioGuardado = JSON.parse(User)
let preferenciasporUsuario=[] 
let getCanciones_x_artistas=[];

let clasifcacion= [];
const obtenerPreferencias_por_Usuario = async () => {
    
    let url = `http://localhost:8080/preferencias/musicales/usuario/${UsuarioGuardado.codigo_usuario}`
        const resultado = await fetch(url, {
        method: 'GET'
    })
    
        const preferencias = await resultado.json();

        return preferencias
        preferenciasporUsuario=preferencias
        console.log(preferenciasporUsuario)
        console.log(preferenciasporUsuario[1].artista.codigo_artista)
    
}

obtenerPreferencias_por_Usuario();

const obtenerobtenercanciones = async () => {
    let url = `http://localhost:8080/canciones/todas`
    const resultado = await fetch(url, {
        method: 'GET',
        
    })

    const canciones = await resultado.json();
    return canciones
    todaslascanciones = canciones;
    console.log(canciones)

    //generarCanciones();


}
obtenerobtenercanciones();

const obtenercancionesporArtistas = async () => {
    let url = `http://localhost:8080/artistas/canciones/todas`
    const resultado = await fetch(url, {
        method: 'GET',
        
    })

    const canciones_x_artistas = await resultado.json();
    //todaslascanciones_x_artistas = canciones_x_artistas;
    getCanciones_x_artistas = canciones_x_artistas
    console.log(canciones_x_artistas)
    return canciones_x_artistas



}

obtenercancionesporArtistas();
/* async function clasificar() {
    obtenerPreferencias_por_Usuario();
    obtenerobtenercancionesporArtistas();

      getCanciones_x_artistas.forEach(c_x_a => {
        preferenciasporUsuario.forEach(preferencia => {
            if(c_x_a.codigo_artista ==preferencia.codigo_artista){        
                console.log('encontrado')
            } else{
                console.log('no clasificado')
            } } 
            );
    });
}*/



let todaslascanciones = [];
async function generarCanciones(){
    todaslascanciones=  await filtrarCancionesPorPreferencias();
    todaslascanciones.forEach(cancion=>{
        document.getElementById('contenido').innerHTML +=`
    <div class="col-4">
    <div class="card col-3" onclick="playSong('${cancion.url}')">
    <img src="${cancion.portada}" alt="Music Quiz">
    <h4>${cancion.nombre}</h4>
   
    </div>
    <i class="fas fa-heart" id='${cancion.codigo_cancion}' onclick="cambiarColor(${cancion.codigo_cancion },enviarFavorito(${cancion.codigo_cancion}))" ></i>
    </div>
        `

    })
}
function playSong(songUrl) {

    const audioPlayer = document.getElementById('audio-player');
    audioPlayer.src = "src/"+songUrl;
    audioPlayer.play();
}

 async function filtrarCancionesPorPreferencias () {
    try {
        const preferencias = await obtenerPreferencias_por_Usuario();
        const cancnionesPorArtistas = await obtenercancionesporArtistas()
        const todasCanciones = await obtenerobtenercanciones()       
        console.log("preferencias por usuario", preferencias)
        let cancionesFavoritas=[];
        console.log("aqui")
        preferencias.forEach(preferencia => {
            cancnionesPorArtistas.forEach(cancion_x_artista => {
                //console.log(cancion_x_artista);
              if (preferencia.artista.codigo_artista === cancion_x_artista.artista.codigo_artista) {
                    
                    todasCanciones.forEach(cancion => {
                        if (cancion.codigo_cancion === cancion_x_artista.cancion.codigo_cancion) {
                          cancionesFavoritas.push(cancion);
                        }
                      });
              }
            });
          });
          console.log(cancionesFavoritas)
          return cancionesFavoritas;

        
    } catch (error) {
        console.log(error)
    }
   

    
  
   /* .forEach(preferencia => {
      getCanciones_x_artistas.forEach(cancion_x_artista => {
        if (ppreferenciasporUsuarioreferencia.artista.codigo_artista === cancion_x_artista.codigo_artista) {
          todaslascanciones.forEach(cancion => {
            if (cancion.codigo_cancion === cancion_x_artista.codigo_cancion) {
              cancionesFavoritas.push(cancion);
            }
          });
        }
      });
    });
    console.log(cancionesFavoritas)
    return cancionesFavoritas;
    */
}

function cambiarColor(id) {
    console.log(typeof id)
    const corazon = document.getElementById(`${id}`);
    corazon.classList.toggle('corazon-rojo'); // Cambia la clase al hacer clic
}
const filtrado = filtrarCancionesPorPreferencias();
generarCanciones();
console.log(filtrado)

const enviarFavorito = async (cancion) => {
    console.log(cancion);
   // e.preventDefault(); // Evitar la recarga de la página

    const payload = {
        codigo_usuario: UsuarioGuardado.codigo_usuario,
        codigo_cancion: cancion,
        codigo_album : null
    };

    console.log(payload)

    try {
        const result = await fetch('http://localhost:8080/favoritos/new', {
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(payload),
            method: 'POST'
        });

        const response = await result.json();
        console.log(response)
        if (!response || response.error) {
            alert("Fallo al autenticar");
        } else {
            console.log("Autenticado");
            
            alert("bienvenido")
            
        }
    } catch (error) {
    
    }
};