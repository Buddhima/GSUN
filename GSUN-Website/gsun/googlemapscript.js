// JavaScript Document


  var myLatlng = new google.maps.LatLng(6.971154274048345,80.415863037109375); 
var myOptions = {
zoom: 8,
center: myLatlng,
mapTypeId: google.maps.MapTypeId.ROADMAP
}
map = new google.maps.Map(document.getElementById("google_map"), myOptions);
var marker;
var markersArray = [];


//google.maps.event.addListener(map, 'center_changed', function() {
//var location = map.getCenter();
//});

google.maps.event.addListener(map, "click", function(event) {
     //marker.setMap(null);
document.getElementById("latitude").value = event.latLng.lat();
document.getElementById("longitude").value = event.latLng.lng();

placeMarker(new google.maps.LatLng(event.latLng.lat(),event.latLng.lng()));

    });
    
    function placeMarker(location){
   
        
        marker=new google.maps.Marker({position:location,map:map,animation: google.maps.Animation.DROP});
        markersArray.push(marker);
       
      
         
    }
    
    function clearMarkers(){
       if (markersArray) {
    for (i in markersArray) {
      markersArray[i].setMap(null);
    }
  }
        
    }
    
