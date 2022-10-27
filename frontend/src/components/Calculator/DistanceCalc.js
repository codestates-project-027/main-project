const DistanceCalc = ({ currentLocation, facilityLocation }) => {
  const lat1 = currentLocation.currentLocation.latitude;
  const lng1 = currentLocation.currentLocation.longitude;
  const lat2 = facilityLocation && Number(facilityLocation.split(',')[0]);
  const lng2 = facilityLocation && Number(facilityLocation.split(',')[1]);
  // latitude: 37.47814, longitude: 126.8605
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

  return (
    <div>
      {distance <= 0.2
        ? `~ ${(distance * 100).toFixed(0) * 10 + 10} m`
        : distance >= 0.2 && distance < 1
        ? `${(distance * 1000).toFixed(0)} m`
        : `${distance.toFixed(1)} km`}
    </div>
  );
};
export default DistanceCalc;
