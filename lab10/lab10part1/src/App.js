import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Page1 from "./pages/Page1";
import Page2 from "./pages/Page2";
import {Page3} from "./pages/Page3";
import Page4 from "./pages/Page4";

function App() {
    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Page1/>}/>
                    <Route path="/pagetwo" element={<Page2/>}/>
                    <Route path="/pagethree" element={<Page3/>}/>
                    <Route path="/pagefour" element={<Page4/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
