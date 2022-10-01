import {
  FCardGlobal,
  FCardFlexGlobal,
} from '../../styles/globalStyle/CardGlobalStyle';

import { useEffect, useState } from 'react';

import {
  FCardStyle,
  FCardFlexStyle,
  FDescCardStyle,
} from '../../styles/components/CardStyle';

import { BigBtn } from '../../components/Button/Btns';
import { H4, H4Link } from '../Text/Head';
import axios from 'axios';
import StarsCalc from '../Calculator/StarsCalc';
import { TagGroup } from '../Group/BtnAndTagGroup';
import { useSelector } from 'react-redux';
import DistanceCalc from '../Calculator/DistanceCalc';

export const FBaseCard = ({ Detail }) => {
  const locationState = useSelector((state) => state.location);
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

  useEffect(() => {
    getFacilitiesAXIOS();
  }, []);

  return (
    <>
      {data.map((el, idx) => {
        return (
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
                  <H4Link to={`/facility/${el.facilityId}`}>{el.facilityName}</H4Link>
                  <div className="distance">
                    <DistanceCalc
                      currentLocation={locationState}
                      facilityLocation={el.location}
                    />
                  </div>
                </div>
                <div className="rest--wrapper">
                  {Detail ? (
                    <div className="address">
                      {el.address.split(' ')[0]} &nbsp;
                      {el.address.split(' ')[1]}
                    </div>
                  ) : (
                    ''
                  )}

                  <div className="stars">
                    {el.starRate && <StarsCalc starValue={el.starRate} />}
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

export const FacilityCard = ({ Flex, Detail }) => {
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
          <FBaseCard Detail={'Detail'} />
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
