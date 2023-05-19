
import './App.css';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import { Calculator } from './pages/Calculator';
import { Calcresult } from './pages/Calcresult';

function App() {
  return (
    <div>
<Router>
<Route exactpath={"/" } component={Calculator} />
        <Route path="/result" component={Calcresult} />
      </Router>       
    </div>

  );
}

export default App;
