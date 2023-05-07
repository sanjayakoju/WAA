import React from "react";
import {useLocation} from "react-router-dom";

const Result = () => {

    const {state: result} = useLocation();
     return (
         <div>
             <div>
                 Result : <span id="result">{result}</span>
             </div>
         </div>
     )
}

export default Result