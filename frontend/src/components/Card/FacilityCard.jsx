import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { BigBtn } from '../../components/Button/Btns';
import { H4, H4Link } from '../Text/Head';
import { TagGroup } from '../Group/BtnAndTagGroup';
import { useSelector } from 'react-redux';
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

export const FBaseCard = ({ Detail, mode }) => {
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
    await axios
      .get('http://localhost:8080/facility')
      .then((res) => setData(res.data));
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
  }, []);

  return (
    <>
      {data.map((el) => {
        return el.facilityName === '' ? (
          ''
        ) : (
          <div key={el.facilityId}>
            {el.facilityId}
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
                    <TagGroup tags={el.categoryList.slice(0, 3)} />
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

export const FacilityCard = ({ Flex, Detail, mode }) => {
  return Flex ? (
    <>
      <FCardFlexGlobal>
        <FCardFlexStyle>
          <FBaseCard />
        </FCardFlexStyle>
      </FCardFlexGlobal>
    </>
  ) : Detail ? (
    <>
      <FCardFlexGlobal>
        <FCardFlexStyle>
          <FBaseCard Detail={'Detail'} mode={mode} />
        </FCardFlexStyle>
      </FCardFlexGlobal>
    </>
  ) : (
    <>
      <FCardGlobal>
        <FCardStyle>
          <FBaseCard />
        </FCardStyle>
      </FCardGlobal>
    </>
  );
};

export const FacilityDescCard = ({ text, backGround, color }) => {
  return (
    <>
      <FDescCardStyle>
        <H4 alignItems="center">OO동 헬스클럽</H4>
        <BigBtn backGround={backGround} color={color}>
          {text}
        </BigBtn>
      </FDescCardStyle>
    </>
  );
};
