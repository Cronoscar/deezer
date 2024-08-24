const obtenerUsuarios = async () => {
    let url = `http://localhost:8080/Usuarios/todos`
    const resultado = await fetch(url, {
        method: 'GET',
        body : {

        }
    })

    const usuarios = await resultado.json();

    console.log(usuarios)
}
let correo ;
const ObtenerUsuario = async () => {
     let url = `http://localhost:8080/Usuarios/correo/${correo}`
    const resultado = await fetch(url, {
        method: 'GET'
    })

    const usuario = await resultado.json();
    console.log(usuario)
    
    localStorage.setItem('usuario', JSON.stringify(usuario));
    
    
}
const crearUsuario = async () => {
    let url = 'http://localhost:8080/Usuarios/crear';

    /*let usuario = {
        "codigo_usuario": 10,
        "nombre": "Socrates",
        "apellido": "Athenas",
        "foto_perfil": "asd",
        "fecha_de_nacimiento": "2024-08-15T23:23:25.000+00:00",
        "fecha_registro": "2024-08-15T23:23:31.000+00:00",
        "usuario": "Fuera JOH",
        "correo": "qeqw@GMAIL.COM",
        "contrasena": "uwu",
        "tipo_usuario": {
            "codigo_tipo_usuario": 1,
            "tipo_usuario": "Usuario Normal"
        },
        "genero": {
            "codigo_genero": 1,
            "tipo_genero": "Masculino"
        },
        "plan": {
            "codigo_plan": 1,
            "fecha_inicio": "2024-08-15T23:13:15.000+00:00",
            "fecha_fin": "2024-08-31T23:13:19.000+00:00",
            "precio": 3000,
            "periodo": {
                "codigo_periodo": 1,
                "tipo_periodo": "Mensual"
            },
            "sucripcion": {
                "codigo_sucripcion": 1,
                "tipo_suscripcion": "FREE"
            }
        }
    };

    try {
        const resultado = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(usuario)
        });

        if (!resultado.ok) {
            const errorText = await resultado.text(); // Obtener el cuerpo de la respuesta como texto
            throw new Error(errorText); // Lanzar el texto de error
        }

        const data = await resultado.json();
        console.log('Usuario creado:', data);
    } catch (error) {
        console.error('Hubo un problema con la solicitud:', error.message);
        alert(error.message); // Mostrar el mensaje de error específico en la interfaz de usuario

        let inicio = await error.message('"') + 1; // Posición justo después de la primera comilla
        let fin = await error.message('"', inicio); // Posición de la segunda comilla

        // Extrae el texto entre las comillas
        let mensaje =await texto.substring(inicio, fin);
        console.log(mensaje)
    }
}

crearUsuario();

*/

//{
//    message: 'usuario ya existe',
    //codigoResultado: 0,
   // resultado: null
//}

const iniciarSesion = async (usuario, contrasena) => {
    const url = 'http://localhost:8080/Usuarios/login'; // URL del endpoint de login

    const credenciales = {
        usuario: usuario,
        contrasena: contrasena
    };

    try {
        const respuesta = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(credenciales)
        });

        if (!respuesta.ok) {
            const errorText = await respuesta.text();
            throw new Error(errorText);
        }

        const data = await respuesta.json();
        console.log('Inicio de sesión exitoso:', data);
        // Aquí puedes almacenar el token o los datos del usuario en el almacenamiento local
        localStorage.setItem('token', data.token); // Por ejemplo, si el servidor devuelve un token

    } catch (error) {
        console.error('Error en el inicio de sesión:', error.message);
        alert(error.message); // Mostrar el mensaje de error en la interfaz de usuario
    }
};

// Llamar a la función de inicio de sesión con las credenciales del usuario
//iniciarSesion('usuarioEjemplo', 'contrasenaEjemplo')

}
const login = async (e) => {
    e.preventDefault(); // Evitar la recarga de la página

    const payload = {
        correo: document.getElementById('inptucorreo').value,
        contrasena: document.getElementById('inputPassword').value
    };

    console.log(payload)

    try {
        const result = await fetch('http://localhost:8080/Usuarios/login', {
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
            correo = payload.correo
            await ObtenerUsuario();
            window.location.href = 'inicio.html';
        }
    } catch (error) {
        console.error("Error durante la autenticación:", error);
        alert("Fallo al autenticar");
    }
};

// Asociar el evento al botón de inicio
document.getElementById('botondeinicio').addEventListener('click', login);