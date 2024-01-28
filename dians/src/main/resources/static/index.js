var data = eval('('+'${items}'+')');
console.log(data)

var map = L.map('map').setView([41.6086, 21.7453], 13);

L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 15,
    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
}).addTo(map);

navigator.geolocation.watchPosition(success,error);

function success(pos){

    const lat= pos.coords.latitude;
    const lng = pos.coords.longitude;
    const accuracy = pos.coords.accuracy;

   let marker = L.marker([lat, lng]).addTo(map);
   let circle = L.circle([lat, lng], {radius: accuracy}).addTo(map);

   map.fitBounds(circle.getBounds())

}

function error(err){
    if(err.code === 1) {
        alert("Please allow geolocation access");
    }
    else{
        alert("Cannot get current location");
    }
}