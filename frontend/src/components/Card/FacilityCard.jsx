import styled from 'styled-components';
import { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import { BigBtn } from '../../components/Button/Btns';
import { H4, H4Link } from '../Text/Head';
import { TagGroup } from '../Group/BtnAndTagGroup';
import { useSelector } from 'react-redux';
import { getFacilities } from '../../redux/slices/facilityListSlice';
import DistanceCalc from '../Calculator/DistanceCalc';
import StarsCalc from '../Calculator/StarsCalc';

import {
  FCardGlobal,
  FCardFlexGlobal,
} from '../../styles/globalStyle/CardGlobalStyle';

import {
  FCardStyle,
  FCardFlexStyle,
  FDescCardStyle,
} from '../../styles/components/CardStyle';
import axiosInstance from '../../api/Interceptor';

export const FBaseCard = ({ Detail, mode, fin, setFin }) => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const { id } = useParams();
  const locationState = useSelector((state) => state.location);
  const [error, setError] = useState(false);
  const [data, setData] = useState([
    {
      facilityId: 0,
      facilityName: '',
      facilityPhoto: [],
      address: '',
      starRate: 0,
      location: '',
      categoryList: [],
      facilityStatus: '',
    },
  ]);

  const getFacilitiesAXIOS = async () => {
    await axiosInstance
      .get(
        '/facility?location=' +
          locationState.currentLocation.latitude +
          '%2C' +
          locationState.currentLocation.longitude +
          '&page=1'
      )
      .then((res) => setData(res.data.content));
  };

  const getCategoryAXIOS = async () => {
    try {
      await axiosInstance
        .get('/category/' + id + '?page=1')
        .then((res) => setData(res.data.content));
    } catch (err) {
      setError(true);
      if (err.response.status === 500) {
        alert(`해당 카테고리의 시설이 없습니다`);
        navigate('/');
      }
    }
  };

  useEffect(() => {
    mode === 'category' ? getCategoryAXIOS() : getFacilitiesAXIOS();
  }, [fin]);

  return (
    <>
      {data.map((el) => {
        return el.facilityName === '' ? null : (
          <div key={el.facilityId}>
            <div className="wrapper">
              <div className="img--wrapper">
                <img
                  src={el.facilityPhoto}
                  width={'180px'}
                  height={'150px'}
                  alt="facility"
                />
              </div>
              <div className="content--wrapper">
                <div className="name--wrapper">
                  <H4Link to={`/facility/${el.facilityId}`}>
                    {el.facilityName}
                  </H4Link>
                  <div className="distance">
                    <DistanceCalc
                      currentLocation={locationState}
                      facilityLocation={el.location}
                    />
                  </div>
                </div>
                <div className="rest--wrapper">
                  {Detail ? <div className="address">{el.address}</div> : ''}

                  <div className="stars">
                    {el.starRate === 0 ? (
                      ''
                    ) : (
                      <StarsCalc starValue={el.starRate} />
                    )}
                  </div>
                  <div className="tags">
                    <TagGroup
                      tags={el.categoryList.slice(0, 4)}
                      fin={fin}
                      setFin={setFin}
                    />
                  </div>
                </div>
              </div>
            </div>
          </div>
        );
      })}
    </>
  );
};

export const FacilityCard = ({ Flex, Detail, mode, fin, setFin }) => {
  return Flex ? (
    <>
      <FCardFlexGlobal>
        <FCardFlexStyle>
          <FBaseCard fin={fin} setFin={setFin} />
        </FCardFlexStyle>
      </FCardFlexGlobal>
    </>
  ) : Detail ? (
    <>
      <FCardFlexGlobal>
        <FCardFlexStyle>
          <FBaseCard Detail={'Detail'} mode={mode} fin={fin} setFin={setFin} />
        </FCardFlexStyle>
      </FCardFlexGlobal>
    </>
  ) : (
    <>
      <FCardGlobal>
        <FCardStyle>
          <FBaseCard fin={fin} setFin={setFin} />
        </FCardStyle>
      </FCardGlobal>
    </>
  );
};

export const FacilityDescCard = ({
  text,
  backGround,
  color,
  el,
  show,
  fin,
  setFin,
}) => {
  const checkLocation = useSelector((state) => state.location.currentLocation);
  const dailyCheck = async () => {
    const body = {
      username: 'minimiUser',
      location: `${checkLocation.latitude}, ${checkLocation.longitude}`,
      facilityId: el.facilityId,
    };
    try {
      await axiosInstance.post('/dailycheck', body);
      alert(`출석 되었습니다.`);
      setFin(!fin);
    } catch (err) {
      alert(`Location failure: 현재 위치가 해당 시설과 멀리 있습니다.`);
    }
  };

  const cancelMyFac = async () => {
    await axiosInstance.delete('/myfacility/' + el.facilityId + '/minimiUser');
    alert(`나의 운동시설에서 삭제되었습니다.`);
    setFin(!fin);
  };

  return (
    <>
      <FDescCardStyle>
        <H4 alignItems="center">{el.facilityName}</H4>
        <BtnWrapper>
          <BigBtn onClick={dailyCheck} backGround={backGround} color={color}>
            {text}
          </BigBtn>
          {show ? (
            <BigBtn
              onClick={cancelMyFac}
              marginLeft="10px"
              padding={'13px'}
              backGround={'black'}
              color={'red'}
              hoverBg={'black'}
            >
              삭제
            </BigBtn>
          ) : null}
        </BtnWrapper>
      </FDescCardStyle>
    </>
  );
};

const BtnWrapper = styled.div`
  display: flex;
  align-items: center;
`;
