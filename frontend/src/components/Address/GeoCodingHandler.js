import Geocode from 'react-geocode';

Geocode.setApiKey(process.env.REACT_APP_GOOGLE_API_KEY);
Geocode.setLanguage('ko');
Geocode.setRegion('ko');
Geocode.enableDebug();

const GoogleMap = async (currentAddress) => {
  return Geocode.fromAddress(currentAddress)
    .then((res) => {
      const { lat, lng } = res.results[0].geometry.location;
      console.log(lat, lng);
    })
    .catch((err) => console.log(err));
};

export default GoogleMap;
