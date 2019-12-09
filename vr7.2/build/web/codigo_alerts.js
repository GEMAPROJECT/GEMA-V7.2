$("#btn1").click(function()
        {
          Swal.fire({
             type:'error',
             title:'Hubo un fallo',
             text:'Algun dato no corresponde'
          });
        });

/*
function botonAlert()
{
    Swal.fire({
        type:'error',
        title:'Mensaje',
        text:'Ñero, funque, o me mato puta mierda'
    });
    return false;
}
        

function btn2
dim valor
valor =  msgbox ("Click en Aceptar devuelve 1 y recarga en 2 seg." &Chr(13) & Chr(10)& "Click en Cancelar devuelve 2 y no recarga.", 49, "Hizo Click en Recargar!.");
valor = 1;
If valor=1 Then
SetTimeOut "Self.Document.Location=Self.Location",2000,;
end If

end function
*/