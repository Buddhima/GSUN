/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//<script type="text/javascript">
    var myLatlng = new google.maps.LatLng(6.971154274048345,80.415863037109375); 
var myOptions = {
zoom: 8,
center: myLatlng,
mapTypeId: google.maps.MapTypeId.ROADMAP
}
map = new google.maps.Map(document.getElementById("gmap"), myOptions);
var marker;
//var markersArray = [];

//</script>
google.maps.event.addListener(map, 'center_changed', function() {
var location = map.getCenter();
//document.getElementById("lat").innerHTML = location.lat();
//document.getElementById("lon").innerHTML = location.lng();
// call function to reposition marker location
//placeMarker(location);

});
google.maps.event.addListener(map, "click", function(event) {
     //   var latitude = point.y;
       // var longitude = point.x;
//document.getElementById("lat").innerHTML = event.latLng.lat();
//document.getElementById("lon").innerHTML = event.latLng.lng();
document.getElementById("lat").value = event.latLng.lat();
document.getElementById("lon").value = event.latLng.lng();
//laceMarker(event.lanLng);
//map.clearOverlays();
//marker.setMap(null);
placeMarker(new google.maps.LatLng(event.latLng.lat(),event.latLng.lng()));
//placeMarker(event.lanLng);

        // do something with the lat/lng
    });
    
    function placeMarker(location){
      //  map.clearOverlays();
      //marker.setMap(null);
     
        
        
        marker=new google.maps.Marker({position:location,map:map,animation: google.maps.Animation.DROP});
         
        // markerArray.push(marker);
         
      
         
    }
    
//    marker = new google.maps.Marker({
//position: myLatlng,
//map: map
//});