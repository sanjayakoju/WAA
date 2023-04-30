import './App.css';
import CounterComponent from "./component/CounterComponent";
import {useState} from "react";


function App() {
    let [count, setCount] = useState(0);

    const callBack = (childData) => {
        count += childData;
        setCount(count);
    }
    return (
        <div>
            <header>
                <h3>{count}</h3> <br/>
                <table>
                    <tr>
                        <td>
                            <CounterComponent callCallBack={callBack} num={1} countNum={count}/>
                        </td>
                        &nbsp; &nbsp;
                        <td>
                            <CounterComponent callCallBack={callBack} num={3} countNum={count}/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <CounterComponent callCallBack={callBack} num={5} countNum={count}/>
                        </td>
                        &nbsp; &nbsp;
                        <td>
                            <CounterComponent callCallBack={callBack} num={8} countNum={count}/>
                        </td>
                    </tr>
                </table>
            </header>
        </div>
    );
}

export default App;
