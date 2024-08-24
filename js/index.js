let todaslascanciones = [];
const obtenerobtenercanciones = async () => {
    let url = `http://localhost:8080/canciones/todas`
    const resultado = await fetch(url, {
        method: 'GET',
        
    })

    const canciones = await resultado.json();
    todaslascanciones = canciones;
    console.log(canciones)
    generarCanciones();


}
obtenerobtenercanciones();
function generarCanciones(){

    todaslascanciones.forEach(cancion=>{
        document.getElementById('contenido').innerHTML +=`
        
        <div class="card col-3" onclick="playSong('${cancion.url}')">
    <img src="${cancion.portada}" alt="Music Quiz">
    <h3>${cancion.nombre}</h3>
    </div>
        
        `

    })
}
function playSong(songUrl) {

    const audioPlayer = document.getElementById('audio-player');
    audioPlayer.src = "src/"+songUrl;
    audioPlayer.play();
}

