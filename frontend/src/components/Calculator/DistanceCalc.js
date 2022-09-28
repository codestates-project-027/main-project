const DistanceCalc = (currentLocation) => {
  const test = currentLocation;
  const lat1 = currentLocation.currentLocation.latitude;
  const lng1 = currentLocation.currentLocation.longitude;
  const lat2 = Number(currentLocation.facilityLocation.split(',')[0]);
  const lng2 = Number(currentLocation.facilityLocation.split(',')[1]);

  function deg2rad(deg) {
    return deg * (Math.PI / 180);
  }

  const R = 6371; // Radius of the earth in km
  const dLat = deg2rad(lat2 - lat1);
  const dLon = deg2rad(lng2 - lng1);
  const a =
    Math.sin(dLat / 2) * Math.sin(dLat / 2) +
    Math.cos(deg2rad(lat1)) *
      Math.cos(deg2rad(lat2)) *
      Math.sin(dLon / 2) *
      Math.sin(dLon / 2);
  const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
  const distance = R * c; //distance in km, 유효자리 2자리
  const answer = distance < 1 ? (distance * 100).toFixed(0)*10+10 : distance.toFixed(1)+0.1;

  lat1 && lng1 && lat2 && lng2 && console.log(lat2);

  return (
    <div>
      {answer}&nbsp; {distance < 1 ? 'm 이내' : 'km 이내'}
    </div>
  );
  //console.log(test)=>    {currenLocation: {…}, facilityLocation: '33.450936, 126.569477'}
};
export default DistanceCalc;
