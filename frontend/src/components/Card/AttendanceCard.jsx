import { AttendanceCardStyle } from '../../styles/components/CardStyle';
const AttendanceCard = ({ days }) => {
  const date = [];
  for (let i = 0; i < days.length; i++) {
    date.push(<div key={i}>{i + 1}</div>);
  }

  return (
    <>
      <AttendanceCardStyle>
        <div className="wrapper">
          <div className="sub--wrapper">
            {date.map((el, idx) => {
              return (
                <div className="label" key={idx}>
                  {el}
                </div>
              );
            })}
          </div>

          <div className="sub--wrapper">
            {days.map((el, idx) => {
              return (
                <div
                  className="day"
                  key={idx}
                  style={
                    el === true
                      ? { background: 'lightgreen' }
                      : { background: 'lightgray' }
                  }
                />
              );
            })}
          </div>
        </div>
      </AttendanceCardStyle>
    </>
  );
};

export default AttendanceCard;
