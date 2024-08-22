var artistas= [
    {
        nombreArtista: 'Joji',
        urlImagen:'img/1.jpg',
        
    },   {
        nombreArtista: 'Ysy A',
        urlImagen:'img/2.jpg',
        
    },{
        nombreArtista: 'Duki',
        urlImagen:'img/3.jpg',
        
    }
    ,{
        nombreArtista: 'Milo j',
        urlImagen:'img/4.jpg',
        
    },{
        nombreArtista: 'Lit Killah',
        urlImagen:'img/5.jpg',
        
    },{
        nombreArtista: 'Trueno',
        urlImagen:'img/6.jpg',
        
    },{
        nombreArtista: 'Ed Maverick',
        urlImagen:'img/7.jpg',
        
    },{
        nombreArtista: 'Mon Laferte',
        urlImagen:'img/8.jpg',
        
    },{
        nombreArtista: 'Kevin Karl',
        urlImagen:'img/9.jpg',
        
    },{
        nombreArtista: 'Billie Eilish',
        urlImagen:'img/10.jpg',
        
    },{
        nombreArtista: 'Esteman',
        urlImagen:'img/11.jpg',
        
    },{
        nombreArtista: 'Jósean Log',
        urlImagen:'img/12.jpg',
        
    }



];
var generos =[

    {
        nombreGenero:'Pop',
        urlGenero:'algunaurl'
    },{
        nombreGenero:'Latino',
        urlGenero:'algunaurl'
    },{
        nombreGenero:'Soul & Funk',
        urlGenero:'algunaurl'
    },{
        nombreGenero:'Rock',
        urlGenero:'algunaurl'
    },{
        nombreGenero:'Rap/Hip Hop',
        urlGenero:'algunaurl'
    },{
        nombreGenero:'Reggaeton',
        urlGenero:'algunaurl'
    },{
        nombreGenero:'R&B',
        urlGenero:'algunaurl'
    },{
        nombreGenero:'Blues',
        urlGenero:'algunaurl'
    },{
        nombreGenero:'Musica tradicional mexicana',
        urlGenero:'algunaurl'
    },{
        nombreGenero:'Alternativo',
        urlGenero:'algunaurl'
    }

];
let Todo_Artistas;
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
        generarArtistas(); // Llamar a la función para generar los artistas

    } catch (error) {
        console.error('Hubo un problema al obtener los artistas:', error);
    }
};

obtenerAristas();

function generarArtistas(){
    
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
function generarGeneros(){
    generos.forEach(genero => {
        document.getElementById('generos').innerHTML+=`<div class="genero"> ${genero.nombreGenero} </div>`;
        
    });
}
generarGeneros();
