
////////// status ///////////////
function traerReporteStatus() {
    console.log("test");
    $.ajax({
        url:"http://129.159.57.27:80/api/Reservation/report-status",
        //url: "http://localhost:80/api/Reservation/report-status",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            pintarRespuestaStatus(respuesta);
        }
    });
}
function pintarRespuestaStatus(respuesta) {

    let myTable = "<table>";
    myTable += "<tr>";
    myTable += "<td>" + respuesta.completed + "</td>";
    myTable += "<td>" + respuesta.cancelled + "</td>";
    myTable += "</table>";
    $("#miResultadoReservasStatus").html(myTable);
}

////////// data ///////////////
function traerReporteDate() {

    var fechaInicio = document.getElementById("RstarDate").value;
    var fechaCierre = document.getElementById("RdevolutionDate").value;
    console.log(fechaInicio);
    console.log(fechaCierre);

    $.ajax({
        //url: "http://localhost:80/api/Reservation/report-dates/" + fechaInicio + "/" + fechaCierre,
        url:"http://129.159.57.27:80/api/Reservation/report-dates/"+fechaInicio+"/"+fechaCierre,
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            pintarRespuestaDate(respuesta);
        }
    });
}
function pintarRespuestaDate(respuesta) {

    let myTable = "<table>";


    for (i = 0; i < respuesta.length; i++) {
        myTable += "<th>total</th>";
        myTable += "<td>" + respuesta[i].devolutionDate + "</td>";
        myTable += "<td>" + respuesta[i].startDate + "</td>";
        myTable += "<td>" + respuesta[i].status + "</td>";


        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#miResultadoReservasDate").html(myTable);
}


////////// cliente ///////////////
function traerReporteClientes() {
    $.ajax({
        url:"http://129.159.57.27:80/api/Reservation/report-clients",
        //url: "http://localhost:80/api/Reservation/report-clients",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            pintarRespuestaClientes(respuesta);
        }
    });
}
function pintarRespuestaClientes(respuesta) {

    let myTable = "<table>";
    myTable += "<tr>";

    for (i = 0; i < respuesta.length; i++) {
        myTable += "<td>" + respuesta[i].total + "</td>";
        myTable += "<td>" + respuesta[i].client.name + "</td>";
        myTable += "<td>" + respuesta[i].client.email + "</td>";
        myTable += "<td>" + respuesta[i].client.age + "</td>";

        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#miResultadoReservasClientes").html(myTable);
}
