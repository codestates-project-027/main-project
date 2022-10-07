import { useState, useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { getLocation } from '../redux/slices/locationSlice';

export const useCurrentLocation = (options = {}) => {
  const dispatch = useDispatch();
  // const locationState = useSelector((state) => state.location);
  const [location, setLocation] = useState();
  const [error, setError] = useState();

  const handleSuccess = (pos) => {
    const { latitude, longitude } = pos.coords;
    setLocation({
      latitude,
      longitude,
    });
  };

  const handleError = (error) => {
    setError(error.message);
  };

  useEffect(() => {
    const { geolocation } = navigator;
    if (!geolocation) {
      setError('Geolocation is not supported.');
      return;
    }
    geolocation.getCurrentPosition(handleSuccess, handleError);
    dispatch(getLocation({ currentLocation: location }));
  }, []);
};

export default useCurrentLocation;
