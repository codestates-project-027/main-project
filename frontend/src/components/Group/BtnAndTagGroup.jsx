import { MainPageBIGroupStyle } from '../../styles/components/ComponentGroupStyle';
import { FacilityPageDescGroupStyle } from '../../styles/components/ComponentGroupStyle';

import { MainQuickBtn } from '../Button/Btns';
import { H4 } from '../../components/Text/Head';

import { TagStyle } from '../../styles/components/TagStyle';
import styled from 'styled-components';

import axiosInstance from '../../api/Interceptor';
import { useNavigate, Link } from 'react-router-dom';

export const MainQuickBtnGroup = ({ category }) => {
  return (
    <>
      <MainPageBIGroupStyle>
        {category.map((el, idx) => {
          return (
            <StyledLink key={idx} to={`/category/${el.code}`}>
              <MainQuickBtn
                key={el.idx}
                textProp={el.text}
                iconProp={el.icon}
              />
            </StyledLink>
          );
        })}
      </MainPageBIGroupStyle>
    </>
  );
};

export const FacilityDescGroup = ({ facility }) => {
  return (
    <FacilityPageDescGroupStyle>
      {facility.map((el) => {
        return (
          <H4 key={el.idx}>
            {el.icon} {el.value}
          </H4>
        );
      })}
    </FacilityPageDescGroupStyle>
  );
};

export const TagGroup = ({
  tags,
  tagsList,
  setTagsList,
  close,
  backGround,
  margin,
}) => {
  const navigate = useNavigate();
  const handleRemove = (idxToRemove) => {
    setTagsList(tagsList.filter((_, index) => index !== idxToRemove));
  };

  const moveTo = async (el) => {
    const response = await axiosInstance('/category?active=false').then(
      (res) => res.data
    );

    for (let i = 0; i < response.length; i++) {
      if (response[i].categoryTitle === el) {
        navigate(`/category/${response[i].categoryCode}`);
      }
    }
  };

  return (
    <>
      {tags.map((el, idx) => {
        return (
          <TagStyle backGround={backGround} margin={margin} key={idx}>
            {close ? (
              <>{el}</>
            ) : (
              <div
                onClick={() => {
                  moveTo(el);
                }}
              >
                {el}
              </div>
            )}
            {close ? <X onClick={() => handleRemove(idx)}>x</X> : null}
          </TagStyle>
        );
      })}
    </>
  );
};

const X = styled.div`
  line-height: 17px;
  background: white;
  width: 20px;
  border-radius: 100%;
  margin-left: 5px;
  cursor: pointer;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
`;
