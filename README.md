1) CREAR DISCO
  POST http://localhost:8080/discos/crear
   {
    "nombre" : "Disco"
}
2) CREAR ARTISTAS
   POST http://localhost:8080/artistas/crear?discoIds=1, .....,
   {
    "nombre" : "Roxette",
    "generos" : [],
    "paisOrigen": "hnkjh",
    "fechaNacimiento": "1958-05-30",
    "bibliografia": "JBJKBJB"
}

3) CREAR CANCION
  POST http://localhost:8080/canciones/crear?artistaId=1
 {
"nombre": "Roxete",
"letra": "dsfdsd",
"genero": "CLASICA"
 }

   
