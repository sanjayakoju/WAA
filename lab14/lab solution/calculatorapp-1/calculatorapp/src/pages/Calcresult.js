import React from 'react';
export const Calcresult = (props) => {
    const resultvalue = props.location.state.result;


  let result = (
    <>
      <h3>Result of the calculation =</h3>
      <h3 id="result">{resultvalue}</h3>
      <br />
      <br />
     
    </>
  );
  return result;
}
