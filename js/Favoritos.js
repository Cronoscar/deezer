let User =localStorage.getItem('usuario');
const UsuarioGuardado = JSON.parse(User)
const obtenerFavoritos_por_Usuario = async () => {
    
    let url = `http://localhost:8080/favoritos/obtener/${UsuarioGuardado.codigo_usuario}`
        const resultado = await fetch(url, {
        method: 'GET'
    })
    
        const Favoritos = await resultado.json();
        console.log(Favoritos)
        return Favoritos
        FavoritosporUsuario=Favoritos
        console.log(FavoritosporUsuario)
        console.log(FavoritosporUsuario[1].artista.codigo_artista)
    
}
obtenerFavoritos_por_Usuario();
const obtenercanciones = async () => {
    let url = `http://localhost:8080/canciones/todas`
    const resultado = await fetch(url, {
        method: 'GET',
        
    })

    const canciones = await resultado.json();
    console.log(canciones)
    return canciones
    todaslascanciones = canciones;
    console.log(canciones)

    //generarCanciones();


}
obtenercanciones();
let Cancionesfavoritas= []
async function filtrarCancionesporfavoritos(){
    const todasCanciones = await obtenercanciones() 
    const todosfavoritoxusuarios = await obtenerFavoritos_por_Usuario()

    todosfavoritoxusuarios.forEach(favorito => {
        todasCanciones.forEach(cancion => {
            if (cancion.codigo_cancion === favorito.cancion.codigo_cancion) {
              Cancionesfavoritas.push(cancion);

            }
          });
    });
    console.log(Cancionesfavoritas)
    return Cancionesfavoritas;
}

async function generarCanciones(){
    todaslascanciones=  await filtrarCancionesporfavoritos();
    todaslascanciones.forEach(cancion=>{
        document.getElementById('contenido').innerHTML +=`
    <div class="card col-3"  onclick="playSong('${cancion.url}')">
                        <img src="${cancion.portada}" alt="viral rewind">
                        <div class="card-buttons">
                            <button><i class="fas fa-play"onclick="playsong('${cancion.url}')"></i></button>
                            <button><i class="fas fa-heart"></i></button>
                            <button><i class="fas fa-ellipsis-h"></i></button>
                        </div>
                        <div class="heading-4"><a class="chakra-link css-1nvflm0" title="viral rewind">Too leng</a></div>
                        <div class="heading-5-sub">${cancion.nombre}</div>
                    </div>`

    }) }
    function playSong(songUrl) {

        const audioPlayer = document.getElementById('audio-player');
        audioPlayer.src = "src/"+songUrl;
        audioPlayer.play();
    }
    generarCanciones();
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
    const obtenerAristasx = async () => {
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
            return artistas
            //generarArtistas(); // Llamar a la función para generar los artistas
    
        } catch (error) {
            console.error('Hubo un problema al obtener los artistas:', error);
        }
    };
    let artistasfav=[]
    let preferencias =[]
    let artistas =[]
   async function filtrarArtisgenerarArtistasporfavoritos(){
    
    preferencias = await obtenerPreferencias_por_Usuario();
    
    artistas= await obtenerAristasx()
    
    preferencias.forEach(favorito => {
        artistas.forEach(artista => {
            if (artista.codigo_codigo_artista === favorito.artista.codigo_artista) {
                artistasfav.push(cancion);

            }
          });
          
    });
    console.log(artistasfav)
    return artistasfav

   } 

   let todaslasArtisgenerarArtistas=[]
    async function generarArtistasx(){
        
    todaslasArtisgenerarArtistas=  await filtrarArtisgenerarArtistasporfavoritos();
    consol.log(todaslasArtisgenerarArtistas)
    todaslasArtisgenerarArtistas.forEach(artista=>{
        document.getElementById('contenido2').innerHTML +=`
    <a href="Artistas.html" class="card-link">
                    <div class="card">
                        <img class="circular-image" src="${artista.foto_perfil}" alt="Vibe Check">
                        <div class="card-buttons">
                            <button><i class="fas fa-play"></i></button>
                            <button><i class="fas fa-heart"></i></button>
                            <button><i class="fas fa-ellipsis-h"></i></button>
                        </div>
                        <div class="heading-4"><a class="chakra-link css-1nvflm0" title="vibe check">Metro Boomin</a></div>
                        <div class="heading-5-sub">547,950 seguidores</div>
                    </div>`

    }) }
    function playSong(songUrl) {

        const audioPlayer = document.getElementById('audio-player');
        audioPlayer.src = "src/"+songUrl;
        audioPlayer.play();
    }
    generarArtistasx();